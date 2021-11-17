package com.example.parkshark.service;

import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.dto.DivisionDto;
import com.example.parkshark.mapper.DivisionMapper;
import com.example.parkshark.repository.DivisionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DivisionServiceTest {
    private DivisionMapper divisionMapper;

    @BeforeEach
    void setup(){
        this.divisionMapper = new DivisionMapper();
    }

    @Nested
    @DisplayName("Create new Division")
    class createNewDivision{
        @DisplayName("verify create method in repository")
        @Test
        void whenCreatingATestInService_ThenCallRepoMethod(){
            //GIVEN
            DivisionRepository divisionRepository = Mockito.mock(DivisionRepository.class);
            DivisionService divisionService = new DivisionService(divisionRepository,divisionMapper);
            DivisionDto divisionDto = new DivisionDto(1,"test","test org",new Person());
            //WHEN
            divisionService.saveDivision(divisionDto);
            //THEN
            Mockito.verify(divisionRepository).save(divisionMapper.toEntity(divisionDto));
        }
    }

}