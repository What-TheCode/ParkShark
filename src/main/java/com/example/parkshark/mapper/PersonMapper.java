package com.example.parkshark.mapper;

import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.dto.person.CreatePersonDto;
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
}
