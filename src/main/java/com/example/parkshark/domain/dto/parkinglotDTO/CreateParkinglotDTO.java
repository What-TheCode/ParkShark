package com.example.parkshark.domain.dto.parkinglotDTO;

import com.example.parkshark.domain.dto.address.CreateAddressDTO;
import com.example.parkshark.domain.dto.person.CreatePersonDTO;
import com.example.parkshark.domain.parkinglot.ParkinglotCategory;

public class CreateParkinglotDTO {

    private String name;
    private ParkinglotCategory category;
    private int capacity;
    private CreatePersonDTO contactPerson;
    private CreateAddressDTO address;
    private double pricePerHour;
//    private int divisionId;


    public CreateParkinglotDTO(String name, ParkinglotCategory category, int capacity, CreatePersonDTO contactPerson, CreateAddressDTO address, double pricePerHour) {
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
    }

    public String getName() {
        return name;
    }

    public ParkinglotCategory getCategory() {
        return category;
    }

    public int getCapacity() {
        return capacity;
    }

    public CreatePersonDTO getContactPerson() {
        return contactPerson;
    }

    public CreateAddressDTO getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}
