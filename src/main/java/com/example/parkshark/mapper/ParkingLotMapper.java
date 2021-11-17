package com.example.parkshark.mapper;

import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.address.Address;
import com.example.parkshark.domain.address.PostalCode;
import com.example.parkshark.domain.dto.parkingLotDTO.CreateParkingLotDTO;
import com.example.parkshark.domain.parkinglot.Parkinglot;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {

    public Parkinglot toEntity(CreateParkingLotDTO createParkingLotDTO) {
        return new Parkinglot(
                createParkingLotDTO.getName(),
                createParkingLotDTO.getCategory(),
                createParkingLotDTO.getCapacity(),
                new Person(
                        createParkingLotDTO.getContactPerson().getFirstName(),
                        createParkingLotDTO.getContactPerson().getLastName(),
                        new Address(
                                createParkingLotDTO.getContactPerson().getCreateAddressDTO().getStreetName(),
                                createParkingLotDTO.getContactPerson().getCreateAddressDTO().getStreetNumber(),
                                new PostalCode(
                                        createParkingLotDTO.getContactPerson().getCreateAddressDTO().getPostalCode().getPostalCode(),
                                        createParkingLotDTO.getContactPerson().getCreateAddressDTO().getPostalCode().getRegion()
                                )
                        ),
                        createParkingLotDTO.getContactPerson().getTelephone(),
                        createParkingLotDTO.getContactPerson().getEmail()
                ),
                new Address(
                        createParkingLotDTO.getAddress().getStreetName(),
                        createParkingLotDTO.getAddress().getStreetNumber(),
                        new PostalCode(
                                createParkingLotDTO.getAddress().getPostalCode().getPostalCode(),
                                createParkingLotDTO.getAddress().getPostalCode().getRegion()
                        )
                ),
                createParkingLotDTO.getPricePerHour()
        );
    }
}
