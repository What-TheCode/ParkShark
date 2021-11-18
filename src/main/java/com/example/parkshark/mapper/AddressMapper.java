package com.example.parkshark.mapper;

import com.example.parkshark.domain.address.Address;
import com.example.parkshark.domain.dto.address.AddressDto;
import com.example.parkshark.domain.dto.address.CreateAddressDto;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toEntity(CreateAddressDto createAddressDto) {
        return new Address.Builder()
                .withStreetName(createAddressDto.getStreetName())
                .withStreetNumber(createAddressDto.getStreetNumber())
                .withPostalCode(createAddressDto.getPostalCode())
                .withRegion(createAddressDto.getRegion())
                .build();
    }

    public Address toEntity(AddressDto addressDto) {
        return new Address.Builder()
                .withStreetName(addressDto.getStreetName())
                .withStreetNumber(addressDto.getStreetNumber())
                .withPostalCode(addressDto.getPostalCode())
                .withRegion(addressDto.getRegion())
                .build();
    }

    public AddressDto toDto(Address address) {
        return new AddressDto.Builder()
                .withStreetName(address.getStreetName())
                .withStreetNumber(address.getStreetNumber())
                .withPostalCode(address.getPostalCode())
                .withRegion(address.getRegion())
                .build();
    }
}
