package com.xitcode.expenseTracker.service.abstracts;

import com.xitcode.expenseTracker.dto.DtoCategoryResponse;
import com.xitcode.expenseTracker.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}
