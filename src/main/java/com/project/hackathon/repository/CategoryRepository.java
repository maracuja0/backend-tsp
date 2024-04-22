package com.project.hackathon.repository;

import com.project.hackathon.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Set<CategoryEntity> findCategoriesByPositionsId(Long positionId);
}
