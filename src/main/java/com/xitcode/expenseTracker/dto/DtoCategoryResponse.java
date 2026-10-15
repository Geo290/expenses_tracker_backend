package com.xitcode.expenseTracker.dto;

import com.xitcode.expenseTracker.enums.CategoryType;

public record DtoCategory(    Long id,
                              CategoryType type) {

}
