package com.example.parkshark.domain;

import javax.persistence.*;

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

    public Division(String originalName, Person directorId) {
        this.originalName = originalName;
        this.director = directorId;
    }


}
