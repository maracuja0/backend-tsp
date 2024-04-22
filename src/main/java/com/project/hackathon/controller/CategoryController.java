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

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryEntity>> getAllCategories(){
        List<CategoryEntity> categories = categoryService.getAllCategories();
        if(categories.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categories);
    }

//    @GetMapping("/positions/{positionId}/categories")
//    public ResponseEntity<List<CategoryEntity>> getAllCategoriesByPositionId(@PathVariable Long positionId){
//        List<CategoryEntity> categories = categoryService.getAllCategoriesByPositionId(positionId);
//        if (!categories.isEmpty()) {
//            return ResponseEntity.ok(categories);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PostMapping("/positions/{positionId}/categories")
    public ResponseEntity<CategoryEntity> addCategory(@PathVariable Long positionId, @RequestBody CategoryEntity categoryRequest){
        categoryService.addCategoryByPositionId(positionId, categoryRequest);
//        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
        return ResponseEntity.ok().build();
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
