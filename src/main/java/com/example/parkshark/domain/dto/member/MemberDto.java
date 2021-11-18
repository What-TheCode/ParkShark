package com.example.parkshark.domain.dto.member;

import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.member.Membership;

import java.time.LocalDateTime;

public class MemberDto {

    private int id;
    private Person person;
    private LicensePlateDto LicensePlateDto;
    private LocalDateTime registrationDate;
    private String membershipLevel;

    public MemberDto(int id, Person person,
                     LicensePlateDto licensePlateDto,
                     LocalDateTime registrationDate,
                     String membershipLevel) {
        this.id = id;
        this.person = person;
        LicensePlateDto = licensePlateDto;
        this.registrationDate = registrationDate;
        this.membershipLevel = membershipLevel;
    }

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
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
