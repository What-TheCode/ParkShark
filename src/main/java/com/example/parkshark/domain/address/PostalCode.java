package com.example.parkshark.domain.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "postalcode")
public class PostalCode {

    @Id
    private int postalCode;

    @Column
    private String region;

    public PostalCode() {

    }
}
