package com.example.schedule_develop.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Schedule extends Base{
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne@JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String title;
    private String content;



}
