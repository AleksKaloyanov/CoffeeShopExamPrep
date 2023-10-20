package com.example.exprep.service;

import com.example.exprep.model.entity.CategoryEntity;
import com.example.exprep.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
