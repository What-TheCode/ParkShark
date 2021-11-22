package com.example.parkshark.domain.dto.member;

import com.example.parkshark.domain.member.Member;

public class LicensePlateDto {

    private int id;
    private String licensePlateNumber;
    private String issuingCountry;

    private LicensePlateDto() {

    }

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


    public static class Builder {

        private int id;
        private String licensePlateNumber;
        private String issuingCountry;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withLicensePlateNumber(String licensePlateNumber) {
            this.licensePlateNumber = licensePlateNumber;
            return this;
        }
        public Builder withIssuingCountry(String issuingCountry) {
            this.issuingCountry = issuingCountry;
            return this;
        }

        public LicensePlateDto build() {
            LicensePlateDto licensePlateDto = new LicensePlateDto();
            licensePlateDto.licensePlateNumber = this.licensePlateNumber;
            licensePlateDto.issuingCountry = this.issuingCountry;

            return licensePlateDto;
        }
    }
}
