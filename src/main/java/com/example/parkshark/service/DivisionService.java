package com.example.parkshark.service;

import com.example.parkshark.domain.dto.division.CreateDivisionDto;
import com.example.parkshark.domain.dto.division.DivisionDto;
import com.example.parkshark.mapper.DivisionMapper;
import com.example.parkshark.repository.DivisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DivisionService {

    private final DivisionRepository divisionRepository;
    private final DivisionMapper divisionMapper;

    public DivisionService(DivisionRepository divisionRepository, DivisionMapper divisionMapper) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
    }

    public List<DivisionDto> findAll() {
        return divisionMapper.toDto(divisionRepository.findAll());
    }

    public void saveDivision(CreateDivisionDto createDivisionDto) {
        divisionRepository.save(divisionMapper.toEntity(createDivisionDto));
    }

    public DivisionDto findById(int id) {
        if (divisionRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("There is no division with this id.");
        }
        return divisionMapper.toDto(divisionRepository.getById(id));
    }
}
