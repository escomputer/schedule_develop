package com.example.schedule_develop.service;

import com.example.schedule_develop.dto.ScheduleRequestDto;
import com.example.schedule_develop.dto.ScheduleResponseDto;
import com.example.schedule_develop.entity.Schedule;
import com.example.schedule_develop.entity.User;
import com.example.schedule_develop.repository.ScheduleRepository;
import com.example.schedule_develop.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new RuntimeException("해당 일정이 존재하지 않습니다."));

        Schedule schedule = requestDto.toEntity(user); //entity 바로 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule);
    }


    @Override
    public List<ScheduleResponseDto> getSchedules() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public ScheduleResponseDto getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("해당 아이디에 맞는 일정이 없습니다."));
        return new ScheduleResponseDto(schedule);
    }

    @Override
    @Transactional
    public void deleteSchedule(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("해당하는 일정이 없습니다.");
        }
        scheduleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule scheduleToUpdate = scheduleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("해당 일정이 없습니다."));
        scheduleToUpdate.setTitle(requestDto.getTitle());
        scheduleToUpdate.setContent(requestDto.getContent());
        return new ScheduleResponseDto(scheduleToUpdate);
    }
}
