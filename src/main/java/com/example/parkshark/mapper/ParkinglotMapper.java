package com.example.parkshark.mapper;

import com.example.parkshark.domain.dto.parkinglot.CreateParkinglotDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDto;
import com.example.parkshark.domain.parkinglot.Parkinglot;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkinglotMapper {

    private final PersonMapper personMapper;
    private final AddressMapper addressMapper;

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

    public ParkinglotDto toDto(Parkinglot parkinglot) {
        return new ParkinglotDto.Builder()
                .withId(parkinglot.getId())
                .withName(parkinglot.getName())
                .withCapacity(parkinglot.getCapacity())
                .withContactPerson(personMapper.toDto(parkinglot.getContactPerson()))
                .withAddress(addressMapper.toDto(parkinglot.getAddress()))
                .withPricePerHour(parkinglot.getPricePerHour())
                .build();
    }

    public List<ParkinglotDto> toDto(List<Parkinglot> parkinglotList) {
        return parkinglotList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
