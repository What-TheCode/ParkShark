package com.example.parkshark.domain;

import com.example.parkshark.domain.member.Member;
import com.example.parkshark.domain.parkinglot.Parkinglot;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking_allocation")
public class ParkingAllocation {

    @Id
    @SequenceGenerator(name = "parking_allocation_id_seq", sequenceName = "parking_allocation_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "parking_allocation_id_seq")
    private int id;

    @JoinColumn(name = "member_id")
    @OneToOne
    private Member member;

    @JoinColumn(name = "parkinglot_id")
    @ManyToOne
    private Parkinglot parkinglot;

    @Column(name = "license_plate_number")
    private String licensePlate;

    @Column(name = "starting_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime startingTime;

    @Column(name = "stop_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime stopTime;

    @Column(name = "allocation_status")
    private boolean allocationStatus;

    public ParkingAllocation() {
    }

    public int getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public Parkinglot getParkinglot() {
        return parkinglot;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDateTime getStartingTime() {
        return startingTime;
    }

    public LocalDateTime getStopTime() {
        return stopTime;
    }

    public boolean isAllocationStatus() {
        return allocationStatus;
    }

    public ParkingAllocation setStopTime(LocalDateTime stopTime) {
        this.stopTime = stopTime;
        return this;
    }

    public ParkingAllocation setAllocationStatus(boolean allocationStatus) {
        this.allocationStatus = allocationStatus;
        return this;
    }

    public static class Builder {
        private Member member;
        private Parkinglot parkinglot;
        private String licensePlate;
        private LocalDateTime startingTime;
        private LocalDateTime stopTime;
        private boolean allocationStatus;

        public ParkingAllocation.Builder withMember(Member member) {
            this.member = member;
            return this;
        }

        public ParkingAllocation.Builder withParkinglot(Parkinglot parkinglot) {
            this.parkinglot = parkinglot;
            return this;
        }

        public ParkingAllocation.Builder withLicensePlat(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public ParkingAllocation.Builder withStartingTime(LocalDateTime startingTime) {
            this.startingTime = startingTime;
            return this;
        }

        public ParkingAllocation.Builder withAllocationStatus(boolean allocationStatus) {
            this.allocationStatus = allocationStatus;
            return this;
        }

        public ParkingAllocation.Builder withStopTime(LocalDateTime stopTime) {
            this.stopTime = stopTime;
            return this;
        }

        public ParkingAllocation build() {
            ParkingAllocation parkingAllocation = new ParkingAllocation();
            parkingAllocation.member = this.member;
            parkingAllocation.parkinglot = this.parkinglot;
            parkingAllocation.licensePlate = this.licensePlate;
            parkingAllocation.startingTime = this.startingTime;
            parkingAllocation.stopTime = this.stopTime;
            parkingAllocation.allocationStatus = this.allocationStatus;

            return parkingAllocation;
        }


    }
}
