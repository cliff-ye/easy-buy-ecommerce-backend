package com.welltech.ecommerceRestApi.controller;

import com.welltech.ecommerceRestApi.dto.RegisterUserDto;
import com.welltech.ecommerceRestApi.services.serviceInter.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
