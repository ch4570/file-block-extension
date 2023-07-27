package com.flow.hirework.dto;


import com.flow.hirework.domain.CustomExtension;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class CustomExtensionDto {

    @Length(max = 20)
    private String name;


    public CustomExtension toEntity() {
        return CustomExtension.builder()
                .name(name)
                .build();
    }
}
