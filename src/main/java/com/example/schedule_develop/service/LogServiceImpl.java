package com.example.schedule_develop.service;

import com.example.schedule_develop.dto.LoginRequestDto;
import com.example.schedule_develop.dto.LoginResponseDto;
import com.example.schedule_develop.entity.User;
import com.example.schedule_develop.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public LoginResponseDto login(LoginRequestDto loginRequestDto, HttpServletRequest request){
        User user= userRepository.findByEmail(loginRequestDto.getEmail())
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 이메일입니다."));
        if(!user.getPassword().equals(loginRequestDto.getPassword())){
            throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        return new LoginResponseDto("로그인에 성공하였습니다.");

    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if(session != null){
            session.invalidate();
        }

    }
}
