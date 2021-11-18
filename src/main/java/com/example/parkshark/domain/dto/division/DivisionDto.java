package com.example.parkshark.domain.dto.division;

import com.example.parkshark.domain.dto.person.PersonDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

public class DivisionDto {
    private int id;
    private String name;
    private String fullName;
    private PersonDto directorId;

    public DivisionDto(int id, String name, String fullName, PersonDto directorId) {
        this.id = id;
    }

    public int getId() {
        return id;
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
