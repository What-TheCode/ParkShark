package com.example.parkshark.service;

import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.dto.parkinglot.CreateParkinglotDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDetailDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDto;
import com.example.parkshark.domain.parkinglot.Parkinglot;
import com.example.parkshark.domain.parkinglot.ParkinglotCategory;
import com.example.parkshark.exceptions.*;
import com.example.parkshark.helperClasses.NumericCheck;
import com.example.parkshark.mapper.ParkinglotMapper;
import com.example.parkshark.repository.DivisionRepository;
import com.example.parkshark.repository.ParkinglotRepository;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;

@Service
@Transactional
public class ParkinglotService {

    private final ParkinglotRepository parkinglotRepository;
    private final DivisionRepository divisionRepository;
    private final ParkinglotMapper parkinglotMapper;

    private final Logger logger = LoggerFactory.getLogger(ParkinglotService.class);

    @Autowired
    public ParkinglotService(ParkinglotRepository parkinglotRepository,
                             DivisionRepository divisionRepository,
                             ParkinglotMapper parkinglotMapper) {
        this.parkinglotRepository = parkinglotRepository;
        this.divisionRepository = divisionRepository;
        this.parkinglotMapper = parkinglotMapper;
    }

    public void createParkinglot(CreateParkinglotDto createParkinglotDto) {
        inputValidation(createParkinglotDto);

        Division division = this.divisionRepository.getById(createParkinglotDto.getDivisionId());

        parkinglotRepository.save(parkinglotMapper.toEntity(createParkinglotDto, division));
        this.logger.info("Parkinglot created.");
    }

    public List<ParkinglotDto> getAll() {
        return parkinglotMapper.toDto(parkinglotRepository.findAll());
    }

    public ParkinglotDetailDto getById(String id) {
        if (!NumericCheck.isInteger(id)) {
            throw new InvalidIdException(String.format("Id %s not found.", id));
        }
        int currentId = Integer.parseInt(id);

        Parkinglot parkinglot = parkinglotRepository.findById(currentId).orElse(null);
        if (parkinglot == null) {
            throw new ParkinglotDoesNotExistException(String.format("Parkinglot with id %s not found.", id));
        }

        return parkinglotMapper.toDetailDto(parkinglot);
    }


    //HELPER METHODS
    private void inputValidation(CreateParkinglotDto createParkinglotDto) {
        hasValidEmailAddress(createParkinglotDto.getContactPerson().getEmail());
        hasValidTelephone(createParkinglotDto.getContactPerson().getTelephone(),
                createParkinglotDto.getContactPerson().getMobileTelephone());
        hasValidCategory(createParkinglotDto.getCategory());
        hasValidDivisionId(createParkinglotDto.getDivisionId());
    }

    private void hasValidEmailAddress(String emailaddress) {
        try {
            InternetAddress emailAddr = new InternetAddress(emailaddress);
            emailAddr.validate();
        } catch (AddressException ex) {
            throw new InvalidEmailException("Not a valid emailaddress.");
        }
    }

    private void hasValidTelephone(String telephone, String mobileTelephone) {
        if (telephone == null && mobileTelephone == null) {
            throw new InvalidTelephoneException("Contactperson should have at least one telephone number.");
        }

        if (!hasValidTelephoneNumber(telephone) && !hasValidTelephoneNumber(mobileTelephone)) {
            throw new InvalidTelephoneException("Telephone number not valid");
        }
    }

    private boolean hasValidTelephoneNumber(String telephone) {
        if (!NumericCheck.isInteger(telephone)) {
            return false;
        }

        Phonenumber.PhoneNumber number = new Phonenumber.PhoneNumber();
        number.setNationalNumber(Integer.parseInt(telephone));
        number.setCountryCode(32);

        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        phoneUtil.isPossibleNumberForType(number, PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE);

        return phoneUtil.isPossibleNumber(number);
    }

    private void hasValidCategory(String category) {
        if (!category.trim().equalsIgnoreCase(ParkinglotCategory.UNDERGROUND.getType())
                && !category.trim().equalsIgnoreCase(ParkinglotCategory.ABOVEGROUND.getType()))
        {
            throw new ParkinglotCategoryDoesNotExistException(
                    String.format("Parkinglot category %s does not exist.", category));
        }
    }


    private void hasValidDivisionId(int divisionId) {
        if (this.divisionRepository.findById(divisionId).isEmpty()) {
            throw new DivisionDoesNotExistException(String.format("Division with id %s not found.", divisionId));
        }
    }
}
