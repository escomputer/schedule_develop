package com.example.schedule_develop.dto;

import com.example.schedule_develop.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String content;
    private String userName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ScheduleResponseDto(Schedule schedule) {
        this.id =schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.userName= schedule.getUser().getName(); //User엔티티에 접근!
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }

}
