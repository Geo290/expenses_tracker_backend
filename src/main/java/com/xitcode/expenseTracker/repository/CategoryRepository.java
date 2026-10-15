package com.xitcode.expenseTracker.dao;

import com.xitcode.expenseTracker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
