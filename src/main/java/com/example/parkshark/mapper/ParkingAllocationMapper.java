package com.example.parkshark.mapper;

import com.example.parkshark.domain.ParkingAllocation;
import com.example.parkshark.domain.dto.parkingAllocation.CreateParkingAllocationDto;
import com.example.parkshark.domain.dto.parkingAllocation.ParkingAllocationDto;
import com.example.parkshark.domain.member.LicensePlate;
import com.example.parkshark.domain.member.Member;
import com.example.parkshark.domain.parkinglot.Parkinglot;
import com.example.parkshark.repository.MemberRepository;
import com.example.parkshark.repository.ParkingAllocationRepository;
import com.example.parkshark.repository.ParkinglotRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingAllocationMapper {

    private final MemberMapper memberMapper;
    private final ParkinglotMapper parkinglotMapper;
    private final MemberRepository memberRepository;
    private final ParkinglotRepository parkinglotRepository;

    public ParkingAllocationMapper(MemberMapper memberMapper, ParkinglotMapper parkinglotMapper, MemberRepository memberRepository, ParkinglotRepository parkinglotRepository) {
        this.memberMapper = memberMapper;
        this.parkinglotMapper = parkinglotMapper;
        this.memberRepository = memberRepository;
        this.parkinglotRepository = parkinglotRepository;
    }

    public ParkingAllocation toEntity(CreateParkingAllocationDto createParkingAllocationDto,
                                      Member member,
                                      LicensePlate licensePlate,
                                      Parkinglot parkinglot) {
        return new ParkingAllocation.Builder()
                .withMember(member)
                .withParkinglot(parkinglot)
                .withLicensePlat(createParkingAllocationDto.getLicensePlate())
                .withStartingTime(LocalDateTime.now())
                .withAllocationStatus(createParkingAllocationDto.isAllocationStatus())
                .build();
    }

    public ParkingAllocationDto toDto(ParkingAllocation parkingAllocation) {
        return new ParkingAllocationDto.Builder()
                .withMemberId(memberMapper.toDto(parkingAllocation.getMember()).getId())
                .withParkinglotId(parkinglotMapper.toDto(parkingAllocation.getParkinglot()).getId())
                .withLicensePlate(parkingAllocation.getLicensePlate())
                .withStartingTime(parkingAllocation.getStartingTime())
                .withStopTime(parkingAllocation.getStopTime())
                .withAllocationStatus(parkingAllocation.isAllocationStatus())
                .build();
    }

    public List<ParkingAllocationDto> toDto(List<ParkingAllocation> parkingAllocationList) {
        return parkingAllocationList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
