package com.project.hackathon.controller;

import com.project.hackathon.entity.PositionEntity;
import com.project.hackathon.service.PositionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping
    public List<PositionEntity> getPosition(){
        return positionService.getPositions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PositionEntity> getPositionById(@PathVariable Long id){
        Optional<PositionEntity> positionOptional = positionService.getPositionById(id);
        if (positionOptional.isPresent()) {
            PositionEntity position = positionOptional.get();
            return ResponseEntity.ok(position);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Long createPosition(@RequestBody @Valid PositionEntity position){
        return positionService.createPosition(position);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePosition(@PathVariable("id") Long id){
        return positionService.deletePosition(id);
    }
}
