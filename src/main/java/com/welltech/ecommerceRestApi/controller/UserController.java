package com.welltech.ecommerceRestApi.controller;

import com.welltech.ecommerceRestApi.dto.RegisterUserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @PostMapping
    public void registerUser(@RequestBody RegisterUserDto registerUserDto){

    }
}
