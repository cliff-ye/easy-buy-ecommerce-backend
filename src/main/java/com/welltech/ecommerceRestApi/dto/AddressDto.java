package com.welltech.ecommerceRestApi.dto;

import lombok.Builder;

@Builder
public record AddressDto(String addressLine1,String addressLine2,String city,String country) {
}
