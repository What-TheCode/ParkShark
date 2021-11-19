package com.example.parkshark.controller;

import com.example.parkshark.domain.dto.member.CreateMemberWithPersonIdDto;
import com.example.parkshark.domain.dto.member.MemberDto;
import com.example.parkshark.security.switchsecure.SecurityGuard;
import com.example.parkshark.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/members")
public class MemberController {

    private final MemberService memberService;
    private final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //TODO ApiUserRole MANAGER can also create a Member. This can't be possible.
    @PostMapping(consumes = "application/json")
    @SecurityGuard(SecurityGuard.ApiUserRole.MEMBER)
    @ResponseStatus(HttpStatus.CREATED)
    public void createMember(@RequestBody CreateMemberWithPersonIdDto createMemberDto) {
            memberService.createMember(createMemberDto);
            logger.info("Member created");
    }

    @GetMapping(produces = "application/json")
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    @ResponseStatus(HttpStatus.OK)
    public List<MemberDto> getMembers() {
        return this.memberService.getAll();
    }

    @GetMapping(produces = "application/json", path = "/{id}")
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    @ResponseStatus(HttpStatus.OK)
    public MemberDto getMember(@PathVariable("id") String id) {
            return this.memberService.getById(id);

    }
}
