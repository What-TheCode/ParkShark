package com.example.parkshark.domain.dto.division;

import com.example.parkshark.domain.dto.person.CreatePersonDto;

public class CreateDivisionDto {
    private final String name;
    private final String originalName;
    private final CreatePersonDto director;
    private final int parentdivisionId;

    public CreateDivisionDto(String name, String originalName, CreatePersonDto director, int parentdivisionId) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.parentdivisionId = parentdivisionId;
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

    public int getParentdivisionId() {
        return parentdivisionId;
    }
}
