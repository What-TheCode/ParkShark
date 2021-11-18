package com.example.parkshark.domain.parkinglot;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "contact_person_id")
    private Person contactPerson;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column
    private double pricePerHour;

//    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//    @JoinColumn(name = "division_id")
//    private Division division;


    public Parkinglot() {

    }

    private Parkinglot(String name, ParkinglotCategory category, int capacity, Person contactPerson, Address address, double pricePerHour) {
        this.name = name;
        this.category = category;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Address getAddress() {
        return address;
    }

    public Person getContactPerson() {
        return contactPerson;
    }

    public static class Builder {

        private int id;
        private String name;
        private ParkinglotCategory category;
        private int capacity;
        private Person contactPerson;
        private Address address;
        private double pricePerHour;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCategory(ParkinglotCategory category) {
            this.category = category;
            return this;
        }

        public Builder withCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder withContactPerson(Person person) {
            this.contactPerson = contactPerson;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withPricePerHour(double pricePerHour) {
            this.pricePerHour = pricePerHour;
            return this;
        }

        public Parkinglot build() {
            Parkinglot parkinglot = new Parkinglot();
            parkinglot.id = this.id;
            parkinglot.name = this.name;
            parkinglot.category = this.category;
            parkinglot.capacity = this.capacity;
            parkinglot.contactPerson = this.contactPerson;
            parkinglot.address = this.address;
            parkinglot.pricePerHour = this.pricePerHour;

            return parkinglot;
        }
    }
}
