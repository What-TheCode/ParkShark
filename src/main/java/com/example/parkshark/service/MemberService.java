package com.example.parkshark.service;

import com.example.parkshark.domain.dto.member.CreateMemberWithPersonDto;
import com.example.parkshark.domain.dto.member.CreateMemberWithPersonIdDto;
import com.example.parkshark.domain.dto.member.MemberDto;
import com.example.parkshark.domain.member.Member;
import com.example.parkshark.domain.member.Membership;
import com.example.parkshark.exceptions.MemberDoesNotExistException;
import com.example.parkshark.exceptions.MembershipDoesNotExistException;
import com.example.parkshark.exceptions.PersonDoesNotExistException;
import com.example.parkshark.mapper.MemberMapper;
import com.example.parkshark.repository.MemberRepository;
import com.example.parkshark.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final PersonRepository personRepository;
    private final MemberMapper memberMapper;

    private final Logger logger = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    public MemberService(MemberRepository memberRepository,
                         PersonRepository personRepository,
                         MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.personRepository = personRepository;
        this.memberMapper = memberMapper;
    }

    //TODO Check if person already is a member or not before creating new Member.
    public void createMember(CreateMemberWithPersonIdDto createMemberDto) {
        if (this.personRepository.findById(createMemberDto.getPersonId()).isEmpty()) {
            logger.warn("Member not created.");
            throw new PersonDoesNotExistException(
                    String.format("Person with id %s does not exist.", createMemberDto.getPersonId()));
        }

        String membershipLevel = createMemberDto.getMembershipLevel();
        if (!membershipLevel.equalsIgnoreCase(Membership.BRONZE.getValue())
                && !membershipLevel.equalsIgnoreCase(Membership.SILVER.getValue())
                && !membershipLevel.equalsIgnoreCase(Membership.GOLD.getValue())) {
            logger.warn("Member not created.");
            throw new MembershipDoesNotExistException(
                    String.format("Membership %s does not exist.", createMemberDto.getMembershipLevel()));
        }

        CreateMemberWithPersonDto createMemberWithPersonDto = new CreateMemberWithPersonDto(
                this.personRepository.getById(createMemberDto.getPersonId()),
                createMemberDto.getCreateLicensePlateDto(),
                LocalDateTime.now(),
                Membership.valueOf(membershipLevel)
        );

        this.memberRepository.save(this.memberMapper.toEntity(createMemberWithPersonDto));
        logger.warn("Member created.");
    }

    public List<MemberDto> getAll() {
        return this.memberMapper.toDto(this.memberRepository.findAll());
    }

    public MemberDto getById(String id) {
        int currentId = Integer.parseInt(id);
        Member member = this.memberRepository.findById(currentId).orElse(null);

        if (member == null) {
            throw new MemberDoesNotExistException(String.format("Member with id %s not found.", id));
        }

        return this.memberMapper.toDto(member);
    }
}
