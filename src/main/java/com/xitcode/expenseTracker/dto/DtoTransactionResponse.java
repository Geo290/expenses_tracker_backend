package com.xitcode.expenseTracker.dto;

import com.xitcode.expenseTracker.enums.CategoryType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DtoTransactionResponse (
        Long id,
        BigDecimal amount,
        String title,
        LocalDate date,
        Long categoryId,
        String categoryName,
        CategoryType categoryType
){ }