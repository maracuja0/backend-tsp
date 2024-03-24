package com.project.hackathon.service;

import com.project.hackathon.entity.LikedEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LikedService {
    List<LikedEntity> getAllLiked();

    Long createLiked(LikedEntity liked);

    ResponseEntity<String> deleteLiked(Long id);
}
