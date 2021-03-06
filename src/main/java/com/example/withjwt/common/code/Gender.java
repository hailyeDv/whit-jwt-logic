package com.example.withjwt.common.code;

import lombok.Getter;

@Getter
public enum Gender {
    MAN("남성"), WOMAN("여성");

    private final String description;

    Gender(String description) {
        this.description = description;
    }
}
