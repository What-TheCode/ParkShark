package com.example.parkshark.domain.dto.division;


import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.dto.person.PersonDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class DivisionDto {
    private int id;
    private String name;
    private String originalName;
    private PersonDto director;
    private Integer parentdivisionId;

    public DivisionDto() {
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

    public Integer getParentdivisionId(){return parentdivisionId; }

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

    public static class Builder {

        private int id;
        private String name;
        private String originalName;
        private PersonDto director;
        private Integer parentdivisionId;


        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withOriginalName(String originalName) {
            this.originalName = originalName;
            return this;
        }

        public Builder withDirector(PersonDto director) {
            this.director = director;
            return this;
        }

        public Builder withParentDivisionId(Integer parentDivisionId){
            this.parentdivisionId = parentDivisionId;
            return this;
        }

        public DivisionDto build() {
            DivisionDto divisionDto = new DivisionDto();
            divisionDto.id = this.id;
            divisionDto.name = this.name;
            divisionDto.originalName = this.originalName;
            divisionDto.director = this.director;
            divisionDto.parentdivisionId = this.parentdivisionId;

            return divisionDto;
        }
    }
}
