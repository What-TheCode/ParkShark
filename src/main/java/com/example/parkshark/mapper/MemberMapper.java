package com.example.parkshark.mapper;

import com.example.parkshark.domain.dto.member.CreateMemberWithPersonDto;
import com.example.parkshark.domain.dto.member.CreateMemberWithPersonIdDto;
import com.example.parkshark.domain.dto.member.MemberDto;
import com.example.parkshark.domain.member.Member;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MemberMapper {

    private final LicensePlateMapper licensePlateMapper;

    public MemberMapper(LicensePlateMapper licensePlateMapper) {
        this.licensePlateMapper = licensePlateMapper;
    }

    public Member toEntity(CreateMemberWithPersonDto createMemberDto) {
        return new Member.Builder()
                .withPerson(createMemberDto.getPerson())
                .withLicensePlate(licensePlateMapper.toEntity(createMemberDto.getCreateLicensePlateDto()))
                .withRegistrationDate(createMemberDto.getRegistrationDate())
                .withMembershipLevel(createMemberDto.getMembershipLevel())
                .build();
    }

    public List<MemberDto> toDto(List<Member> members) {
        return members.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public MemberDto toDto(Member member) {
        return new MemberDto(
                member.getId(),
                member.getPerson(),
                this.licensePlateMapper.toDto(member.getLicensePlate()),
                member.getRegistrationDate(),
                member.getMembershipLevel().getValue()
        );
    }
}
