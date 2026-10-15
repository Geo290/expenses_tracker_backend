package com.xitcode.expenseTracker.controller;

import com.xitcode.expenseTracker.entity.Category;
import com.xitcode.expenseTracker.service.implementations.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/category")
public class CategoryController {

    private final CategoryServiceImpl service;

    public CategoryController(CategoryServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Category> findAll() {
        return service.findAll();
    }

    @PostMapping("/")
    public Category save(@RequestBody Category category) {
        return service.save(category);
    }
}
