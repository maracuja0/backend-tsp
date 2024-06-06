package com.project.hackathon.repository;

import com.project.hackathon.entity.CreatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CreatorRepository extends JpaRepository<CreatorEntity, Long> {
    Optional<CreatorEntity> findByEmail(String mailCheck);
//    List<PositionEntity> findPositionsByCreatorId(CreatorEntity creator);
}
