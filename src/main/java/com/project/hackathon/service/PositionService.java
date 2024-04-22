package com.project.hackathon.service;

import com.project.hackathon.entity.PositionEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PositionService  {
    List<PositionEntity> getPositions();

    PositionEntity createPosition(PositionEntity positionRequest);

    ResponseEntity<String> deletePosition(Long id);

    Optional<PositionEntity> getPositionById(Long id);
}
