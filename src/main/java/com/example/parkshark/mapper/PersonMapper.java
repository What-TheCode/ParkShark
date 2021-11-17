package com.example.parkshark.mapper;

import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.dto.person.CreatePersonDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    private AddressMapper addressMapper;

    public PersonMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Person toEntity(CreatePersonDTO createPersonDTO) {
        return new Person.Builder()
                .withFirstName(createPersonDTO.getFirstName())
                .withLastName(createPersonDTO.getLastName())
                .withAddress(this.addressMapper.toEntity(createPersonDTO.getCreateAddressDTO()))
                .withTelephone(createPersonDTO.getTelephone())
                .withEmail(createPersonDTO.getEmail())
                .build();
    }
}
