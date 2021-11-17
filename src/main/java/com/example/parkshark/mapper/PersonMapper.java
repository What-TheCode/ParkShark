package com.example.parkshark.mapper;

import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.dto.person.CreatePersonDto;
import com.example.parkshark.domain.dto.person.PersonDto;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    private AddressMapper addressMapper;

    public PersonMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Person toEntity(CreatePersonDto createPersonDto) {
        return new Person.Builder()
                .withFirstName(createPersonDto.getFirstName())
                .withLastName(createPersonDto.getLastName())
                .withAddress(this.addressMapper.toEntity(createPersonDto.getCreateAddressDTO()))
                .withTelephone(createPersonDto.getTelephone())
                .withEmail(createPersonDto.getEmail())
                .build();
    }

    public Person toEntity(PersonDto personDto) {
        return new Person.Builder()
                .withFirstName(personDto.getFirstName())
                .withLastName(personDto.getLastName())
                .withAddress(this.addressMapper.toEntity(personDto.getAddressDto()))
                .withTelephone(personDto.getTelephone())
                .withEmail(personDto.getEmail())
                .build();
    }

    public PersonDto toDto(Person person){
        return new PersonDto.Builder()
                .withFirstName(person.getFirstName())
                .withLastName(person.getLastName())
                .withAddress(this.addressMapper.toDto(person.getAddress()))
                .withTelephone(person.getTelephone())
                .withEmail(person.getEmail())
                .build();
    }
}
