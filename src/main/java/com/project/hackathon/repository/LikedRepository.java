package com.project.hackathon.repository;

import com.project.hackathon.entity.LikedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikedRepository extends JpaRepository<LikedEntity, Long> {
}
