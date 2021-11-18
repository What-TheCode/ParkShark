package com.example.parkshark.domain.dto.member;

public class LicensePlateDto {

    private int id;
    private String licensePlateNumber;
    private String issuingCountry;

    public LicensePlateDto(int id, String licensePlateNumber, String issuingCountry) {
        this.id = id;
        this.licensePlateNumber = licensePlateNumber;
        this.issuingCountry = issuingCountry;
    }

    public int getId() {
        return id;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }
}
