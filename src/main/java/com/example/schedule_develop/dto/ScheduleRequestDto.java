package com.example.schedule_develop.dto;

import com.example.schedule_develop.entity.Schedule;
import com.example.schedule_develop.entity.User;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String title;
    private String content;
    private Long userId;

    public Schedule toEntity(User user) {
        Schedule schedule = new Schedule();
        schedule.setTitle(this.title);
        schedule.setContent(this.content);
        schedule.setUser(user);
        return schedule;

    }
}
