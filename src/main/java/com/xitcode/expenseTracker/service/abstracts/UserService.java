package com.xitcode.expenseTracker.service.abstracts;

import com.xitcode.expenseTracker.dto.DtoUser;
import com.xitcode.expenseTracker.dto.DtoUserResponse;

public interface UserService {
    DtoUserResponse login(DtoUser dtoUser);
}
