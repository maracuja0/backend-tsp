package com.project.hackathon.controller;

import com.project.hackathon.entity.CategoryEntity;
import com.project.hackathon.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<CategoryEntity> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/positions/{positionId}/categories")
    public ResponseEntity<List<CategoryEntity>> getAllCategoriesByPositionId(@PathVariable Long positionId){
        List<CategoryEntity> categories = categoryService.getAllCategoriesByPositionId(positionId);
        if (!categories.isEmpty()) {
            return ResponseEntity.ok(categories);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/category")
    public Long createCategory(@RequestBody @Valid CategoryEntity category){
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id){
        return categoryService.deleteCategory(id);
    }
}
