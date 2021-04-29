package com.example.onlinetutorial.io.repository;

import com.example.onlinetutorial.io.entity.ClassEntity;
import com.example.onlinetutorial.io.entity.Header_MaterialEntity;
import com.example.onlinetutorial.io.entity.MaterialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Header_MaterialRepository extends JpaRepository<Header_MaterialEntity, Long> {
    Header_MaterialEntity findByClasscol(ClassEntity classid);

    Header_MaterialEntity findByMaterialEntity(String materialid);

    Header_MaterialEntity findByClasscolAndAndMaterialEntity(ClassEntity classid, MaterialEntity materialid);
}
