package com.example.parkshark.domain.dto.member;

import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.member.Membership;

import java.time.LocalDateTime;

public class CreateMemberWithPersonDto {

    private Person person;
    private CreateLicensePlateDto createLicensePlateDto;
    private LocalDateTime registrationDate;
    private Membership membershipLevel;

    public CreateMemberWithPersonDto(Person person, CreateLicensePlateDto createLicensePlateDto, LocalDateTime registrationDate, Membership membershipLevel) {
        this.person = person;
        this.createLicensePlateDto = createLicensePlateDto;
        this.registrationDate = registrationDate;
        this.membershipLevel = membershipLevel;
    }

    public Person getPerson() {
        return person;
    }

    public CreateLicensePlateDto getCreateLicensePlateDto() {
        return createLicensePlateDto;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public Membership getMembershipLevel() {
        return membershipLevel;
    }
}
