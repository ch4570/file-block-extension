package com.flow.hirework.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Table(name = "DEFAULT_EXTENSION")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DefaultExtension extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public String getName() {
        return name;
    }
}
