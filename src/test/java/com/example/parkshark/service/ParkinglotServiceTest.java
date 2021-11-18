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

    private ParkinglotRepository parkinglotRepositoryMock;
    private ParkinglotService parkinglotService;
    private ParkinglotMapper parkinglotMapperMock;

    private CreateParkinglotDto createParkinglotDto;

    @BeforeEach
    void setupParkinglotService() {
        parkinglotRepositoryMock = Mockito.mock(ParkinglotRepository.class);
        parkinglotMapperMock = Mockito.mock(ParkinglotMapper.class);
        parkinglotService = new ParkinglotService(parkinglotRepositoryMock, parkinglotMapperMock);

        createParkinglotDto = new CreateParkinglotDto(
                "ParkinglotName",
                ParkinglotCategory.UNDERGROUND,
                250,
                new CreatePersonDto(
                        "Firstname",
                        "Lastname",
                        new CreateAddressDto(
                                "Streetname",
                                101,
                                9000,
                                "Gent"
                        ),
                        "098765432",
                        "0498765432",
                        "email@email.com"
                ),
                new CreateAddressDto(
                        "Streetname",
                        101,
                        9000,
                        "Gent"
                ),
                2.5);

    }

    @Test
    void whenParkingLotIsAdded_thenParkinglotRepositorySaveMethodIsCalledOneTime() {

        //when
        parkinglotService.createParkinglot(createParkinglotDto);

        //then
        Mockito.verify(parkinglotRepositoryMock, times(1)).save(Mockito.any());
    }

    @Test
    void whenGetAllParkinglots_thenParkinglotRepositoryFindAllAllMethodIsCalledOneTime() {

        //when
        parkinglotService.getAll();

        //then
        Mockito.verify(parkinglotRepositoryMock, times(1)).findAll();
    }

    @Test
    void whenGetParkinglotById_thenParkinglotRepositoryFindByIdMethodIsCalledOneTime() {
        //given
        Integer randomId = 100;
        ParkinglotDto parkinglotDto = new ParkinglotDto();

        //when
        //Mockito.when(parkinglotService.getById("1")).thenReturn(parkinglotDto);
        parkinglotService.getById("100");
        Mockito.verify(parkinglotRepositoryMock, times(1)).findById(100);
    }
}