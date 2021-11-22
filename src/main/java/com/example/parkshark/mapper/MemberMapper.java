package com.example.parkshark.mapper;

import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.dto.member.CreateMemberDto;
import com.example.parkshark.domain.dto.member.CreateMemberWithPersonDto;
import com.example.parkshark.domain.dto.member.MemberDto;
import com.example.parkshark.domain.member.Member;
import com.example.parkshark.domain.member.Membership;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

    private final LicensePlateMapper licensePlateMapper;
    private final PersonMapper personMapper;

    public MemberMapper(LicensePlateMapper licensePlateMapper, PersonMapper personMapper) {
        this.licensePlateMapper = licensePlateMapper;
        this.personMapper = personMapper;
    }

    public Member toEntity(CreateMemberDto createMemberDto, Person person) {
        return new Member.Builder()
                .withPerson(person)
                .withLicensePlate(licensePlateMapper.toEntity(createMemberDto.getCreateLicensePlateDto()))
                .withRegistrationDate(LocalDateTime.now())
                .withMembershipLevel(Membership.valueOf(createMemberDto.getMembershipLevel().trim().toUpperCase()))
                .build();
    }

    public Member toEntity(CreateMemberWithPersonDto createMemberDto) {
        return new Member.Builder()
                .withPerson(createMemberDto.getPerson())
                .withLicensePlate(licensePlateMapper.toEntity(createMemberDto.getCreateLicensePlateDto()))
                .withRegistrationDate(LocalDateTime.now())
                .withMembershipLevel(createMemberDto.getMembershipLevel())
                .build();
    }

    public Member toEntity(MemberDto memberDto) {
        return new Member.Builder()
                .withPerson(this.personMapper.toEntity(memberDto.getPerson()))
                .withLicensePlate(this.licensePlateMapper.toEntity(memberDto.getLicensePlateDto()))
                .withRegistrationDate(LocalDateTime.now())
                .withMembershipLevel(Membership.valueOf(memberDto.getMembershipLevel()))
                .build();
    }

    public List<MemberDto> toDto(List<Member> members) {
        return members.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public MemberDto toDto(Member member) {
        return new MemberDto.Builder()
                .withId(member.getId())
                .withPersonDto(this.personMapper.toDto(member.getPerson()))
                .withLicensePlateDto(this.licensePlateMapper.toDto(member.getLicensePlate()))
                .withRegistrationDate(member.getRegistrationDate())
                .withMembershipLevel(member.getMembershipLevel().getValue())
                .build();
    }
}
