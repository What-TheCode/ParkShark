package com.example.parkshark.service;

import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.address.Address;
import com.example.parkshark.domain.dto.member.CreateLicensePlateDto;
import com.example.parkshark.domain.dto.member.CreateMemberDto;
import com.example.parkshark.domain.dto.member.CreateMemberWithPersonDto;
import com.example.parkshark.domain.member.Membership;
import com.example.parkshark.exceptions.PersonDoesNotExistException;
import com.example.parkshark.mapper.MemberMapper;
import com.example.parkshark.repository.MemberRepository;
import com.example.parkshark.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

class MemberServiceTest {

    private MemberService memberService;
    private MemberRepository memberRepository;
    private MemberMapper memberMapper;
    private PersonRepository personRepository;
    private Person person;
    private CreateMemberDto createMemberDto;

    @BeforeEach
    void setup() {

        memberRepository = Mockito.mock(MemberRepository.class);
        memberMapper = Mockito.mock(MemberMapper.class);
        personRepository = Mockito.mock(PersonRepository.class);
        memberService = new MemberService(memberRepository, personRepository, memberMapper);
        person = new Person.Builder()
                .withId(10)
                .withAddress(new Address.Builder()
                        .withId(1)
                        .withStreetName("sinterklaaslaan")
                        .withStreetNumber(10)
                        .withPostalCode(3000)
                        .withRegion("Leuven")
                        .build())
                .build();
        createMemberDto = new CreateMemberDto(1, new CreateLicensePlateDto(), "BRONZE");

    }

//    @DisplayName("registering a member")
//    @Nested
//    class registerAMember {
//        @DisplayName("when person exist -> save method is called in repo")
//        @Test
//        void whenMemberIsRegistered_ThenInTheMemberRepoTheSavedMethodIsCalledOnce() {
//            //GIVEN
//            //WHEN
//            memberService.createMember(createMemberDto);
//            //THEN
//            Mockito.verify(memberRepository, Mockito.times(1)).save(Mockito.any());
//        }
//
//        @DisplayName("when person does not exist --> fails")
//        @org.junit.Test(expected = PersonDoesNotExistException.class)
//        void whenRegisteringAMemberWithoutExistingPerson_ThenItThrowAnException() {
//            //GIVEN
//
//            //WHEN
//            memberService.createMember(createMemberDto);
//            //THEN
//        }
//    }


}