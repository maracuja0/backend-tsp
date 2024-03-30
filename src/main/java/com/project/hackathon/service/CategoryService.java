package com.project.hackathon.service;

import com.project.hackathon.entity.CategoryEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAllCategories();

    Long createCategory(CategoryEntity category);

    ResponseEntity<String> deleteCategory(Long id);

    List<CategoryEntity> getAllCategoriesByPositionId(Long positionId);
}
