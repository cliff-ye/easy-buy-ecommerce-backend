package com.welltech.ecommerceRestApi.services.serviceInter;

import com.welltech.ecommerceRestApi.dto.LoggedInUserDto;
import com.welltech.ecommerceRestApi.entity.EasyBuyUser;
import com.welltech.ecommerceRestApi.entity.Order;

import java.util.List;

public interface OrderService {

   public List<Order> getAllOrders(EasyBuyUser easyBuyUser);
}
