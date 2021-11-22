package com.example.parkshark.domain.dto.parkinglot;

import com.example.parkshark.domain.dto.address.AddressDto;
import com.example.parkshark.domain.dto.division.DivisionDto;
import com.example.parkshark.domain.dto.person.PersonDto;

public class ParkinglotDetailDto {
    private int id;
    private String name;
    private int capacity;
    private PersonDto contactPerson;
    private AddressDto address;
    private double pricePerHour;
    private DivisionDto divisionDto;

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

    public DivisionDto getDivisionDto() {
        return divisionDto;
    }

    public static class Builder {
        private int id;
        private String name;
        private int capacity;
        private PersonDto contactPerson;
        private AddressDto address;
        private double pricePerHour;
        private DivisionDto divisionDto;

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

        public Builder withDivisionDto(DivisionDto divisionDto) {
            this.divisionDto = divisionDto;
            return this;
        }

        public ParkinglotDetailDto build() {
            ParkinglotDetailDto parkinglotDto = new ParkinglotDetailDto();
            parkinglotDto.id = this.id;
            parkinglotDto.name = this.name;
            parkinglotDto.capacity = this.capacity;
            parkinglotDto.contactPerson = this.contactPerson;
            parkinglotDto.address = this.address;
            parkinglotDto.pricePerHour = this.pricePerHour;
            parkinglotDto.divisionDto = this.divisionDto;

            return parkinglotDto;
        }
    }
}