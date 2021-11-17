package com.example.parkshark.mapper;

import com.example.parkshark.domain.address.PostalCode;
import com.example.parkshark.domain.dto.address.CreatePostalCodeDTO;
import org.springframework.stereotype.Component;

@Component
public class PostalCodeMapper {

    public PostalCode toEntity(CreatePostalCodeDTO createPostalCodeDTO) {
        return new PostalCode.Builder()
                .withPostalCode(createPostalCodeDTO.getPostalCode())
                .withRegion(createPostalCodeDTO.getRegion())
                .build();
    }

}
