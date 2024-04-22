package com.project.hackathon.service.Impl;

import com.project.hackathon.entity.PositionEntity;
import com.project.hackathon.repository.CategoryRepository;
import com.project.hackathon.repository.PositionRepository;
import com.project.hackathon.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<PositionEntity> getPositions() {
        List<PositionEntity> positionList = positionRepository.findAll();
        System.out.println("POSITION LIST");
        System.out.println(positionList);
//        for(PositionEntity position : positionList){
//            position.setCategories(categoryRepository.findCategoriesByPositionsId(position.getId()));
//        }
        return positionList;
    }

    @Override
    public PositionEntity createPosition(PositionEntity positionRequest) {
//        return positionRepository.save(position).getId();
//        PositionEntity newPosition = new PositionEntity();
//        newPosition = positionRepository.save(positionRequest);


//        Set<CategoryEntity> categoryToAdd = newPosition.getCategories();

//        for(CategoryEntity category : categoryToAdd){
//            newPosition.addCategory(category);
//        }
//                categoryRepository.findById(newPosition.getCategories())
//                .orElseThrow(() -> new IllegalArgumentException("Категория не найдена"));

//        position.addCategory(categoryToAdd);

        return positionRepository.save(positionRequest);
    }

    @Override
    public ResponseEntity<String> deletePosition(Long id) {
        positionRepository.deleteById(id);
        return ResponseEntity.ok("Delete was success");
    }

    @Override
    public Optional<PositionEntity> getPositionById(Long id) {
        return positionRepository.findById(id);
    }
}
