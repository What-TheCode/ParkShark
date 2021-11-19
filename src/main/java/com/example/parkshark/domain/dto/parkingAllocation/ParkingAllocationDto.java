package com.example.parkshark.domain.dto.parkingAllocation;

import com.example.parkshark.domain.ParkingAllocation;
import com.example.parkshark.domain.Person;
import com.example.parkshark.domain.dto.member.MemberDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDto;
import com.example.parkshark.domain.member.Member;
import com.example.parkshark.domain.parkinglot.Parkinglot;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

public class ParkingAllocationDto {

    private int id;
    private int memberId;
    private int parkinglotId;
    private String licensePlate;
    private LocalDateTime startingTime;
    private LocalDateTime stopTime;
    private boolean allocationStatus;

    public ParkingAllocationDto() {
    }

    public int getId() {
        return id;
    }

    public int getMember() {
        return memberId;
    }

    public int getParkinglot() {
        return parkinglotId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDateTime getStartingTime() {
        return startingTime;
    }

    public LocalDateTime getStopTime(){
        return stopTime;
    }

    public boolean isAllocationStatus() {
        return allocationStatus;
    }

    public static class Builder {
        private int memberId;
        private int parkinglotId;
        private String licensePlate;
        private LocalDateTime startingTime;
        private LocalDateTime stopTime;
        private boolean allocationStatus;

        public ParkingAllocationDto.Builder withMemberId(int memberId) {
            this.memberId = memberId;
            return this;
        }

        public ParkingAllocationDto.Builder withParkinglotId(int parkinglotId) {
            this.parkinglotId = parkinglotId;
            return this;
        }

        public ParkingAllocationDto.Builder withLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public ParkingAllocationDto.Builder withStartingTime(LocalDateTime startingTime) {
            this.startingTime = startingTime;
            return this;
        }

        public ParkingAllocationDto.Builder withAllocationStatus(boolean allocationStatus) {
            this.allocationStatus = allocationStatus;
            return this;
        }

        public ParkingAllocationDto.Builder withStopTime(LocalDateTime stopTime){
            this.stopTime =stopTime;
            return this;
        }

        public ParkingAllocationDto build() {
            ParkingAllocationDto parkingAllocationDto = new ParkingAllocationDto();
            parkingAllocationDto.memberId = this.memberId;
            parkingAllocationDto.parkinglotId = this.parkinglotId;
            parkingAllocationDto.licensePlate = this.licensePlate;
            parkingAllocationDto.startingTime = this.startingTime;
            parkingAllocationDto.stopTime=this.stopTime;
            parkingAllocationDto.allocationStatus = this.allocationStatus;

            return parkingAllocationDto;
        }


    }
}
