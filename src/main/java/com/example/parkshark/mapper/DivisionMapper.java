package com.example.parkshark.mapper;

import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.dto.DivisionDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DivisionMapper {

    public Division toEntity(DivisionDto divisionDto){
        return new Division(divisionDto.getId(),divisionDto.getName(),divisionDto.getFullName(),divisionDto.getDirectorId());
    }

    public DivisionDto toDto(Division division){
        return new DivisionDto(division.getId(), division.getName(), division.getOriginalName(), division.getDirector());
    }

    public List<DivisionDto> toDto(List<Division> orderList){
        return orderList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
