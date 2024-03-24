package com.project.hackathon.repository;

import com.project.hackathon.entity.CreatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CreatorRepository extends JpaRepository<CreatorEntity, Long> {
}
