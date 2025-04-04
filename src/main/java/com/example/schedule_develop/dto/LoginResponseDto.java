package com.example.schedule_develop.dto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private String message;

    public LoginResponseDto(String message) {
        this.message = message;
    }
}
