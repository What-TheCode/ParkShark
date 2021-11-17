package com.example.parkshark.domain.dto.address;

public class CreateAddressDto {

    private String streetName;
    private int streetNumber;
    private CreatePostalCodeDto postalCode;

    public CreateAddressDto(String streetName, int streetNumber, CreatePostalCodeDto postalCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public CreatePostalCodeDto getPostalCode() {
        return postalCode;
    }
}
