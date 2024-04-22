package com.project.hackathon.controller;

import com.project.hackathon.entity.CreatorEntity;
import com.project.hackathon.entity.PositionEntity;
import com.project.hackathon.service.CreatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/creator")
public class CreatorController {
    @Autowired
    private CreatorService creatorService;

    public List<CreatorEntity> getCreator(){
        return creatorService.getCreators();
    }

    @GetMapping("/{creatorId}/positions")
    public ResponseEntity<List<PositionEntity>> getPositionsByCreatorId(@PathVariable Long creatorId){
        Optional<CreatorEntity> creatorOptional = creatorService.getCreatorById(creatorId);

        if(creatorOptional.isPresent()){
            CreatorEntity creator = creatorOptional.get();
            List<PositionEntity> positions = creatorService.getPositionsByCreator(creator);
            return ResponseEntity.ok(positions);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/{creatorId}/")
    @PostMapping("/registration")
    public Long createCreator(@RequestBody @Valid CreatorEntity creator){
        return creatorService.createCreator(creator);
    }


}
