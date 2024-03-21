package com.project.hackathon.service;

import com.project.hackathon.entity.PositionEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PositionService  {
    List<PositionEntity> getPositions();

    Long createPosition(PositionEntity position);

    ResponseEntity<String> deletePosition(Long id);
}