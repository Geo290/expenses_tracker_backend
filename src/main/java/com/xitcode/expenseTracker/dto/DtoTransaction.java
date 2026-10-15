package com.xitcode.expenseTracker.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DtoTransaction(
        @NotNull
        @Positive
        @Min(0)
        @Max(900000)
        BigDecimal amount,

        @NotBlank
        String title,
        @NotNull
        @PastOrPresent
        LocalDate date,
        @NotNull
        @Positive
        Long categoryId,
        @NotNull
        @Positive
        Long userId
        ) {
}
