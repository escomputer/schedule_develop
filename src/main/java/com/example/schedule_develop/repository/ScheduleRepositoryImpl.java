package com.example.schedule_develop.repository;

import com.example.schedule_develop.entity.Schedule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

   @PersistenceContext
   private EntityManager entityManager;

    @Override
    public Schedule save(Schedule schedule) {
        if (schedule.getId() == null) {
            entityManager.persist(schedule);  // 새로운 entity를 저장하는 기능
            return schedule;
        } else {
            return entityManager.merge(schedule);
        }
    }

    @Override
    public List<Schedule> findAll() {
        return entityManager.createQuery("select s from Schedule s", Schedule.class).getResultList();
    }

    @Override
    public Schedule findById(Long id){
        return entityManager.find(Schedule.class, id);
    }

    @Override
    public void deleteById(Long id){
        Schedule schedule = entityManager.find(Schedule.class, id);
        if (schedule != null) {
            entityManager.remove(schedule);
        }
    }
}
