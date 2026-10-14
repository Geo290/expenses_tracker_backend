package com.xitcode.expenseTracker.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DtoTransactionResponse (
        BigDecimal amount,
        String title,
        LocalDate date,
        Long categoryId
){ }