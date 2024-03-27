package com.project.hackathon.controller;

import com.project.hackathon.entity.CategoryEntity;
import com.project.hackathon.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryEntity> getAllCatgories(){
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Long createCategory(@RequestBody @Valid CategoryEntity category){
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id){
        return categoryService.deleteCategory(id);
    }
}
