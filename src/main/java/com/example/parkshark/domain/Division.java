package com.example.parkshark.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "division")
public class Division {
    @Id
    @SequenceGenerator(name = "division_id_seq", sequenceName = "division_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "division_id_seq")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "original_name")
    private String originalName;
    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "director_id")
    private Person director;

    public Division() {
    }

    public Division(int id, String name, String originalName, Person director) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.director = director;
    }

    public Division(String name, String originalName, Person director) {
        this.name = name;
        this.originalName = originalName;
        this.director = director;
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

    public Person getDirector() {
        return director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Division division = (Division) o;
        return id == division.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
