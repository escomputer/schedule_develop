package com.example.schedule_develop.service;

import com.example.schedule_develop.dto.LoginRequestDto;
import com.example.schedule_develop.dto.LoginResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface LogService {

    LoginResponseDto login(LoginRequestDto loginRequestDto, HttpServletRequest request);

    void logout(HttpServletRequest request, HttpServletResponse response);
}
