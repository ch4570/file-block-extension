package com.flow.hirework.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "CUSTOM_EXTENSION")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomExtension extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;

    public String getName() {
        return name;
    }
}
