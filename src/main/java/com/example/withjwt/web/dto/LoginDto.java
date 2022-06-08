package com.example.withjwt.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class LoginDto {

    @NotNull
    private String userName;

    @NotNull
    private String password;

}
