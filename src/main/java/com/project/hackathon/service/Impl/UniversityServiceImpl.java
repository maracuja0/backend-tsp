package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.UniversityEntity;
import com.project.hackathon.repository.UniversityRepository;
import com.project.hackathon.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;
    @Override
    public List<UniversityEntity> getAllUniversities() {
        return universityRepository.findAll();
    }
}
