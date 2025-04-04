package com.example.schedule_develop.dto;

import com.example.schedule_develop.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private String username;
    private String email;
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserResponseDto(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.id = user.getId();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();

    }

}
