package com.example.parkshark.mapper;

import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.dto.parkinglot.CreateParkinglotDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDetailDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDto;
import com.example.parkshark.domain.parkinglot.Parkinglot;
import com.example.parkshark.domain.parkinglot.ParkinglotCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkinglotMapper {

    private final PersonMapper personMapper;
    private final AddressMapper addressMapper;
    private final DivisionMapper divisionMapper;

    @Autowired
    public ParkinglotMapper(PersonMapper personMapper, AddressMapper addressMapper, DivisionMapper divisionMapper) {
        this.personMapper = personMapper;
        this.addressMapper = addressMapper;
        this.divisionMapper = divisionMapper;
    }

    public Parkinglot toEntity(CreateParkinglotDto createParkinglotDto, Division division) {
        return new Parkinglot.Builder()
                .withName(createParkinglotDto.getName())
                .withCategory(ParkinglotCategory.valueOf(createParkinglotDto.getCategory().trim().toUpperCase()))
                .withCapacity(createParkinglotDto.getCapacity())
                .withContactPerson(this.personMapper.toEntity(createParkinglotDto.getContactPerson()))
                .withAddress(this.addressMapper.toEntity(createParkinglotDto.getAddress()))
                .withPricePerHour(createParkinglotDto.getPricePerHour())
                .withDivision(division)
                .build();
    }

    public Parkinglot toEntity(ParkinglotDetailDto parkinglotDetailDto) {
        return new Parkinglot.Builder()
                .withId(parkinglotDetailDto.getId())
                .withName(parkinglotDetailDto.getName())
                .withCapacity(parkinglotDetailDto.getCapacity())
                .withContactPerson(this.personMapper.toEntity(parkinglotDetailDto.getContactPerson()))
                .withAddress(this.addressMapper.toEntity(parkinglotDetailDto.getAddress()))
                .withPricePerHour(parkinglotDetailDto.getPricePerHour())
                .withDivision(this.divisionMapper.toEntity(parkinglotDetailDto.getDivisionDto()))
                .build();
    }

    public ParkinglotDto toDto(Parkinglot parkinglot) {
        return new ParkinglotDto.Builder()
                .withId(parkinglot.getId())
                .withName(parkinglot.getName())
                .withCapacity(parkinglot.getCapacity())
                .withTelephone(parkinglot.getContactPerson().getTelephone())
                .withEmail(parkinglot.getContactPerson().getEmail())
                .build();
    }

    public ParkinglotDetailDto toDetailDto(Parkinglot parkinglot) {
        return new ParkinglotDetailDto.Builder()
                .withId(parkinglot.getId())
                .withName(parkinglot.getName())
                .withCapacity(parkinglot.getCapacity())
                .withContactPerson(personMapper.toDto(parkinglot.getContactPerson()))
                .withAddress(addressMapper.toDto(parkinglot.getAddress()))
                .withPricePerHour(parkinglot.getPricePerHour())
                .withDivisionDto(this.divisionMapper.toDto(parkinglot.getDivision()))
                .build();
    }

    public List<ParkinglotDto> toDto(List<Parkinglot> parkinglotList) {
        return parkinglotList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
