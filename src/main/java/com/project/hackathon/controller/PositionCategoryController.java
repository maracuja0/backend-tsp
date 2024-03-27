package com.project.hackathon.controller;

import com.project.hackathon.entity.PositionCategoryEntity;
import com.project.hackathon.service.PositionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path ="/api/position-category")
public class PositionCategoryController {
    @Autowired
    private PositionCategoryService positionCategoryService;

    @GetMapping
    public List<PositionCategoryEntity> getAllPositionCategory(){
        return positionCategoryService.getAllPositionCategory();
    }
}
