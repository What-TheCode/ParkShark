package com.example.parkshark.service;

import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.Person;
import com.example.parkshark.repository.DivisionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DivisionServiceTest {

    @Nested
    @DisplayName("Create new Division")
    class createNewDivision{
        @DisplayName("verify create method in repository")
        @Test
        void whenCreatingATestInService_ThenCallRepoMethod(){
            //GIVEN
            DivisionRepository divisionRepository = Mockito.mock(DivisionRepository.class);
            DivisionService divisionService = new DivisionService(divisionRepository);
            Division division = new Division("test",new Person());
            //WHEN
            divisionService.saveDivision(division);
            //THEN
            Mockito.verify(divisionRepository).save(division);
        }
    }

}