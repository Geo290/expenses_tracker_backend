package com.xitcode.expenseTracker.service.implementations;

import com.xitcode.expenseTracker.entity.Category;
import com.xitcode.expenseTracker.repository.CategoryRepository;
import com.xitcode.expenseTracker.service.abstracts.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }
}
