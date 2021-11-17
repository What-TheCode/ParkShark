package com.example.parkshark.mapper;

import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.address.Address;
import com.example.parkshark.domain.address.PostalCode;
import com.example.parkshark.domain.dto.parkinglotDTO.CreateParkinglotDTO;
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

    public Parkinglot toEntity(CreateParkinglotDTO createParkingLotDTO) {
        return new Parkinglot.Builder()
                .withName(createParkingLotDTO.getName())
                .withCategory(createParkingLotDTO.getCategory())
                .withCapacity(createParkingLotDTO.getCapacity())
                .withContactPerson(this.personMapper.toEntity(createParkingLotDTO.getContactPerson()))
                .withAddress(this.addressMapper.toEntity(createParkingLotDTO.getAddress()))
                .withPricePerHour(createParkingLotDTO.getPricePerHour())
                .build();
    }
}
