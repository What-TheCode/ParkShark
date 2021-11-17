package com.example.parkshark.service;

import com.example.parkshark.domain.dto.parkinglot.CreateParkinglotDto;
import com.example.parkshark.mapper.ParkinglotMapper;
import com.example.parkshark.repository.ParkinglotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParkinglotService {

    private final ParkinglotRepository parkinglotRepository;
    private final ParkinglotMapper parkinglotMapper;

    @Autowired
    public ParkinglotService(ParkinglotRepository parkinglotRepository, ParkinglotMapper parkinglotMapper) {
        this.parkinglotRepository = parkinglotRepository;
        this.parkinglotMapper = parkinglotMapper;
    }

    public void createParkinglot(CreateParkinglotDto createParkinglotDto) {
        this.parkinglotRepository.save(parkinglotMapper.toEntity(createParkinglotDto));
    }

//    public List<ParkinglotDTO> getAllParkinglots() {
//        return parkinglotMapper.toDTO(parkinglotRepository.findAll());
//    }
}
