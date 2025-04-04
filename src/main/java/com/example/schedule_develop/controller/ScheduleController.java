package com.example.schedule_develop.controller;

import com.example.schedule_develop.dto.ScheduleRequestDto;
import com.example.schedule_develop.dto.ScheduleResponseDto;
import com.example.schedule_develop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.createSchedule(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getSchedules() {
        return ResponseEntity.ok(scheduleService.getSchedules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getScheduleById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id,requestDto));
    }



}