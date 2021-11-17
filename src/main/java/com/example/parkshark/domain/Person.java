package com.example.parkshark.domain;

import com.example.parkshark.domain.address.Address;
import com.example.parkshark.domain.parkinglot.Parkinglot;
import com.example.parkshark.domain.parkinglot.ParkinglotCategory;

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

    public Person(String firstName, String lastName, Address address, String telephone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }


    public static class Builder {

        private int id;
        private String firstName;
        private String lastName;
        private Address address;
        private String telephone;
        private String email;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder withTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.id = this.id;
            person.firstName = this.firstName;
            person.lastName = this.lastName;
            person.address = this.address;
            person.telephone = this.telephone;
            person.email = this.email;

            return person;
        }
    }
}
