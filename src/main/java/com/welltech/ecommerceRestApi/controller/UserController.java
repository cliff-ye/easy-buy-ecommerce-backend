package com.welltech.ecommerceRestApi.controller;

import com.welltech.ecommerceRestApi.dto.LoggedInUserDto;
import com.welltech.ecommerceRestApi.dto.LoginDto;
import com.welltech.ecommerceRestApi.dto.LoginResponse;
import com.welltech.ecommerceRestApi.dto.RegisterUserDto;
import com.welltech.ecommerceRestApi.entity.EasyBuyUser;
import com.welltech.ecommerceRestApi.mapper.UserMapper;
import com.welltech.ecommerceRestApi.services.serviceInter.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterUserDto registerUserDto){
        return userService.createUser(registerUserDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

    @GetMapping
    public ResponseEntity<LoggedInUserDto> getLoggedInUser(@AuthenticationPrincipal EasyBuyUser easyBuyUser){
        return userService.getLoggedInUser(easyBuyUser);
    }
}
