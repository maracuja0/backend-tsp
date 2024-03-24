package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.LikedEntity;
import com.project.hackathon.repository.LikedRepository;
import com.project.hackathon.service.LikedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikedServiceImpl implements LikedService {

    @Autowired
    private LikedRepository likedRepository;
    @Override
    public List<LikedEntity> getAllLiked() {
        return likedRepository.findAll();
    }

    @Override
    public Long createLiked(LikedEntity liked) {
        return likedRepository.save(liked).getId();
    }

    @Override
    public ResponseEntity<String> deleteLiked(Long id) {
        likedRepository.deleteById(id);
        return ResponseEntity.ok("Delete was success");
    }
}
