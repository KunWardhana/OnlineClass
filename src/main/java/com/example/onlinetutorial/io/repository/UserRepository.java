package com.example.onlinetutorial.io.repository;

import com.example.onlinetutorial.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserid(String userId);

}
