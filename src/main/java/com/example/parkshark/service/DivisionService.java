package com.example.parkshark.service;

import com.example.parkshark.domain.Division;
import com.example.parkshark.repository.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DivisionService {

    private DivisionRepository divisionRepository;

    @Autowired

    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public void saveDivision(Division division){
        divisionRepository.save(division);
    }
}
