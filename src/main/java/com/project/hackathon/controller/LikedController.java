package com.project.hackathon.controller;

import com.project.hackathon.entity.LikedEntity;
import com.project.hackathon.service.LikedService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/liked")
public class LikedController {
    @Autowired
    private LikedService likedService;

    @GetMapping
    public List<LikedEntity> getAllLiked(){
        return likedService.getAllLiked();
    }

    @PostMapping
    public Long createLiked(@RequestBody @Valid LikedEntity liked){
        return likedService.createLiked(liked);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLiked(@PathVariable("id") Long id){
        return likedService.deleteLiked(id);
    }

}
