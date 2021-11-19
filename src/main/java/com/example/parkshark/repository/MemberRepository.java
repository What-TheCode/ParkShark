package com.example.parkshark.repository;

import com.example.parkshark.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByPersonId(int id);

}
