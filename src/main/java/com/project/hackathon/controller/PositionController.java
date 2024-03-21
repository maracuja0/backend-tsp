package com.project.hackathon.controller;

import com.project.hackathon.entity.PositionEntity;
import com.project.hackathon.service.PositionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping
    public List<PositionEntity> getPosition(){
        return positionService.getPositions();
    }

    @PostMapping
    public Long createPosition(@RequestBody @Valid PositionEntity position){
        return positionService.createPosition(position);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePosition(@PathVariable("id") Long id){
        return positionService.deletePosition(id);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updatePosition(@PathVariable("id") UUID id, @RequestBody @Valid Position position){
//        return positionService.updatePosition(id, position);
//    }
}
