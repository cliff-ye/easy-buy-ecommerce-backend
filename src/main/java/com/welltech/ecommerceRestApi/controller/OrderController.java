package com.welltech.ecommerceRestApi.controller;

import com.welltech.ecommerceRestApi.entity.EasyBuyUser;
import com.welltech.ecommerceRestApi.entity.Order;
import com.welltech.ecommerceRestApi.services.serviceInter.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderServic){
        this.orderService =orderService;
    }

    @GetMapping
    public List<Order> getOrders(@AuthenticationPrincipal EasyBuyUser easyBuyUser){
        return orderService.getAllOrders(easyBuyUser);
    }


}
