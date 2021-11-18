package com.example.parkshark.domain.member;

import javax.persistence.*;

@Entity
@Table(name = "license_plate")
public class LicensePlate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "number")
    private String licensePlateNumber;

    @Column(name = "country")
    private String issuingCountry;

    public LicensePlate() {
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


        public LicensePlate build() {
            LicensePlate licensePlate = new LicensePlate();
            licensePlate.id = this.id;
            licensePlate.licensePlateNumber = this.licensePlateNumber;
            licensePlate.issuingCountry = this.issuingCountry;

            return licensePlate;
        }
    }
}
