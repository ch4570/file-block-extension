package com.flow.hirework.dto.response;

import com.flow.hirework.domain.DefaultExtension;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class DefaultExtensionResponseDto {

    String name;
    boolean isChecked;

    public DefaultExtensionResponseDto(DefaultExtension extension) {
        this.name = extension.getName();
        this.isChecked = extension.isChecked();
    }
}
