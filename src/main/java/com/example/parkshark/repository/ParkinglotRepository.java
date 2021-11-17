package com.example.parkshark.repository;

import com.example.parkshark.domain.parkinglot.Parkinglot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkinglotRepository extends JpaRepository<Parkinglot, Integer> {

}
