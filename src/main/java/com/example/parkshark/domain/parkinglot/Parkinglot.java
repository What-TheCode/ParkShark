package com.example.parkshark.domain.parkinglot;

import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.address.Address;

import javax.persistence.*;

@Entity
@Table(name = "parkinglot")
public class Parkinglot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private ParkinglotCategory category;

    @Column
    private int capacity;

    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "contact_person_id")
    private Person contactPerson;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column
    private double pricePerHour;

//    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinColumn(name = "division_id")
//    private Division division;


    public Parkinglot() {

    }

    public Parkinglot(String name, ParkinglotCategory category, int capacity, Person contactPerson, Address address, double pricePerHour) {
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
    }
}
