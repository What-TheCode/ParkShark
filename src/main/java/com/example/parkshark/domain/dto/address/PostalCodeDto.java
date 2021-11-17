package com.example.parkshark.domain.dto.address;

public class PostalCodeDto {
    private int postalCode;
    private String region;

    public PostalCodeDto(int postalCode, String region) {
        this.postalCode = postalCode;
        this.region = region;
    }

    private PostalCodeDto() {
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getRegion() {
        return region;
    }


    public static class Builder {

        private int postalCode;
        private String region;


        public Builder withPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder withRegion(String region) {
            this.region = region;
            return this;
        }


        public PostalCodeDto build() {
            PostalCodeDto postalCodeDto = new PostalCodeDto();
            postalCodeDto.postalCode = this.postalCode;
            postalCodeDto.region = this.region;

            return postalCodeDto;
        }
    }
}
