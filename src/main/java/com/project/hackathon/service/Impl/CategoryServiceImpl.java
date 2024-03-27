package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.CategoryEntity;
import com.project.hackathon.repository.CategoryRepository;
import com.project.hackathon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Long createCategory(CategoryEntity category) {
        return categoryRepository.save(category).getId();
    }

    @Override
    public ResponseEntity<String> deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.ok("Delete was success");
    }
}
