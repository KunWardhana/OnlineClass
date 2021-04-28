package com.example.onlinetutorial.io.repository;

import com.example.onlinetutorial.io.entity.ClassEntity;
import com.example.onlinetutorial.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    ClassEntity findByClassid(String classid);
}
