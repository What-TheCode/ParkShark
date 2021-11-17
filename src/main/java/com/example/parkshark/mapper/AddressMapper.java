package com.example.parkshark.mapper;

import com.example.parkshark.domain.address.Address;
import com.example.parkshark.domain.dto.address.CreateAddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    private PostalCodeMapper postalCodeMapper;

    public AddressMapper(PostalCodeMapper postalCodeMapper) {
        this.postalCodeMapper = postalCodeMapper;
    }

    public Address toEntity(CreateAddressDto createAddressDto) {
        return new Address.Builder()
                .withStreetName(createAddressDto.getStreetName())
                .withStreetNumber(createAddressDto.getStreetNumber())
                .withPostalCode(this.postalCodeMapper.toEntity(createAddressDto.getPostalCode()))
                .build();
    }

}
