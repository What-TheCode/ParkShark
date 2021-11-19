package com.example.parkshark.domain;

import com.example.parkshark.domain.member.LicensePlate;
import com.example.parkshark.domain.member.Member;
import com.example.parkshark.domain.parkinglot.Parkinglot;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking_allocation")
public class ParkingAllocation {

    @Id
    @SequenceGenerator(name = "parking_allocation_seq", sequenceName = "parking_allocation_seq",initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "parking_allocation_seq")
    private int id;
    @JoinColumn(name = "member_id")
    @OneToOne
    private Member member;
    @JoinColumn(name = "parkinglot_id")
    @ManyToOne
    private Parkinglot parkinglot;
    @Column(name = "license_plate_id")
    private String licensePlate;
    @Column(name = "starting_time")
    private LocalDateTime startingTime;
    @Column(name = "allocation_status")
    private boolean allocationStatus;


}
