package com.project.hackathon.repository;

import com.project.hackathon.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<PositionEntity, Long> {
    List<PositionEntity> findPositionsByCategoriesId(Long categoryId);
}
