package com.example.parkshark.mapper;

import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.dto.division.CreateDivisionDto;
import com.example.parkshark.domain.dto.division.DivisionDto;
import com.sun.xml.bind.v2.TODO;
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

//    public Division toEntity(DivisionDto divisionDto){
//        return
//    }

    public Division toEntity(CreateDivisionDto createDivisionDto){
        return new Division.Builder()
                .withName(createDivisionDto.getName())
                .withOriginalName(createDivisionDto.getOriginalName())
                .withDirector(personMapper.toEntity(createDivisionDto.getDirector()))
                .build();
    }

    public DivisionDto toDto(Division division){
        return new DivisionDto(division.getId(), division.getName(), division.getOriginalName(), personMapper.toDto(division.getDirector()));
    }

    public List<DivisionDto> toDto(List<Division> orderList){
        return orderList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
