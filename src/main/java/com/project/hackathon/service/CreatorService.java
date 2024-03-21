package com.project.hackathon.service;

import com.project.hackathon.entity.CreatorEntity;

import java.util.List;

public interface CreatorService  {
    List<CreatorEntity> getCreators();

    Long createCreator(CreatorEntity creator);
}
