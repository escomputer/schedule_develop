package com.example.schedule_develop.service;

import com.example.schedule_develop.dto.UserRequestDto;
import com.example.schedule_develop.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getUsers();
    UserResponseDto getUserById(Long id);
//    UserResponseDto createUser(UserRequestDto requestDto);
    UserResponseDto updateUser(Long id, UserRequestDto requestDto);
    void deleteUser(Long id);
    UserResponseDto registerUser(UserRequestDto requestDto);
}
