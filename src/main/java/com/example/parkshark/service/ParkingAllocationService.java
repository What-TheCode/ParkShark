package com.example.parkshark.service;

import com.example.parkshark.domain.ParkingAllocation;
import com.example.parkshark.domain.dto.parkingAllocation.CreateParkingAllocationDto;
import com.example.parkshark.domain.dto.parkingAllocation.ParkingAllocationDto;
import com.example.parkshark.domain.member.LicensePlate;
import com.example.parkshark.domain.member.Member;
import com.example.parkshark.domain.member.Membership;
import com.example.parkshark.domain.parkinglot.Parkinglot;
import com.example.parkshark.exceptions.LicensePlateDoesNotMatchException;
import com.example.parkshark.exceptions.MemberDoesNotExistException;
import com.example.parkshark.exceptions.ParkingLotFullException;
import com.example.parkshark.exceptions.ParkinglotDoesNotExistException;
import com.example.parkshark.mapper.MemberMapper;
import com.example.parkshark.mapper.ParkingAllocationMapper;
import com.example.parkshark.mapper.ParkinglotMapper;
import com.example.parkshark.repository.MemberRepository;
import com.example.parkshark.repository.ParkingAllocationRepository;
import com.example.parkshark.repository.ParkinglotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
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

    public void startAllocation(CreateParkingAllocationDto createParkingAllocationDto) {
        validateUserInput(createParkingAllocationDto);

        Member member = this.memberRepository.getById(createParkingAllocationDto.getMemberId());
        Parkinglot parkinglot = this.parkinglotRepository.getById(createParkingAllocationDto.getParkinglotId());
        LicensePlate licensePlate = member.getLicensePlate();

        parkingAllocationRepository.save(
                parkingAllocationMapper.toEntity(
                        createParkingAllocationDto, member, licensePlate, parkinglot));
    }


    public void stopParkingAllocation(int parkingAllocationId, int memberId) {
        if (parkingAllocationRepository.findById(parkingAllocationId).isPresent()) {
            ParkingAllocation parkingAllocation = parkingAllocationRepository.getById(parkingAllocationId);
            if (parkingAllocation.getMember().getId() == memberId && parkingAllocation.isAllocationStatus()) {
                parkingAllocation.setAllocationStatus(false);
                parkingAllocation.setStopTime(LocalDateTime.now());
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Parking allocation does not belong to this member.");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Parking allocation does not exist.");
        }
    }

    public ParkingAllocationDto findById(int id) {
        if (parkingAllocationRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("There is no parking allocation with this id.");
        }
        return parkingAllocationMapper.toDto(parkingAllocationRepository.getById(id));
    }


    //    The member is recognized by the system
    //       The provided license plate number is the same as the member's license plate number
//      It can be different, but only if the membership level is Gold
//      The parking lot is recognized by the system

//      The parking lot still has available capacity (it's not full)
//            Make sure that the (started) parking allocation is uniquely identifiable (hint).
//      Make sure that the member who started the parking allocation receives this id.
//      A parking allocation should have a start time (when did the member start the allocation?)


    //HELPER METHODS
    private void validateUserInput(CreateParkingAllocationDto createParkingAllocationDto) {
        isMember(createParkingAllocationDto.getMemberId());
        isParkinglot(createParkingAllocationDto.getParkinglotId());
        isLicensePlateNumberOfMember(createParkingAllocationDto.getMemberId(), createParkingAllocationDto.getLicensePlate());
        isFreeSpaceInParkinglot(createParkingAllocationDto.getParkinglotId());
    }

    private void isMember(int memberId) {
        if (this.memberRepository.findById(memberId).isEmpty()) {
            throw new MemberDoesNotExistException(String.format("Member with id %s does not exist.", memberId));
        }
    }

    private void isParkinglot(int parkinglotId) {
        if (this.parkinglotRepository.findById(parkinglotId).isEmpty()) {
            throw new ParkinglotDoesNotExistException(String.format("Parkinglot with id %s does not exist.", parkinglotId));
        }
    }

    private void isLicensePlateNumberOfMember(int memberId, String licensePlate) {
        Member member = this.memberRepository.getById(memberId);

        if (member.getMembershipLevel().equals(Membership.GOLD)) {
            return;
        }

        if (!member.getLicensePlate().getLicensePlateNumber().equalsIgnoreCase(licensePlate.trim())) {
            throw new LicensePlateDoesNotMatchException(
                    String.format(
                            "Licenseplate %s does not match that of the member", licensePlate));
        }
    }

    private void isFreeSpaceInParkinglot(int parkinglotId) {
        int parkinglotCapacity = this.parkinglotRepository.getById(parkinglotId).getCapacity();

        List<ParkingAllocation> parkingAllocationList =
                this.parkingAllocationRepository.findAllByParkinglotIdAndAllocationStatusTrue(parkinglotId);

        int currentParkingAllocationsForParkinglot =
                parkingAllocationList.size();

        if (parkinglotCapacity - currentParkingAllocationsForParkinglot <= 0) {
            throw new ParkingLotFullException("Parkinglot is full.");
        }
    }
}
