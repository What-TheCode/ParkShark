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
    @Column(name = "directorId")
    private int directorId;

    public Division() {
    }

    public Division(String originalName, int directorId) {
        this.originalName = originalName;
        this.directorId = directorId;
    }


}
