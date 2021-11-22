package com.example.parkshark.mapper;

import com.example.parkshark.domain.dto.member.CreateLicensePlateDto;
import com.example.parkshark.domain.dto.member.LicensePlateDto;
import com.example.parkshark.domain.member.LicensePlate;
import org.springframework.stereotype.Component;

@Component
public class LicensePlateMapper {

    public LicensePlate toEntity(CreateLicensePlateDto createLicensePlateDto) {
        return new LicensePlate.Builder()
                .withLicensePlateNumber(createLicensePlateDto.getLicensePlateNumber())
                .withIssuingCountry(createLicensePlateDto.getIssuingCountry())
                .build();
    }

    public LicensePlate toEntity(LicensePlateDto licensePlateDto) {
        return new LicensePlate.Builder()
                .withLicensePlateNumber(licensePlateDto.getLicensePlateNumber())
                .withIssuingCountry(licensePlateDto.getIssuingCountry())
                .build();
    }

    public LicensePlateDto toDto(LicensePlate licensePlate) {
        return new LicensePlateDto.Builder()
                .withId(licensePlate.getId())
                .withLicensePlateNumber(licensePlate.getLicensePlateNumber())
                .withIssuingCountry(licensePlate.getIssuingCountry())
                .build();
    }
}
