package com.example.parkshark.controller;

import com.example.parkshark.domain.dto.division.CreateDivisionDto;
import com.example.parkshark.domain.dto.division.DivisionDto;
import com.example.parkshark.security.switchsecure.SecurityGuard;
import com.example.parkshark.service.DivisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("division")
public class DivisionController {
    private final DivisionService divisionService;
    private final Logger logger = LoggerFactory.getLogger(DivisionController.class);

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public void createDivision(@RequestBody CreateDivisionDto createDivisionDto) {
        logger.info("Division is created with name " + createDivisionDto.getName() + ".");
        divisionService.saveDivision(createDivisionDto);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public List<DivisionDto> getAllDivision() {
        logger.info("All Division are retrieved.");
        return divisionService.findAll();
    }

    @GetMapping(path = "/{divisionId}", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    public DivisionDto getById(@PathVariable int divisionId) {
        logger.info("Division with " + divisionId + " is retrieved.");
        return divisionService.findById((divisionId));
    }

}
