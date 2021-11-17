package com.example.parkshark.mapper;

import com.example.parkshark.domain.dto.parkinglot.CreateParkinglotDto;
import com.example.parkshark.domain.parkinglot.Parkinglot;
import org.springframework.stereotype.Component;

@Component
public class ParkinglotMapper {

    private PersonMapper personMapper;
    private AddressMapper addressMapper;

    public ParkinglotMapper(PersonMapper personMapper, AddressMapper addressMapper) {
        this.personMapper = personMapper;
        this.addressMapper = addressMapper;
    }

    public Parkinglot toEntity(CreateParkinglotDto createParkinglotDto) {
        return new Parkinglot.Builder()
                .withName(createParkinglotDto.getName())
                .withCategory(createParkinglotDto.getCategory())
                .withCapacity(createParkinglotDto.getCapacity())
                .withContactPerson(this.personMapper.toEntity(createParkinglotDto.getContactPerson()))
                .withAddress(this.addressMapper.toEntity(createParkinglotDto.getAddress()))
                .withPricePerHour(createParkinglotDto.getPricePerHour())
                .build();
    }
}
