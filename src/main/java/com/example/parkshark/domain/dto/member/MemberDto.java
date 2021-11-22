package com.example.parkshark.domain.dto.member;

import com.example.parkshark.domain.dto.person.PersonDto;

import java.time.LocalDateTime;

public class MemberDto {

    private int id;
    private PersonDto personDto;
    private LicensePlateDto licensePlateDto;
    private LocalDateTime registrationDate;
    private String membershipLevel;

    public MemberDto() {

    }

    public MemberDto(int id, PersonDto personDto,
                     LicensePlateDto licensePlateDto,
                     LocalDateTime registrationDate,
                     String membershipLevel) {
        this.id = id;
        this.personDto = personDto;
        this.licensePlateDto = licensePlateDto;
        this.registrationDate = registrationDate;
        this.membershipLevel = membershipLevel;
    }

    public int getId() {
        return id;
    }

    public PersonDto getPerson() {
        return personDto;
    }

    public com.example.parkshark.domain.dto.member.LicensePlateDto getLicensePlateDto() {
        return licensePlateDto;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }


    public static class Builder {

        private int id;
        private PersonDto personDto;
        private LicensePlateDto licensePlateDto;
        private LocalDateTime registrationDate;
        private String membershipLevel;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withPersonDto(PersonDto personDto) {
            this.personDto = personDto;
            return this;
        }

        public Builder withLicensePlateDto(LicensePlateDto licensePlateDto) {
            this.licensePlateDto = licensePlateDto;
            return this;
        }

        public Builder withRegistrationDate(LocalDateTime registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder withMembershipLevel(String membershipLevel) {
            this.membershipLevel = membershipLevel;
            return this;
        }

        public MemberDto build() {
            MemberDto memberDto = new MemberDto();
            memberDto.id = this.id;
            memberDto.personDto = this.personDto;
            memberDto.licensePlateDto = this.licensePlateDto;
            memberDto.registrationDate = this.registrationDate;
            memberDto.membershipLevel = this.membershipLevel;

            return memberDto;
        }
    }
}
