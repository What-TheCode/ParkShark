package com.example.parkshark.domain.dto.division;

import com.example.parkshark.domain.dto.person.CreatePersonDto;

import java.util.Objects;

public class DivisionDto {
    private int id;
    private String name;
    private String originalName;
    private CreatePersonDto director;

    public DivisionDto(int id, String name, String fullName, PersonDto directorId) {
        this.id = id;
        this.name = name;
        this.originalName = fullName;
        this.director = directorId;
    }

    public int getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionDto that = (DivisionDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
