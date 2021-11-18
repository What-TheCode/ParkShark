package com.example.parkshark.domain.dto.parkinglot;

import com.example.parkshark.domain.dto.address.CreateAddressDto;
import com.example.parkshark.domain.dto.person.CreatePersonDto;
import com.example.parkshark.domain.parkinglot.ParkinglotCategory;
import org.springframework.stereotype.Component;

@Component
public class CreateParkinglotDto {

    private String name;
    private ParkinglotCategory category;
    private int capacity;
    private CreatePersonDto contactPerson;
    private CreateAddressDto address;
    private double pricePerHour;
//    private int divisionId;


    public CreateParkinglotDto() {
    }

    public CreateParkinglotDto(String name, ParkinglotCategory category, int capacity, CreatePersonDto contactPerson, CreateAddressDto address, double pricePerHour) {
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

    public CreatePersonDto getContactPerson() {
        return contactPerson;
    }

    public CreateAddressDto getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setAddress(CreateAddressDto address) {
        this.address = address;
    }
}
