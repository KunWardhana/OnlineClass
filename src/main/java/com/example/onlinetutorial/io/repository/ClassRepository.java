package com.example.onlinetutorial.io.repository;

import com.example.onlinetutorial.io.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    ClassEntity findByClassid(String classid);
}
