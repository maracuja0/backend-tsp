package com.project.hackathon.repository;

import com.project.hackathon.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    List<CategoryEntity> findCategoriesByPositionsId(Long positionId);
}
