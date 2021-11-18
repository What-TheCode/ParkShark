package com.example.parkshark.domain.dto.parkinglot;

import com.example.parkshark.domain.dto.address.AddressDto;
import com.example.parkshark.domain.dto.person.PersonDto;

public class ParkinglotDto {
    private int id;
    private String name;
    private int capacity;
    private PersonDto contactPerson;
    private AddressDto address;
    private double pricePerHour;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public PersonDto getContactPerson() {
        return contactPerson;
    }

    public AddressDto getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public static class Builder {
        private int id;
        private String name;
        private int capacity;
        private PersonDto contactPerson;
        private AddressDto address;
        private double pricePerHour;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder withContactPerson(PersonDto contactPerson) {
            this.contactPerson = contactPerson;
            return this;
        }

        public Builder withAddress(AddressDto address) {
            this.address = address;
            return this;
        }

        public Builder withPricePerHour(double pricePerHour) {
            this.pricePerHour = pricePerHour;
            return this;
        }

        public ParkinglotDto build() {
            ParkinglotDto parkinglotDto = new ParkinglotDto();
            parkinglotDto.id = this.id;
            parkinglotDto.name = this.name;
            parkinglotDto.capacity = this.capacity;
            parkinglotDto.contactPerson = this.contactPerson;
            parkinglotDto.address = this.address;
            parkinglotDto.pricePerHour = pricePerHour;
            return parkinglotDto;
        }
    }
}