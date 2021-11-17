package com.example.parkshark.controller;

import com.example.parkshark.domain.parkinglot.Parkinglot;
import com.example.parkshark.security.switchsecure.SecurityGuard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/parkinglots")
public class ParkinglotController {

    private final ParkinglotService parkinglotService;
    private final ParkinglotMapper parkinglotMapper;

    @Autowired
    public ParkinglotController(ParkinglotService parkinglotService, ParkinglotMapper parkinglotMapper) {
        this.parkinglotService = parkinglotService;
        this.parkinglotMapper = parkinglotMapper;
    }

    @PostMapping(MediaType.APPLICATION_JSON_VALUE)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    @ResponseStatus(HttpStatus.CREATED)
    public ParkinglotDto createParkinglot(@RequestBody CreateParkinglotDto createParkinglotDto) {
        Parkinglot parkinglot = parkinglotService.create(parkinglotMapper.toParkinglot(createParkinglotDto));
        return parkinglotMapper.toParkinglotDto(parkinglot);
    }

    @GetMapping(MediaType.APPLICATION_JSON_VALUE)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    @ResponseStatus(HttpStatus.OK)
    public List<ParkinglotDto> getParkinglots() {
        return parkinglotMapper.toParkinglotDto(parkinglotService.getAll());
    }
}
