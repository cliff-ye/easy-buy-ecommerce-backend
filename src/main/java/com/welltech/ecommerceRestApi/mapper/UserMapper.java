package com.welltech.ecommerceRestApi.mapper;

import com.welltech.ecommerceRestApi.dto.LoggedInUserDto;
import com.welltech.ecommerceRestApi.entity.EasyBuyUser;

public class UserMapper {

    public static LoggedInUserDto mapEntitytoDto(EasyBuyUser easyBuyUser){
        LoggedInUserDto loggedInUserDto = LoggedInUserDto.builder()
                .firstName(easyBuyUser.getFirstName())
                .lastName(easyBuyUser.getLastName())
                .email(easyBuyUser.getEmail())
                .build();

        return loggedInUserDto;
    }
}
