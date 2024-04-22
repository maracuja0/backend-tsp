package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.CreatorEntity;
import com.project.hackathon.entity.PositionEntity;
import com.project.hackathon.repository.CreatorRepository;
import com.project.hackathon.repository.PositionRepository;
import com.project.hackathon.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreatorServiceImpl implements CreatorService {
    @Autowired
    private CreatorRepository creatorRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<CreatorEntity> getCreators() {
        return creatorRepository.findAll();
    }

    @Override
    public Long createCreator(CreatorEntity creator) {
        return creatorRepository.save(creator).getId();
    }

    @Override
    public Optional<CreatorEntity> getCreatorById(Long creatorId) {
        return creatorRepository.findById(creatorId);
    }

    @Override
    public List<PositionEntity> getPositionsByCreator(CreatorEntity creator) {
        return positionRepository.findPositionsByCreatorId(creator);
    }


}
