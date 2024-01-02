package com.welltech.ecommerceRestApi.services.serviceImpl;

import com.welltech.ecommerceRestApi.authConfig.JwtTokenProvider;
import com.welltech.ecommerceRestApi.dto.LoginDto;
import com.welltech.ecommerceRestApi.dto.LoginResponse;
import com.welltech.ecommerceRestApi.dto.RegisterUserDto;
import com.welltech.ecommerceRestApi.entity.EasyBuyUser;
import com.welltech.ecommerceRestApi.entity.Role;
import com.welltech.ecommerceRestApi.exception.UserExistException;
import com.welltech.ecommerceRestApi.repository.UserRepository;
import com.welltech.ecommerceRestApi.services.serviceInter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder,
                           AuthenticationManager authenticationManager,JwtTokenProvider jwtTokenProvider
                           ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public ResponseEntity<String> createUser(RegisterUserDto registerUserDto) {
        EasyBuyUser newUser = EasyBuyUser.builder()
                .email(registerUserDto.email())
                .firstName(registerUserDto.firstName())
                .lastName(registerUserDto.lastName())
                .pass(passwordEncoder.encode(registerUserDto.password()))
                .role(Role.valueOf("USER"))
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

    @Override
    public LoginResponse login(LoginDto loginDto) {
        Authentication authentication = null;
        authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(loginDto.email(),loginDto.password()));


        return LoginResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Login successful")
                .token(jwtTokenProvider.generateToken(authentication))
                .build();

    }

}
