package com.example.parkshark.service;

import com.example.parkshark.domain.ParkingAllocation;
import com.example.parkshark.domain.dto.parkingAllocation.CreateParkingAllocationDto;
import com.example.parkshark.domain.dto.parkingAllocation.ParkingAllocationDto;
import com.example.parkshark.domain.member.Member;
import com.example.parkshark.domain.parkinglot.Parkinglot;
import com.example.parkshark.exceptions.MemberDoesNotExistException;
import com.example.parkshark.exceptions.ParkinglotDoesNotExistException;
import com.example.parkshark.mapper.MemberMapper;
import com.example.parkshark.mapper.ParkingAllocationMapper;
import com.example.parkshark.mapper.ParkinglotMapper;
import com.example.parkshark.repository.MemberRepository;
import com.example.parkshark.repository.ParkingAllocationRepository;
import com.example.parkshark.repository.ParkinglotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParkingAllocationService {

    private final ParkingAllocationRepository parkingAllocationRepository;
    private final ParkinglotRepository parkinglotRepository;
    private final MemberRepository memberRepository;
    private final ParkingAllocationMapper parkingAllocationMapper;
    private final MemberMapper memberMapper;
    private final ParkinglotMapper parkinglotMapper;

    public ParkingAllocationService(ParkingAllocationRepository parkingAllocationRepository,
                                    ParkinglotRepository parkinglotRepository,
                                    ParkingAllocationMapper parkingAllocationMapper,
                                    MemberRepository memberRepository,
                                    MemberMapper memberMapper,
                                    ParkinglotMapper parkinglotMapper) {
        this.parkingAllocationRepository = parkingAllocationRepository;
        this.parkinglotRepository = parkinglotRepository;
        this.parkingAllocationMapper = parkingAllocationMapper;
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
        this.parkinglotMapper = parkinglotMapper;
    }

    public List<ParkingAllocationDto> findAll(Boolean isActive) {
        if (isActive == null) {
            return parkingAllocationMapper.toDto(parkingAllocationRepository.findAll());
        }
        if (isActive) {
            return parkingAllocationMapper.toDto(parkingAllocationRepository.findParkingAllocationsByAllocationStatusIsTrue());
        }
        return parkingAllocationMapper.toDto(parkingAllocationRepository.findParkingAllocationsByAllocationStatusIsFalse());
    }

    public void saveParkingAllocation(CreateParkingAllocationDto createParkingAllocationDto) {
        validateInput(createParkingAllocationDto);

        Member member = this.memberRepository.getById(createParkingAllocationDto.getMemberId());
        Parkinglot parkinglot = this.parkinglotRepository.getById(createParkingAllocationDto.getParkinglotId());

        parkingAllocationRepository.save(parkingAllocationMapper.toEntity(createParkingAllocationDto, member, parkinglot));
    }

    public void stopParkingAllocation(int ParkingAllocationId, int memberId) {

    }

    public ParkingAllocationDto findById(int id) {
        if (parkingAllocationRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("There is no parking allocation with this id.");
        }
        return parkingAllocationMapper.toDto(parkingAllocationRepository.getById(id));
    }


    //HELPER METHODS
    private void validateInput(CreateParkingAllocationDto createParkingAllocationDto) {
        isMember(createParkingAllocationDto.getMemberId());
        isParkinglot(createParkingAllocationDto.getParkinglotId());
    }

    private void isMember(int memberId) {
        if(this.memberRepository.findById(memberId).isEmpty()) {
            throw new MemberDoesNotExistException(String.format("Member with id %s does not exist.", memberId));
        }
    }

    private void isParkinglot(int parkinglotId) {
        if(this.parkinglotRepository.findById(parkinglotId).isEmpty()) {
            throw new ParkinglotDoesNotExistException(String.format("Parkinglot with id %s does not exist.", parkinglotId));
        }
    }
}
