package com.example.schedule_develop.repository;

import com.example.schedule_develop.entity.Schedule;

import java.util.List;
import java.util.Optional;


public interface ScheduleRepository {
    Schedule save(Schedule schedule) ;

    List<Schedule> findAll();

    Optional<Schedule> findById(Long id);

    void deleteById(Long id);
}
