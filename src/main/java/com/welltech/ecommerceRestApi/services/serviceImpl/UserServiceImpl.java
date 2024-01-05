package com.welltech.ecommerceRestApi.services.serviceImpl;

import com.welltech.ecommerceRestApi.authConfig.JwtTokenProvider;
import com.welltech.ecommerceRestApi.dto.*;
import com.welltech.ecommerceRestApi.entity.Address;
import com.welltech.ecommerceRestApi.entity.EasyBuyUser;
import com.welltech.ecommerceRestApi.entity.Role;
import com.welltech.ecommerceRestApi.exception.UserExistException;
import com.welltech.ecommerceRestApi.mapper.UserMapper;
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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        /**
         * check if user has an account already
         */
        if(userRepository.existsByEmail(registerUserDto.email())){
            throw new UserExistException("User already has an account");
        }


        List<Address> addresses = registerUserDto.addressDto().stream()
                                                                    .map(addressDto -> Address.builder()
                                                                            .addressLine1(addressDto.addressLine1())
                                                                            .addressLine2(addressDto.addressLine2())
                                                                            .city(addressDto.city())
                                                                            .country(addressDto.country())
                                                                            .build())
                                                                            .collect(Collectors.toList());

        EasyBuyUser newUser = EasyBuyUser.builder()
                .email(registerUserDto.email())
                .firstName(registerUserDto.firstName())
                .lastName(registerUserDto.lastName())
                .pass(passwordEncoder.encode(registerUserDto.password()))
                .role(Role.valueOf("USER"))
                .addresses(addresses)
                .build();


        /**
         * assign user id or reference to each address
         */
      addresses.forEach(address -> address.setUser(newUser));


        userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body("Registered successfully");
    }

    @Override
    public ResponseEntity<LoginResponse> login(LoginDto loginDto) {
        Authentication authentication = null;
        authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(loginDto.email(),loginDto.password()));

        LoginResponse response = LoginResponse.builder()
                .status(HttpStatus.OK.value())
                .message("Login successful")
                .token(jwtTokenProvider.generateToken(authentication))
                .build();

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<LoggedInUserDto> getLoggedInUser(EasyBuyUser easyBuyUser) {

        LoggedInUserDto mappedDto = UserMapper.mapEntitytoDto(easyBuyUser);

        return ResponseEntity.ok(mappedDto);
    }

//    @Override
//    public ResponseEntity<List<AddressDto>> getLoggedInUserAddresses(EasyBuyUser easyBuyUser) {
//
//        List<AddressDto> mappedDto = UserMapper.mapEntitytoDto(easyBuyUser);
//
//        return ResponseEntity.ok(mappedDto);
//    }

}
