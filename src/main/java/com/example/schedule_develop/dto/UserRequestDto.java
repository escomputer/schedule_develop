package com.example.schedule_develop.dto;

import com.example.schedule_develop.entity.User;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String username;
    private String email;
    private String password;

    public User toEntity() {
        User user = new User();
        user.setUsername(this.username);
        user.setEmail(this.email);
        return user;
    }
}
