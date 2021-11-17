package com.example.parkshark.controller;

import com.example.parkshark.domain.dto.parkinglotDTO.CreateParkinglotDTO;
import com.example.parkshark.domain.dto.parkinglotDTO.ParkinglotDTO;
import com.example.parkshark.security.switchsecure.SecurityGuard;
import com.example.parkshark.service.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/parkinglots")
public class ParkinglotController {

    private final ParkinglotService parkinglotService;

    @Autowired
    public ParkinglotController(ParkinglotService parkinglotService) {
        this.parkinglotService = parkinglotService;
    }

    @PostMapping(MediaType.APPLICATION_JSON_VALUE)
    // @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    @ResponseStatus(HttpStatus.CREATED)
    public void createParkinglot(@RequestBody CreateParkinglotDTO createParkinglotDto) {
        parkinglotService.createParkinglot(createParkinglotDto);
    }

    @GetMapping(MediaType.APPLICATION_JSON_VALUE)
    // @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    @ResponseStatus(HttpStatus.OK)
    public List<ParkinglotDTO> getParkinglots() {
        return null;
    }
}
