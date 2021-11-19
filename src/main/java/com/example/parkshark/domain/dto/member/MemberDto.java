package com.example.parkshark.domain.dto.member;

import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.dto.person.PersonDto;
import com.example.parkshark.domain.member.Membership;

import java.time.LocalDateTime;

public class MemberDto {

    private int id;
    private PersonDto personDto;
    private LicensePlateDto LicensePlateDto;
    private LocalDateTime registrationDate;
    private String membershipLevel;

    public MemberDto(int id, PersonDto personDto,
                     LicensePlateDto licensePlateDto,
                     LocalDateTime registrationDate,
                     String membershipLevel) {
        this.id = id;
        this.personDto = personDto;
        LicensePlateDto = licensePlateDto;
        this.registrationDate = registrationDate;
        this.membershipLevel = membershipLevel;
    }

    public int getId() {
        return id;
    }

    public PersonDto getPerson() {
        return personDto;
    }

    public com.example.parkshark.domain.dto.member.LicensePlateDto getLicensePlateDto() {
        return LicensePlateDto;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }
}
