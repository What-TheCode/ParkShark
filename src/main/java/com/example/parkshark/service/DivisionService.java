package com.example.parkshark.service;

import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.dto.DivisionDto;
import com.example.parkshark.mapper.DivisionMapper;
import com.example.parkshark.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DivisionService {

    private DivisionRepository divisionRepository;
    private DivisionMapper divisionMapper;

    public DivisionService(DivisionRepository divisionRepository, DivisionMapper divisionMapper) {
        this.divisionRepository = divisionRepository;
        this.divisionMapper = divisionMapper;
    }

    public void saveDivision(DivisionDto divisionDto){
        divisionRepository.save(divisionMapper.toEntity(divisionDto));
    }
}
