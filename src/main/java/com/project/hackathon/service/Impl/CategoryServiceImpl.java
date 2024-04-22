package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.CategoryEntity;
import com.project.hackathon.repository.CategoryRepository;
import com.project.hackathon.repository.PositionRepository;
import com.project.hackathon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PositionRepository positionRepository;

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

//    @Override
//    public List<CategoryEntity> getAllCategoriesByPositionId(Long positionId) {
//        if(!positionRepository.existsById(positionId)){
//            return null;
//        }
//        return categoryRepository.findCategoriesByPositionsId(positionId);
//    }

    @Override
    public void addCategoryByPositionId(Long positionId, CategoryEntity categoryRequest) {
        positionRepository.findById(positionId).ifPresent(position -> {
            Long categoryId = categoryRequest.getId();

            if (categoryId != null && categoryId != 0L) {
                categoryRepository.findById(categoryId).ifPresent(category -> {
                    position.getCategories().add(category);
                    positionRepository.save(position);
                });
            } else {
                position.getCategories().add(categoryRequest);
                positionRepository.save(position);
            }
        });
    }

}
