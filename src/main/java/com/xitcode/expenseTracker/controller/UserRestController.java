package com.xitcode.expenseTracker.controller;

import com.xitcode.expenseTracker.dto.DtoUser;
import com.xitcode.expenseTracker.dto.DtoUserResponse;
import com.xitcode.expenseTracker.service.abstracts.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public DtoUserResponse login(@Valid @RequestBody DtoUser dtoUser){
//        System.out.println(dtoUser);
        return userService.login(dtoUser);
    }
}
