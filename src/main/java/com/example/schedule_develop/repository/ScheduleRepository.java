package com.example.schedule_develop.repository;

import com.example.schedule_develop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Schedule save(Schedule schedule) ;

    List<Schedule> findAll();

    Optional<Schedule> findById(Long id);

    void deleteById(Long id);
}
