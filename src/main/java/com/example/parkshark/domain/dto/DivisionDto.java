package com.example.parkshark.domain.dto;

import com.example.parkshark.domain.Person;

import java.util.Objects;

public class DivisionDto {
    private int id;
    private String name;
    private String fullName;
    private Person directorId;

    public DivisionDto(int id, String name, String fullName, Person directorId) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.directorId = directorId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Person getDirectorId() {
        return directorId;
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
