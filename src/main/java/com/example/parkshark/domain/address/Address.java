package com.example.parkshark.domain.address;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @SequenceGenerator(name = "address_id_seq", sequenceName = "address_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "address_id_seq")
    private int id;

    @Column
    private String streetName;

    @Column
    private int streetNumber;

    @Column
    private int postalCode;

    @Column
    private String region;

    public Address() {
    }

    public int getId() {
        return id;
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

        private int id;
        private String streetName;
        private int streetNumber;
        private int postalCode;
        private String region;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

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

        public Address build() {
            Address address = new Address();
            address.id = this.id;
            address.streetName = this.streetName;
            address.streetNumber = this.streetNumber;
            address.postalCode = this.postalCode;
            address.region = this.region;

            return address;
        }
    }
}
