package com.example.onlinetutorial.io.repository;

import com.example.onlinetutorial.io.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Long> {
    MaterialEntity findByMaterialid(String materialid);
}
