package com.example.schedule_develop.controller;


import com.example.schedule_develop.dto.LoginRequestDto;
import com.example.schedule_develop.dto.LoginResponseDto;
import com.example.schedule_develop.service.LogService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/log")
@RequiredArgsConstructor
public class LogController {
    private final LogService logService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {
        return ResponseEntity.ok(logService.login(loginRequestDto,request));
    }

    @PostMapping("/logout")
    public ResponseEntity<LoginResponseDto> logout(HttpServletRequest request, HttpServletResponse response) {
        logService.logout(request,response);
        return ResponseEntity.ok(new LoginResponseDto("로그아웃 되었습니다."));
    }

}
