package com.example.schedule_develop.repository;

import com.example.schedule_develop.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll(){
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public Optional<User> findById(Long id){
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public User save(User user) {
        if(user.getId() == null){
            entityManager.persist(user);
            return user;
        }else return entityManager.merge(user);
    }

    @Override
    public void deleteById(Long id){
        User user = entityManager.find(User.class, id);
        if (user !=null) entityManager.remove(user);
    }
}
