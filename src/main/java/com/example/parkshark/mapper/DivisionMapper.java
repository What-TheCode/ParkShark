package com.example.parkshark.mapper;

import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.dto.division.CreateDivisionDto;
import com.example.parkshark.domain.dto.division.DivisionDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DivisionMapper {
    //TODO add toEntity for story 3 -> get a division (by ID)

    private PersonMapper personMapper;

    public DivisionMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    public Division toEntity(DivisionDto divisionDto){
        return new Division.Builder()
                .withName(divisionDto.getName())
                .withOriginalName(divisionDto.getOriginalName())
                .withDirector(personMapper.toEntity(divisionDto.getDirector()))
                .build();
    }

    public Division toEntity(CreateDivisionDto createDivisionDto){
        return new Division.Builder()
                .withName(createDivisionDto.getName())
                .withOriginalName(createDivisionDto.getOriginalName())
                .withDirector(personMapper.toEntity(createDivisionDto.getDirector()))
                .build();
    }

    public DivisionDto toDto(Division division){
        return new DivisionDto.Builder()
                .withId(division.getId())
                .withName(division.getName())
                .withOriginalName(division.getOriginalName())
                .withDirector(this.personMapper.toDto(division.getDirector()))
                .build();
    }

    public List<DivisionDto> toDto(List<Division> orderList){
        return orderList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
