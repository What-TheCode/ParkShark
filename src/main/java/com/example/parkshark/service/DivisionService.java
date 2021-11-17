package com.example.parkshark.service;

import com.example.parkshark.domain.dto.division.DivisionDto;
import com.example.parkshark.mapper.DivisionMapper;
import com.example.parkshark.repository.DivisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DivisionService {

    private DivisionRepository divisionRepository;
    private DivisionMapper divisionMapper;

    public DivisionService(DivisionRepository divisionRepository, DivisionMapper divisionMapper) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
    }

    public List<DivisionDto> findAll(){
        return divisionMapper.toDto(divisionRepository.findAll());
    }

    public void saveDivision(DivisionDto divisionDto){
        divisionRepository.save(divisionMapper.toEntity(divisionDto));
    }
}
