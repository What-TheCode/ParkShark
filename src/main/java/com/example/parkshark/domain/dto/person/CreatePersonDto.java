package com.example.parkshark.domain.dto.person;

import com.example.parkshark.domain.dto.address.CreateAddressDto;
import org.springframework.stereotype.Component;

public class CreatePersonDto {

    private String firstName;
    private String lastName;
    private CreateAddressDto createAddressDTO;
    private String telephone;
    private String mobileTelephone;
    private String email;

    public CreatePersonDto(String firstName, String lastName, CreateAddressDto createAddressDTO, String telephone, String mobileTelephone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.createAddressDTO = createAddressDTO;
        this.telephone = telephone;
        this.mobileTelephone = mobileTelephone;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateAddressDto getCreateAddressDTO() {
        return createAddressDTO;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMobileTelephone() {
        return mobileTelephone;
    }

    public String getEmail() {
        return email;
    }
}
