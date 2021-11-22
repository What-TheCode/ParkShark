package com.example.parkshark.domain.dto.parkingAllocation;

public class CreateParkingAllocationDto {
    private final int memberId;
    private final int parkinglotId;
    private final String licensePlate;

    public CreateParkingAllocationDto(int memberId, int parkinglotId, String licensePlate) {
        this.memberId = memberId;
        this.parkinglotId = parkinglotId;
        this.licensePlate = licensePlate;
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
}
