package com.example.parkshark.mapper;

import com.example.parkshark.domain.address.Address;
import com.example.parkshark.domain.dto.address.CreateAddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    private PostalCodeMapper postalCodeMapper;

    public AddressMapper(PostalCodeMapper postalCodeMapper) {
        this.postalCodeMapper = postalCodeMapper;
    }

    public Address toEntity(CreateAddressDTO createAddressDTO) {
        return new Address.Builder()
                .withStreetName(createAddressDTO.getStreetName())
                .withStreetNumber(createAddressDTO.getStreetNumber())
                .withPostalCode(this.postalCodeMapper.toEntity(createAddressDTO.getPostalCode()))
                .build();
    }

}
