package com.example.parkshark.domain.dto.division;

import com.example.parkshark.domain.dto.person.CreatePersonDto;
import com.example.parkshark.domain.dto.person.PersonDto;

import java.util.Objects;

public class DivisionDto {
    private int id;
    private String name;
    private String originalName;
    private PersonDto director;

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

    public PersonDto getDirector() {
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
