package com.example.parkshark.controller;

import com.example.parkshark.domain.dto.DivisionDto;
import com.example.parkshark.security.switchsecure.SecurityGuard;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("division")
public class DivisionController {
    @PostMapping()
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public DivisionDto createDivision(){

    }

}
