package com.example.parkshark.repository;

import com.example.parkshark.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Person,Integer> {
}
