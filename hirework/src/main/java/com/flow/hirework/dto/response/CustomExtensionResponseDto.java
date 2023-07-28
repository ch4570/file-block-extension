package com.flow.hirework.dto.response;


import com.flow.hirework.domain.CustomExtension;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CustomExtensionResponseDto {
    String name;

    public CustomExtensionResponseDto(CustomExtension customExtension) {
        this.name = customExtension.getName();
    }
}
