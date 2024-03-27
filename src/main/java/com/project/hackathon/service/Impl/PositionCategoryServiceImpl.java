package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.PositionCategoryEntity;
import com.project.hackathon.repository.PositionCategoryRepositiory;
import com.project.hackathon.service.PositionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionCategoryServiceImpl implements PositionCategoryService {
    @Autowired
    private PositionCategoryRepositiory positionCategoryRepositiory;

    @Override
    public List<PositionCategoryEntity> getAllPositionCategory() {
        return positionCategoryRepositiory.findAll();
    }
}
