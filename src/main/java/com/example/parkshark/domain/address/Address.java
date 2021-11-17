package com.example.parkshark.domain.address;

import com.example.parkshark.domain.Person;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String streetName;

    @Column
    private int streetNumber;

    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "postal_code")
    private PostalCode postalCode;

    public Address() {

    }

    public Address(String streetName, int streetNumber, PostalCode postalCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
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

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public static class Builder {

        private int id;
        private String streetName;
        private int streetNumber;
        private PostalCode postalCode;

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

        public Builder withPostalCode(PostalCode postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address build() {
            Address address = new Address();
            address.id = this.id;
            address.streetName = this.streetName;
            address.streetNumber = this.streetNumber;
            address.postalCode = this.postalCode;

            return address;
        }
    }
}
