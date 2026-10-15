package com.xitcode.expenseTracker.dto;

import com.xitcode.expenseTracker.enums.CategoryType;

public record DtoCategoryResponse(
    Long id,
    String name,
    CategoryType type
) { }
