package com.example.parkshark.controller;

import com.example.parkshark.domain.dto.parkinglot.CreateParkinglotDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDetailDto;
import com.example.parkshark.domain.dto.parkinglot.ParkinglotDto;
import com.example.parkshark.service.ParkinglotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/parkinglots")
public class ParkinglotController {

    private final ParkinglotService parkinglotService;
    private final Logger logger = LoggerFactory.getLogger(ParkinglotController.class);

    @Autowired
    public ParkinglotController(ParkinglotService parkinglotService) {
        this.parkinglotService = parkinglotService;
    }

    @PostMapping(MediaType.APPLICATION_JSON_VALUE)
    // @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    @ResponseStatus(HttpStatus.CREATED)
    public void createParkinglot(@RequestBody CreateParkinglotDto createParkinglotDto) {
        try {
            parkinglotService.createParkinglot(createParkinglotDto);
            logger.info("Parkinglot created");
        } catch (RuntimeException e) {
            logger.warn("Parkinglot not created.");
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, e.getMessage());
        }
    }

    @GetMapping(MediaType.APPLICATION_JSON_VALUE)
    // @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    @ResponseStatus(HttpStatus.OK)
    public List<ParkinglotDto> getParkinglots() {
        return parkinglotService.getAll();
    }

    @GetMapping(produces = "application/json", path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ParkinglotDetailDto getParkinglotById(@PathVariable("id") String id) {
        return parkinglotService.getById(id);
    }
}
