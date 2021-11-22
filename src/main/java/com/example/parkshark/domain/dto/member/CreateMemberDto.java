package com.example.parkshark.domain.dto.member;

public class CreateMemberDto {

    private int personId;
    private CreateLicensePlateDto createLicensePlateDto;
    private String membershipLevel;

    public CreateMemberDto(int personId, CreateLicensePlateDto createLicensePlateDto, String membershipLevel) {
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
