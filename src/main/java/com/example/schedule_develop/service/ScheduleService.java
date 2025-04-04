package com.example.schedule_develop.service;

import com.example.schedule_develop.dto.ScheduleRequestDto;
import com.example.schedule_develop.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto);

    List<ScheduleResponseDto> getSchedules();

    ScheduleResponseDto getScheduleById(Long id);

    void deleteSchedule(Long id);

    ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto schedule);
}
