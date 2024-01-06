package com.welltech.ecommerceRestApi.dto;

import com.welltech.ecommerceRestApi.entity.Order;
import com.welltech.ecommerceRestApi.entity.Product;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderItemDto(long prod_id, int quantity, BigDecimal unitPrice) {
}
