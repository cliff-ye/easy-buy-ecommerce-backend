package com.welltech.ecommerceRestApi.services.serviceImpl;

import com.welltech.ecommerceRestApi.dto.RegisterUserDto;
import com.welltech.ecommerceRestApi.entity.EasyBuyUser;
import com.welltech.ecommerceRestApi.exception.UserExistException;
import com.welltech.ecommerceRestApi.repository.UserRepository;
import com.welltech.ecommerceRestApi.services.serviceInter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> createUser(RegisterUserDto registerUserDto) {
        EasyBuyUser newUser = EasyBuyUser.builder()
                .email(registerUserDto.email())
                .firstName(registerUserDto.firstName())
                .lastName(registerUserDto.lastName())
                .username(registerUserDto.username())
                // TODO: Password needs to be encrypted
                .password(registerUserDto.password())
                .build();

        /**
         * check if user has an account already
         */
        if(userRepository.existsByEmail(registerUserDto.email())){
            throw new UserExistException("User already has an account");
        }

        userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body("Registered successfully");
    }
}
