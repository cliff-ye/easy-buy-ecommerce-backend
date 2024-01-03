package com.welltech.ecommerceRestApi.services.serviceInter;

import com.welltech.ecommerceRestApi.dto.LoggedInUserDto;
import com.welltech.ecommerceRestApi.dto.LoginDto;
import com.welltech.ecommerceRestApi.dto.LoginResponse;
import com.welltech.ecommerceRestApi.dto.RegisterUserDto;
import com.welltech.ecommerceRestApi.entity.EasyBuyUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface UserService {

    ResponseEntity<String> createUser(RegisterUserDto registerUserDto);

    ResponseEntity<LoginResponse> login(LoginDto loginDto);

    ResponseEntity<LoggedInUserDto> getLoggedInUser(EasyBuyUser easyBuyUser);
}
