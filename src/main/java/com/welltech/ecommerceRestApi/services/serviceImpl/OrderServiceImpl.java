package com.welltech.ecommerceRestApi.services.serviceImpl;

import com.welltech.ecommerceRestApi.dto.LoggedInUserDto;
import com.welltech.ecommerceRestApi.entity.EasyBuyUser;
import com.welltech.ecommerceRestApi.entity.Order;
import com.welltech.ecommerceRestApi.mapper.UserMapper;
import com.welltech.ecommerceRestApi.repository.OrderRepository;
import com.welltech.ecommerceRestApi.services.serviceInter.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

   private OrderRepository orderRepository;

   @Autowired
   public OrderServiceImpl(OrderRepository orderRepository){
       this.orderRepository =orderRepository;
   }

    @Override
    public List<Order> getAllOrders(EasyBuyUser easyBuyUser) {
        return orderRepository.findByUser(easyBuyUser);
    }
}
