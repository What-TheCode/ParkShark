package com.example.parkshark.domain.dto.address;

import com.example.parkshark.domain.dto.person.PersonDto;

public class AddressDto {
    private String streetName;
    private int streetNumber;
    private PostalCodeDto postalCode;

    public AddressDto(String streetName, int streetNumber, PostalCodeDto postalCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }

    private AddressDto() {
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public PostalCodeDto getPostalCode() {
        return postalCode;
    }


    public static class Builder {

        private String streetName;
        private int streetNumber;
        private PostalCodeDto postalCode;


        public Builder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder withStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder withPostalCodeDto(PostalCodeDto postalCode) {
            this.postalCode = postalCode;
            return this;
        }


        public AddressDto build() {
            AddressDto addressDto = new AddressDto();
            addressDto.streetName = this.streetName;
            addressDto.streetNumber = this.streetNumber;
            addressDto.postalCode = this.postalCode;

            return addressDto;
        }
    }
}
