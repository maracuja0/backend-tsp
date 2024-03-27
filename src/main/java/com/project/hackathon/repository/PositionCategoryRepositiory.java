package com.project.hackathon.repository;

import com.project.hackathon.entity.PositionCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionCategoryRepositiory extends JpaRepository<PositionCategoryEntity, Long> {
}
