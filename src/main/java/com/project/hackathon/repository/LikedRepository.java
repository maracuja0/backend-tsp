package com.project.hackathon.repository;

import com.project.hackathon.entity.LikedEntity;
import com.project.hackathon.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikedRepository extends JpaRepository<LikedEntity, Long> {
    List<LikedEntity> findByUserId(UserEntity user);
}
