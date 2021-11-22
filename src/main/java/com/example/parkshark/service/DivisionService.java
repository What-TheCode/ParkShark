package com.example.parkshark.service;

import com.example.parkshark.domain.dto.division.CreateDivisionDto;
import com.example.parkshark.domain.dto.division.DivisionDto;
import com.example.parkshark.domain.dto.parkinglot.CreateParkinglotDto;
import com.example.parkshark.domain.parkinglot.ParkinglotCategory;
import com.example.parkshark.exceptions.*;
import com.example.parkshark.helperClasses.NumericCheck;
import com.example.parkshark.mapper.DivisionMapper;
import com.example.parkshark.repository.DivisionRepository;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DivisionService {

    private final DivisionRepository divisionRepository;
    private final DivisionMapper divisionMapper;

    public DivisionService(DivisionRepository divisionRepository, DivisionMapper divisionMapper) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
    }

    public List<DivisionDto> findAll() {
        return divisionMapper.toDto(divisionRepository.findAll());
    }

    public void saveDivision(CreateDivisionDto createDivisionDto) {
        inputValidation(createDivisionDto);
        divisionRepository.save(divisionMapper.toEntity(createDivisionDto));
    }

    public DivisionDto findById(int id) {
        if (divisionRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("There is no division with this id.");
        }
        return divisionMapper.toDto(divisionRepository.getById(id));
    }


    //HELPER METHODS
    public void inputValidation(CreateDivisionDto createDivisionDto) {
        hasValidEmailAddress(createDivisionDto.getDirector().getEmail());
        hasValidTelephone(createDivisionDto.getDirector().getTelephone(),
                createDivisionDto.getDirector().getMobileTelephone());
        hasValidParentDivisionId(createDivisionDto.getParentdivisionId());
    }

    public void hasValidEmailAddress(String emailaddress) {
        if (!EmailValidator.getInstance().isValid(emailaddress)) {
            throw new InvalidEmailException("Not a valid emailaddress.");
        }
    }

    public void hasValidTelephone(String telephone, String mobileTelephone) {
        if (telephone == null && mobileTelephone == null) {
            throw new InvalidTelephoneException("Contactperson should have at least one telephone number.");
        }

        if (!hasValidTelephoneNumber(telephone) && !hasValidTelephoneNumber(mobileTelephone)) {
            throw new InvalidTelephoneException("Telephone number not valid");
        }
    }

    public boolean hasValidTelephoneNumber(String telephone) {
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

    private void hasValidParentDivisionId(Integer parentdivisionId) {
        if (parentdivisionId == null) return;
        if (this.divisionRepository.findById(parentdivisionId).isEmpty()) {
            throw new InvalidParentDivisionException(String.format("Parent division with id %s does not exist.", parentdivisionId));
        }
    }
}
