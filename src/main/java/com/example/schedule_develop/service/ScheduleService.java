package com.example.schedule_develop.service;

import com.example.schedule_develop.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    Schedule createSchedule(Schedule schedule);

    List<Schedule> getSchedules();

    Schedule getScheduleById(Long id);

    void deleteSchedule(Long id);

    Schedule updateSchedule(Long id, Schedule schedule);
}
