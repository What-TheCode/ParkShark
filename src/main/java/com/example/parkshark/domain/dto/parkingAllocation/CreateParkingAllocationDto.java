package com.example.parkshark.domain.dto.parkingAllocation;

import com.example.parkshark.domain.dto.member.MemberDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDetailDto;

import java.time.LocalDateTime;

public class CreateParkingAllocationDto {
    private final int memberId;
    private final int parkinglotId;
    private final String licensePlate;
    private final boolean allocationStatus;

    public CreateParkingAllocationDto(int memberId, int parkinglotId, String licensePlate, boolean allocationStatus) {
        this.memberId = memberId;
        this.parkinglotId = parkinglotId;
        this.licensePlate = licensePlate;
        this.allocationStatus = allocationStatus;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getParkinglotId() {
        return parkinglotId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isAllocationStatus() {
        return allocationStatus;
    }
}
