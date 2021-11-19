package com.example.parkshark.repository;

import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.ParkingAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingAllocationRepository extends JpaRepository<ParkingAllocation, Integer> {
    List<ParkingAllocation> findParkingAllocationsByAllocationStatusIsTrue();

    List<ParkingAllocation> findParkingAllocationsByAllocationStatusIsFalse();
}
