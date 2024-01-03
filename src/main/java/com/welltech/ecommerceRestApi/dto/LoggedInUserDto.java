package com.welltech.ecommerceRestApi.dto;

import lombok.Builder;

@Builder
public record LoggedInUserDto(String firstName,String lastName,String email) {
}
