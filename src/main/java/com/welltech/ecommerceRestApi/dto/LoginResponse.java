package com.welltech.ecommerceRestApi.dto;

import lombok.Builder;

@Builder
public record LoginResponse(int status,String message,String token) {
}
