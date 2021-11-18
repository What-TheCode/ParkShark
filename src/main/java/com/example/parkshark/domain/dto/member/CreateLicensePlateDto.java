package com.example.parkshark.domain.dto.member;

public class CreateLicensePlateDto {

    private String licensePlateNumber;
    private String issuingCountry;

    public CreateLicensePlateDto() {
    }

    public CreateLicensePlateDto(String licensePlateNumber, String issuingCountry) {
        this.licensePlateNumber = licensePlateNumber;
        this.issuingCountry = issuingCountry;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }
}
