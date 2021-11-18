package com.example.parkshark.domain.member;

import com.example.parkshark.domain.Person;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "license_plate_id")
    private LicensePlate licensePlate;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime registrationDate;

    @Column(name = "membership")
    private Membership membershipLevel;

    public Member() {

    }

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public Membership getMembershipLevel() {
        return membershipLevel;
    }


    public static class Builder {

        private int id;
        private Person person;
        private LicensePlate licensePlate;
        private LocalDateTime registrationDate;
        private Membership membershipLevel;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withPerson(Person person) {
            this.person = person;
            return this;
        }

        public Builder withLicensePlate(LicensePlate licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public Builder withRegistrationDate(LocalDateTime registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder withMembershipLevel(Membership membershipLevel) {
            this.membershipLevel = membershipLevel;
            return this;
        }


        public Member build() {
            Member member = new Member();
            member.id = this.id;
            member.person = this.person;
            member.licensePlate = this.licensePlate;
            member.registrationDate = this.registrationDate;
            member.membershipLevel = this.membershipLevel;

            return member;
        }
    }
}
