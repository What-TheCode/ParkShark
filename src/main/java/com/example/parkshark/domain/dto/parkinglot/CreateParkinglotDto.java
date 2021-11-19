package com.example.parkshark.domain.dto.parkinglot;

import com.example.parkshark.domain.dto.address.CreateAddressDto;
import com.example.parkshark.domain.dto.person.CreatePersonDto;
import com.example.parkshark.domain.parkinglot.ParkinglotCategory;
import org.springframework.stereotype.Component;

@Component
public class CreateParkinglotDto {

    private String name;
    private String category;
    private int capacity;
    private CreatePersonDto contactPerson;
    private CreateAddressDto address;
    private double pricePerHour;
    private int divisionId;


    public CreateParkinglotDto() {
    }

    public CreateParkinglotDto(String name, String category, int capacity, CreatePersonDto contactPerson,
                               CreateAddressDto address, double pricePerHour, int divisionId) {
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
        this.divisionId = divisionId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
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

    public int getDivisionId() {
        return divisionId;
    }
}
