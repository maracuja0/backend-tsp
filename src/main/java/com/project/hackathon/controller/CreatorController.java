package com.project.hackathon.controller;

import com.project.hackathon.entity.CreatorEntity;
import com.project.hackathon.service.CreatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/creator")
public class CreatorController {
    @Autowired
    private CreatorService creatorService;

    public List<CreatorEntity> getCreator(){
        return creatorService.getCreators();
    }

    @PostMapping("/registation")
    public Long createCreator(@RequestBody @Valid CreatorEntity creator){
        return creatorService.createCreator(creator);
    }


}
