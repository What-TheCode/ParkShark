package com.example.parkshark.mapper;

import com.example.parkshark.domain.address.PostalCode;
import com.example.parkshark.domain.dto.address.CreatePostalCodeDto;
import com.example.parkshark.domain.dto.address.PostalCodeDto;
import org.springframework.stereotype.Component;

@Component
public class PostalCodeMapper {

    public PostalCode toEntity(CreatePostalCodeDto createPostalCodeDTO) {
        return new PostalCode.Builder()
                .withPostalCode(createPostalCodeDTO.getPostalCode())
                .withRegion(createPostalCodeDTO.getRegion())
                .build();
    }

    public PostalCode toEntity(PostalCodeDto PostalCodeDTO) {
        return new PostalCode.Builder()
                .withPostalCode(PostalCodeDTO.getPostalCode())
                .withRegion(PostalCodeDTO.getRegion())
                .build();
    }

    public PostalCodeDto toDto(PostalCode postalCode){
        return new PostalCodeDto.Builder()
                .withPostalCode(postalCode.getPostalCode())
                .withRegion(postalCode.getRegion())
                .build();
    }

}
