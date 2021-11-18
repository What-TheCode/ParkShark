package com.example.parkshark.domain.dto.address;

import org.springframework.stereotype.Component;

public class CreateAddressDto {

    private String streetName;
    private int streetNumber;
    private int postalCode;
    private String region;

    public CreateAddressDto(String streetName, int streetNumber, int postalCode, String region) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.region = region;
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
}
