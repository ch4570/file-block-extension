package com.flow.hirework.dto.request;


import com.flow.hirework.domain.CustomExtension;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@ToString
public class CustomExtensionRequestDto {

    @Length(max = 20)
    @NotBlank
    private String name;


    public CustomExtension toEntity() {
        return CustomExtension.builder()
                .name(name)
                .build();
    }
}
