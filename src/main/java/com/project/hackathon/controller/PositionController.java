package com.project.hackathon.controller;

import com.project.hackathon.entity.PositionEntity;
import com.project.hackathon.service.PositionService;
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

    @PostMapping("/create")
    public ResponseEntity<PositionEntity> createPosition(@RequestBody PositionEntity positionRequest) {

//        // Преобразуйте positionRequest в объект PositionEntity
//        PositionEntity newPosition = new PositionEntity();
//        newPosition.setName(positionRequest.getName());
//        // Заполните остальные поля должности
//
//        // Получите категорию из запроса или другим способом
//        CategoryEntity categoryToAdd = categoryRepository.findById(positionRequest.getCategoryId())
//                .orElseThrow(() -> new IllegalArgumentException("Категория не найдена"));
//
//        newPosition.addCategory(categoryToAdd);
//
//        Long newPositionId = positionService.createPosition(newPosition);

        PositionEntity newPosition = positionService.createPosition(positionRequest);
//        if(newPosition.)
        return ResponseEntity.ok(newPosition);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePosition(@PathVariable("id") Long id){
        return positionService.deletePosition(id);
    }
}
