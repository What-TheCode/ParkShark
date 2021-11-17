package com.example.parkshark.mapper;

import com.example.parkshark.domain.address.Address;
import com.example.parkshark.domain.dto.address.AddressDto;
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

    public Address toEntity(AddressDto addressDto) {
        return new Address.Builder()
                .withStreetName(addressDto.getStreetName())
                .withStreetNumber(addressDto.getStreetNumber())
                .withPostalCode(this.postalCodeMapper.toEntity(addressDto.getPostalCode()))
                .build();
    }

    public AddressDto toDto(Address address) {
        return new AddressDto.Builder()
                .withStreetName(address.getStreetName())
                .withStreetNumber(address.getStreetNumber())
                .withPostalCodeDto(this.postalCodeMapper.toDto(address.getPostalCode()))
                .build();
    }
}
