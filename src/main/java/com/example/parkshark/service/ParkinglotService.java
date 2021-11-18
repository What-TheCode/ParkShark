package com.example.parkshark.service;

import com.example.parkshark.domain.dto.parkinglot.CreateParkinglotDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDetailDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDto;
import com.example.parkshark.domain.parkinglot.Parkinglot;
import com.example.parkshark.exceptions.InvalidEmailException;
import com.example.parkshark.exceptions.InvalidTelephoneException;
import com.example.parkshark.mapper.ParkinglotMapper;
import com.example.parkshark.repository.DivisionRepository;
import com.example.parkshark.repository.ParkinglotRepository;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class ParkinglotService {

    private final ParkinglotRepository parkinglotRepository;
    private final ParkinglotMapper parkinglotMapper;

    @Autowired
    public ParkinglotService(ParkinglotRepository parkinglotRepository,
                             ParkinglotMapper parkinglotMapper) {
        this.parkinglotRepository = parkinglotRepository;
        this.parkinglotMapper = parkinglotMapper;
    }


    public void createParkinglot(CreateParkinglotDto createParkinglotDto) {
        hasValidEmailAddress(createParkinglotDto.getContactPerson().getEmail());
        hasValidTelephone(createParkinglotDto.getContactPerson().getTelephone(),
                createParkinglotDto.getContactPerson().getMobileTelephone());

        parkinglotRepository.save(parkinglotMapper.toEntity(createParkinglotDto));
    }

    public List<ParkinglotDto> getAll() {
        return parkinglotMapper.toDto(parkinglotRepository.findAll());
    }

    public ParkinglotDetailDto getById(String id) {
        int currentId = Integer.parseInt(id);
        Parkinglot parkinglot = parkinglotRepository.findById(currentId).orElse(null);

        if(parkinglot == null) {
            throw new EntityNotFoundException("Parkinglot not found.");
        }

        return parkinglotMapper.toDetailDto(parkinglot);
    }


    //HELPER METHODS
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
        try {
            Integer.parseInt(telephone);
        } catch (NumberFormatException ex) {
            return false;
        }

        Phonenumber.PhoneNumber number = new Phonenumber.PhoneNumber();
        number.setNationalNumber(Integer.parseInt(telephone));
        number.setCountryCode(32);

        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        phoneUtil.isPossibleNumberForType(number, PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE);

        return phoneUtil.isPossibleNumber(number);
    }
}
