package com.welltech.ecommerceRestApi.dto;

import com.welltech.ecommerceRestApi.entity.Address;
import com.welltech.ecommerceRestApi.entity.EasyBuyUser;
import com.welltech.ecommerceRestApi.entity.OrderItem;
import lombok.Builder;

import java.util.List;

@Builder
public record OrderDto(List<OrderItemDto> orderItemDto) {
}
