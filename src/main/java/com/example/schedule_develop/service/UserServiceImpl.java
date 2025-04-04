package com.example.schedule_develop.service;

import com.example.schedule_develop.dto.UserRequestDto;
import com.example.schedule_develop.dto.UserResponseDto;
import com.example.schedule_develop.entity.User;
import com.example.schedule_develop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<UserResponseDto> getUsers(){
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());

    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("해당 유저가 없습니다."));
        return new UserResponseDto(user);
    }

//    @Override
//    @Transactional
//    public UserResponseDto createUser(UserRequestDto requestDto) {
//    User user = requestDto.toEntity();
//    User savedUser = userRepository.save(user);
//
//        return new UserResponseDto(savedUser);
//    }

    // register (회원가입) 진행시 유저가 생성되므로, create user 은 삭제

    @Override
    @Transactional
    public UserResponseDto updateUser(Long id, UserRequestDto requestDto) {
        User user =userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 일정이 없습니다."));
        user.setUsername(requestDto.getUsername());
        user.setEmail(requestDto.getEmail());
        return new UserResponseDto(userRepository.save(user));
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDto registerUser(UserRequestDto requestDto) {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
        User user = new User();
        user.setUsername(requestDto.getUsername());
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());

        User savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser);
    }

}
