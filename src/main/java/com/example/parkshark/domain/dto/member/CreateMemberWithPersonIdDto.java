package com.example.parkshark.domain.dto.member;

import com.example.parkshark.domain.member.Membership;

import java.time.LocalDateTime;

public class CreateMemberWithPersonIdDto {

    private int personId;
    private CreateLicensePlateDto createLicensePlateDto;
    private String membershipLevel;

    public CreateMemberWithPersonIdDto(int personId, CreateLicensePlateDto createLicensePlateDto, String membershipLevel) {
        this.personId = personId;
        this.createLicensePlateDto = createLicensePlateDto;
        this.membershipLevel = membershipLevel;
    }

    public int getPersonId() {
        return personId;
    }

    public CreateLicensePlateDto getCreateLicensePlateDto() {
        return createLicensePlateDto;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }
}
