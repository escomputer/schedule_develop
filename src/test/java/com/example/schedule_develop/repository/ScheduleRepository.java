package com.example.schedule_develop.repository;

import com.example.schedule_develop.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {
    Schedule save(Schedule schedule) ;

    List<Schedule> findAll();
}
