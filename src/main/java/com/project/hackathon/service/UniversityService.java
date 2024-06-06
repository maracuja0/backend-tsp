package com.project.hackathon.service;

import com.project.hackathon.entity.UniversityEntity;

import java.util.List;

public interface UniversityService {
    List<UniversityEntity> getAllUniversities();

    void addUniversity(UniversityEntity university);
}
