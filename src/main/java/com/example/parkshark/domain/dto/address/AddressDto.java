package com.example.parkshark.domain.dto.address;

import com.example.parkshark.domain.dto.person.PersonDto;
import org.springframework.stereotype.Component;

public class AddressDto {
    private String streetName;
    private int streetNumber;
    private int postalCode;
    private String region;

    public AddressDto(String streetName, int streetNumber, int postalCode, String region) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.region = region;
    }

    private AddressDto() {
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getRegion() {
        return region;
    }

    public static class Builder {

        private String streetName;
        private int streetNumber;
        private int postalCode;
        private String region;


        public Builder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder withStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder withPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }


        public AddressDto build() {
            AddressDto addressDto = new AddressDto();
            addressDto.streetName = this.streetName;
            addressDto.streetNumber = this.streetNumber;
            addressDto.postalCode = this.postalCode;
            addressDto.region = this.region;

            return addressDto;
        }
    }
}
