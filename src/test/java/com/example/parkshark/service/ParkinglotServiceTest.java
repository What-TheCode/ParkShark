package com.example.parkshark.service;

import com.example.parkshark.domain.dto.address.CreateAddressDto;
import com.example.parkshark.domain.dto.parkinglot.CreateParkinglotDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDto;
import com.example.parkshark.domain.dto.person.CreatePersonDto;
import com.example.parkshark.domain.parkinglot.Parkinglot;
import com.example.parkshark.domain.parkinglot.ParkinglotCategory;
import com.example.parkshark.mapper.ParkinglotMapper;
import com.example.parkshark.repository.ParkinglotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

class ParkinglotServiceTest {

//    private ParkinglotRepository parkinglotRepositoryMock;
//    private ParkinglotService parkinglotServiceMock;
//    private ParkinglotMapper parkinglotMapperMock;
//
//    private CreateParkinglotDto createParkinglotDto;
//
//    @BeforeEach
//    void setupParkinglotService() {
//        this.parkinglotRepositoryMock = Mockito.mock(ParkinglotRepository.class);
//        this.parkinglotMapperMock = Mockito.mock(ParkinglotMapper.class);
//        this.parkinglotServiceMock = new ParkinglotService(this.parkinglotRepositoryMock, this.parkinglotMapperMock);
//
//        this.createParkinglotDto = new CreateParkinglotDto(
//                "ParkinglotName",
//                ParkinglotCategory.UNDERGROUND,
//                250,
//                new CreatePersonDto(
//                        "Firstname",
//                        "Lastname",
//                        new CreateAddressDto(
//                                "Streetname",
//                                101,
//                                9000,
//                                "Gent"
//                        ),
//                        "098765432",
//                        "0498765432",
//                        "email@email.com"
//                ),
//                new CreateAddressDto(
//                        "Streetname",
//                        101,
//                        9000,
//                        "Gent"
//                ),
//                2.5);
//
//    }
//
//    @Test
//    void whenParkingLotIsAdded_thenParkinglotRepositorySaveMethodIsCalledOneTime() {
//
//        //when
//        this.parkinglotServiceMock.createParkinglot(this.createParkinglotDto);
//
//        //then
//        Mockito.verify(this.parkinglotRepositoryMock, times(1)).save(Mockito.any());
//    }
//
//    @Test
//    void whenGetAllParkinglots_thenParkinglotRepositoryFindAllAllMethodIsCalledOneTime() {
//
//        //when
//        this.parkinglotServiceMock.getAll();
//
//        //then
//        Mockito.verify(this.parkinglotRepositoryMock, times(1)).findAll();
//    }
//
//    @Test
//    void whenGetParkinglotById_thenParkinglotRepositoryFindByIdMethodIsCalledOneTime() {
//        //given
//        Integer randomId = 100;
//        ParkinglotDto parkinglotDto = new ParkinglotDto();
//
//        //when
//        Mockito.when(this.parkinglotServiceMock.getById("1")).thenReturn(parkinglotDto);
//        Mockito.verify(this.parkinglotRepositoryMock, times(1)).getById(randomId);
//    }
}