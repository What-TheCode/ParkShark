package com.example.parkshark.controller;

import com.example.parkshark.domain.Division;
import com.example.parkshark.domain.dto.DivisionDto;
import com.example.parkshark.mapper.DivisionMapper;
import com.example.parkshark.security.switchsecure.SecurityGuard;
import com.example.parkshark.service.DivisionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public void createDivision(@RequestBody DivisionDto divisionDto,
                               @RequestHeader String Authorization ){
        divisionService.saveDivision(divisionDto);
    }

}
