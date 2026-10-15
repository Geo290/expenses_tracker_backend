package com.xitcode.expenseTracker.service.implementations;

import com.xitcode.expenseTracker.dto.DtoCategoryResponse;
import com.xitcode.expenseTracker.entity.Category;
import com.xitcode.expenseTracker.repository.CategoryRepository;
import com.xitcode.expenseTracker.service.abstracts.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }
}
