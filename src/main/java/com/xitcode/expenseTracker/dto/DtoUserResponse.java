package com.xitcode.expenseTracker.dto;

public record DtoUserResponse(
    Long id, 
    String userName, 
    String name, 
    String lastName
) {}
