package com.example.parkshark.domain.dto.person;

import com.example.parkshark.domain.address.Address;
import com.example.parkshark.domain.dto.address.CreateAddressDTO;

import javax.persistence.*;

public class CreatePersonDTO {

    private String firstName;
    private String lastName;
    private CreateAddressDTO createAddressDTO;
    private String telephone;
    private String email;

    public CreatePersonDTO(String firstName, String lastName, CreateAddressDTO createAddressDTO, String telephone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.createAddressDTO = createAddressDTO;
        this.telephone = telephone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateAddressDTO getCreateAddressDTO() {
        return createAddressDTO;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
}
