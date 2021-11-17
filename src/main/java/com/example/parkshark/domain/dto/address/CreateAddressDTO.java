package com.example.parkshark.domain.dto.address;

import com.example.parkshark.domain.address.PostalCode;

import javax.persistence.*;

public class CreateAddressDTO {

    private String streetName;
    private int streetNumber;
    private CreatePostalCodeDTO postalCode;

    public CreateAddressDTO(String streetName, int streetNumber, CreatePostalCodeDTO postalCode) {
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

    public CreatePostalCodeDTO getPostalCode() {
        return postalCode;
    }
}
