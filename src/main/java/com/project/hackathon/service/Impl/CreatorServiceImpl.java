package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.CreatorEntity;
import com.project.hackathon.repository.CreatorRepository;
import com.project.hackathon.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorServiceImpl implements CreatorService {
    @Autowired
    private CreatorRepository creatorRepository;
    @Override
    public List<CreatorEntity> getCreators() {
        return creatorRepository.findAll();
    }

    @Override
    public Long createCreator(CreatorEntity creator) {
        return creatorRepository.save(creator).getId();
    }


}
