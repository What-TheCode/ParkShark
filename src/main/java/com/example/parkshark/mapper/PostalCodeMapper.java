package com.example.parkshark.mapper;

import com.example.parkshark.domain.address.PostalCode;
import com.example.parkshark.domain.dto.address.CreatePostalCodeDto;
import org.springframework.stereotype.Component;

@Component
public class PostalCodeMapper {

    public PostalCode toEntity(CreatePostalCodeDto createPostalCodeDTO) {
        return new PostalCode.Builder()
                .withPostalCode(createPostalCodeDTO.getPostalCode())
                .withRegion(createPostalCodeDTO.getRegion())
                .build();
    }

}
