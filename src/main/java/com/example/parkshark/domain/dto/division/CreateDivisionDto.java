package com.example.parkshark.domain.dto.division;

import com.example.parkshark.domain.dto.person.CreatePersonDto;
import org.springframework.stereotype.Component;

public class CreateDivisionDto {
    private String name;
    private String originalName;
    private CreatePersonDto director;

    public CreateDivisionDto(String name, String originalName, CreatePersonDto director) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public CreatePersonDto getDirector() {
        return director;
    }
}
