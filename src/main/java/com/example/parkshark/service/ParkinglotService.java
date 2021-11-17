package com.example.parkshark.service;

import com.example.parkshark.domain.dto.parkinglotDTO.CreateParkinglotDTO;
import com.example.parkshark.mapper.ParkinglotMapper;
import com.example.parkshark.repository.ParkinglotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParkinglotService {

    private final ParkinglotRepository parkinglotRepository;
    private final ParkinglotMapper parkinglotMapper;

    public ParkinglotService(ParkinglotRepository parkinglotRepository, ParkinglotMapper parkinglotMapper) {
        this.parkinglotRepository = parkinglotRepository;
        this.parkinglotMapper = parkinglotMapper;
    }

    public void createParkinglot(CreateParkinglotDTO createParkinglotDto) {
        this.parkinglotRepository.save(this.parkinglotMapper.toEntity(createParkinglotDto));
    }
}
