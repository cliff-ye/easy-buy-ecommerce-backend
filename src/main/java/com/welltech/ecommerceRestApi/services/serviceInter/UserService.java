package com.welltech.ecommerceRestApi.services.serviceInter;

import com.welltech.ecommerceRestApi.dto.RegisterUserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


public interface UserService {

    ResponseEntity<String> createUser(RegisterUserDto registerUserDto);
}
