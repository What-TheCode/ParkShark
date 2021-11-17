package com.example.parkshark.domain;

import com.example.parkshark.domain.address.Address;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column
    private String telephone;

    @Column
    private String email;

    public Person() {

    }
}
