package com.project.hackathon.controller;

import com.project.hackathon.entity.UniversityEntity;
import com.project.hackathon.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/university")
public class UniversityController {
    @Autowired
    private UniversityService universityService;

    @GetMapping
    public List<UniversityEntity> getAllUniversities(){
        return universityService.getAllUniversities();

    }
}
