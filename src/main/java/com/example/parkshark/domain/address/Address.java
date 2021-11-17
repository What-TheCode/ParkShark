package com.example.parkshark.domain.address;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String streetName;

    @Column
    private int streetNumber;

    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "postal_code")
    private PostalCode postalCode;

    public Address() {

    }

    public Address(String streetName, int streetNumber, PostalCode postalCode) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
    }
}
