package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.PositionEntity;
import com.project.hackathon.repository.PositionRepository;
import com.project.hackathon.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<PositionEntity> getPositions() {
        return positionRepository.findAll();
    }

    @Override
    public Long createPosition(PositionEntity position) {
        return positionRepository.save(position).getId();
    }

    @Override
    public ResponseEntity<String> deletePosition(Long id) {
        positionRepository.deleteById(id);
        return ResponseEntity.ok("Delete was success");
    }

    @Override
    public Optional<PositionEntity> getPositionById(Long id) {
        return positionRepository.findById(id);
    }
}
