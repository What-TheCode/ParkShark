package com.example.parkshark.service;

import com.example.parkshark.mapper.DivisionMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

class DivisionServiceTest {
    private DivisionMapper divisionMapper;

    //    @BeforeEach
//    void setup(){
//        this.divisionMapper = new DivisionMapper();
//    }
//
//    @Nested
//    @DisplayName("Create new Division")
//    class createNewDivision{
//        @DisplayName("verify create method in repository")
//        @Test
//        void whenCreatingATestInService_ThenCallRepoMethod(){
//            //GIVEN
//            DivisionRepository divisionRepository = Mockito.mock(DivisionRepository.class);
//            DivisionService divisionService = new DivisionService(divisionRepository,divisionMapper);
//            DivisionDto divisionDto = new CreateDivisionDto("test","test org",new Person());
//            //WHEN
//            divisionService.saveDivision(divisionDto);
//            //THEN
//            Mockito.verify(divisionRepository).save(divisionMapper.toEntity(divisionDto));
//        }
//    }
    @Nested
    @DisplayName("get all divisions")
    class getAllDivisions {
        @DisplayName("get list of 2 division and check size of list")
        void whenGettingAListOfTwoDivision_ThenTheSizeIsTwo() {
            //GIVEN

            //WHEN
            //THEN
        }
    }

}