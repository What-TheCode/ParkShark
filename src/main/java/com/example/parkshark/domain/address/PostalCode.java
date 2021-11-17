package com.example.parkshark.domain.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "postalcode")
public class PostalCode {

    @Id
    @Column(name = "postal_code")
    private int postalCode;

    @Column
    private String region;

    public PostalCode() {

    }

    public PostalCode(int postalCode, String region) {
        this.postalCode = postalCode;
        this.region = region;
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


        public PostalCode build() {
            PostalCode postalCode = new PostalCode();
            postalCode.postalCode = this.postalCode;
            postalCode.region = this.region;

            return postalCode;
        }
    }

}
