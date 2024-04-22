package com.project.hackathon.repository;

import com.project.hackathon.entity.CreatorEntity;
import com.project.hackathon.entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PositionRepository extends JpaRepository<PositionEntity, Long> {
    List<PositionEntity> findPositionsByCategoriesId(Long categoryId);

    List<PositionEntity> findPositionsByCreatorId(CreatorEntity creator);
    @Query("SELECT DISTINCT p FROM PositionEntity p LEFT JOIN FETCH p.categories")
    List<PositionEntity> findAllWithCategories();
}
