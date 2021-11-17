package com.example.parkshark.domain.dto.address;

import javax.persistence.Column;

public class CreatePostalCodeDTO {

    private int postalCode;
    private String region;

    public CreatePostalCodeDTO(int postalCode, String region) {
        this.postalCode = postalCode;
        this.region = region;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getRegion() {
        return region;
    }
}
