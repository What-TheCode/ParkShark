package com.example.parkshark.domain.dto.person;

import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.address.Address;
import com.example.parkshark.domain.dto.address.AddressDto;
import org.springframework.stereotype.Component;

public class PersonDto {
    private String firstName;
    private String lastName;
    private AddressDto addressDto;
    private String telephone;
    private String mobileTelephone;
    private String email;

    private PersonDto() {

    }

    public PersonDto(String firstName, String lastName, AddressDto addressDto,
                     String telephone, String mobileTelephone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressDto = addressDto;
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

    public AddressDto getAddressDto() {
        return addressDto;
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


    public static class Builder {

        private String firstName;
        private String lastName;
        private AddressDto addressDto;
        private String telephone;
        private String mobileTelephone;
        private String email;


        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withAddress(AddressDto addressDto) {
            this.addressDto = addressDto;
            return this;
        }

        public Builder withTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public Builder withMobileTelephone(String mobileTelephone) {
            this.mobileTelephone = mobileTelephone;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public PersonDto build() {
            PersonDto personDto = new PersonDto();
            personDto.firstName = this.firstName;
            personDto.lastName = this.lastName;
            personDto.addressDto = this.addressDto;
            personDto.telephone = this.telephone;
            personDto.mobileTelephone = this.mobileTelephone;
            personDto.email = this.email;

            return personDto;
        }
    }
}
