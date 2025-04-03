package com.example.schedule_develop.service;

import com.example.schedule_develop.entity.Schedule;
import com.example.schedule_develop.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Override
    @Transactional
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule); //entity 바로 저장
    }

    @Override
    public List<Schedule> getSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }
}
