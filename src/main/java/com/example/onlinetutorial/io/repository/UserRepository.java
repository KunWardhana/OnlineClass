package com.example.onlinetutorial.io.repository;

import com.example.onlinetutorial.io.entity.ClassEntity;
import com.example.onlinetutorial.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserid(String userId);

    List<UserEntity> findAllByClassEntity(ClassEntity classEntity);

}
