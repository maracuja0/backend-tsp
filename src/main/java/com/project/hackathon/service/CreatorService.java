package com.project.hackathon.service;

import com.project.hackathon.entity.CreatorEntity;
import com.project.hackathon.entity.PositionEntity;

import java.util.List;
import java.util.Optional;

public interface CreatorService  {
    List<CreatorEntity> getCreators();

    Long createCreator(CreatorEntity creator);

    Optional<CreatorEntity> getCreatorById(Long creatorId);

    List<PositionEntity> getPositionsByCreator(CreatorEntity creator);
}
