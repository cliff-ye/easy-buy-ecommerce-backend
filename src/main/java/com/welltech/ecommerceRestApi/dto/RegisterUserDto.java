package com.welltech.ecommerceRestApi.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;

@Builder
public record RegisterUserDto(
         @Email @NotNull @NotBlank String email,
         @NotNull @NotBlank @Size(min = 6, max = 32)String password,
         @NotNull @NotBlank @Size(min = 2,max = 255) String firstName,
         @NotNull @NotBlank @Size(min = 2,max = 255) String lastName) {

}
