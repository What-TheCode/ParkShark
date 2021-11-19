package com.example.parkshark.controller;

import com.example.parkshark.domain.dto.parkingAllocation.CreateParkingAllocationDto;
import com.example.parkshark.domain.dto.parkingAllocation.ParkingAllocationDto;
import com.example.parkshark.security.switchsecure.SecurityGuard;
import com.example.parkshark.service.ParkingAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/allocation")
public class ParkingAllocationController {

    private final ParkingAllocationService parkingAllocationService;

    @Autowired
    public ParkingAllocationController(ParkingAllocationService parkingAllocationService) {
        this.parkingAllocationService = parkingAllocationService;
    }

    @GetMapping(produces = "application/json")
    @SecurityGuard(SecurityGuard.ApiUserRole.MANAGER)
    @ResponseStatus(HttpStatus.OK)
    public List<ParkingAllocationDto> getAllocations(@RequestParam(required = false) Boolean isActive) {
        return parkingAllocationService.findAll(isActive);
    }

    @PostMapping(consumes = "application/json")
    @SecurityGuard(SecurityGuard.ApiUserRole.MEMBER)
    @ResponseStatus(HttpStatus.CREATED)
    public void startAllocation(@RequestBody CreateParkingAllocationDto createParkingAllocationDto) {
        parkingAllocationService.startAllocation(createParkingAllocationDto);
    }

    @PutMapping(consumes = "application/json", path = "/{id}")
    @SecurityGuard(SecurityGuard.ApiUserRole.MEMBER)
    @ResponseStatus(HttpStatus.OK)
    public void stopAllocation(@PathVariable("id") int id,
                               @RequestParam int memberId) {
        parkingAllocationService.stopParkingAllocation(id, memberId);
    }
}
