package com.xitcode.expenseTracker.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DtoUpdateTransaction(
		@NotBlank @Min(0) @Max(900000) BigDecimal amount,

		String title,
		@NotBlank LocalDate date,
		@NotBlank Long categoryId
) {}
