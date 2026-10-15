package com.xitcode.expenseTracker.service.abstracts;

import com.xitcode.expenseTracker.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
}
