package com.xitcode.expenseTracker.service.implementations;

import com.xitcode.expenseTracker.repository.UserRepository;
import com.xitcode.expenseTracker.dto.DtoUser;
import com.xitcode.expenseTracker.dto.DtoUserResponse;
import com.xitcode.expenseTracker.entity.Users;
import com.xitcode.expenseTracker.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public DtoUserResponse login(DtoUser dtoUser) {
        // Business logic
        Users user = userRepository.findByUserName(dtoUser.userName())
                .orElseThrow(()-> new BadCredentialsException("User not found"));

        String codePassword = user.getPassword();

        if(!passwordEncoder.matches(dtoUser.password(), codePassword)){
            throw new BadCredentialsException("Bad Credentials");
        }
        return new DtoUserResponse(
                user.getIdUser(),
                user.getUserName(),
                user.getName(),
                user.getLastName()
        );
    }
}
