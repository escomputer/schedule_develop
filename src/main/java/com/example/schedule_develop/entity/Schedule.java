package com.example.schedule_develop.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true) //user없이도 저장(일단 lv1에서는)
    private User user;
    private String title;
    private String content;



}
