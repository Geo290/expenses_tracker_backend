package com.xitcode.expenseTracker.dto;

import jakarta.validation.constraints.NotBlank;

public record DtoUser(
        @NotBlank String userName,
        @NotBlank String password
){}
