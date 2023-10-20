package com.example.exprep.service.impl;

import com.example.exprep.model.entity.CategoryEntity;
import com.example.exprep.model.entity.enums.CategoryNameEnum;
import com.example.exprep.repository.CategoryRepository;
import com.example.exprep.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(category -> {
                    CategoryEntity categoryEntity = new CategoryEntity();
                    categoryEntity.setName(category);
                    switch (category) {
                        case CAKE -> categoryEntity.setNeededTime(10);
                        case DRINK -> categoryEntity.setNeededTime(1);
                        case COFFEE -> categoryEntity.setNeededTime(2);
                        case OTHER -> categoryEntity.setNeededTime(5);
                    }

                    categoryRepository.save(categoryEntity);
                });
    }

    @Override
    public CategoryEntity findByCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        return categoryRepository
                .findByName(categoryNameEnum)
                .orElse(null);
    }
}
