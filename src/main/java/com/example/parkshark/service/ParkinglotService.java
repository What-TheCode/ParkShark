package com.example.parkshark.service;

import com.example.parkshark.domain.dto.parkingLotDTO.CreateParkingLotDTO;
import com.example.parkshark.mapper.ParkingLotMapper;
import com.example.parkshark.repository.ParkinglotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParkinglotService {

    private final ParkinglotRepository parkinglotRepository;
    private final ParkingLotMapper parkingLotMapper;

    public ParkinglotService(ParkinglotRepository parkinglotRepository, ParkingLotMapper parkingLotMapper) {
        this.parkinglotRepository = parkinglotRepository;
        this.parkingLotMapper = parkingLotMapper;
    }

    public void createParkinglot(CreateParkingLotDTO createParkinglotDto) {
        this.parkinglotRepository.save(this.parkingLotMapper.toEntity(createParkinglotDto));
    }
}
