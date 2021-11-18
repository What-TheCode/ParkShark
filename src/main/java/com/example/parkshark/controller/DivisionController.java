package com.example.parkshark.controller;

import com.example.parkshark.domain.dto.division.CreateDivisionDto;
import com.example.parkshark.domain.dto.division.DivisionDto;
import com.example.parkshark.security.switchsecure.SecurityGuard;
import com.example.parkshark.service.DivisionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("division")
public class DivisionController {
    public final DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @PostMapping(consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public void createDivision(@RequestBody CreateDivisionDto createDivisionDto) {
        divisionService.saveDivision(createDivisionDto);
    }

    @GetMapping(produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    //    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public List<DivisionDto> getAllDivision(/*@RequestHeader String Authorization*/){
        return divisionService.findAll();
    }

}
