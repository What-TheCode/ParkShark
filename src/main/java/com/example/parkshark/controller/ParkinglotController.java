package com.example.parkshark.controller;

import com.example.parkshark.domain.dto.parkinglot.CreateParkinglotDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDto;
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
    public void createParkinglot(@RequestBody CreateParkinglotDto createParkinglotDto) {
        parkinglotService.createParkinglot(createParkinglotDto);
    }

    @GetMapping(MediaType.APPLICATION_JSON_VALUE)
    // @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    @ResponseStatus(HttpStatus.OK)
    public List<ParkinglotDto> getParkinglots() {
        return parkinglotService.getAll();
    }
/*
    @GetMapping(value = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ParkinglotDto getParkinglotById(@PathVariable("id") String id) {
        return parkinglotService.getById(id);
    }

 */
}
