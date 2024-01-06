package com.welltech.ecommerceRestApi.services.serviceImpl;

import com.welltech.ecommerceRestApi.dto.LoggedInUserDto;
import com.welltech.ecommerceRestApi.dto.OrderDto;
import com.welltech.ecommerceRestApi.entity.*;
import com.welltech.ecommerceRestApi.mapper.UserMapper;
import com.welltech.ecommerceRestApi.repository.OrderRepository;
import com.welltech.ecommerceRestApi.repository.ProductRepository;
import com.welltech.ecommerceRestApi.services.serviceInter.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

   private OrderRepository orderRepository;
   private ProductRepository productRepository;

   @Autowired
   public OrderServiceImpl(OrderRepository orderRepository,ProductRepository productRepository){
       this.orderRepository =orderRepository;
       this.productRepository = productRepository;
   }

    @Override
    public List<Order> getAllOrders(EasyBuyUser easyBuyUser) {
        return orderRepository.findByUser(easyBuyUser);
    }

    @Override
    public ResponseEntity<String> createOrder(OrderDto orderDto, EasyBuyUser easyBuyUser) {


        List<OrderItem> orderItems = orderDto.orderItemDto().stream()
                                                                   .map(orderItemDto -> OrderItem.builder()
                                                                    .product(productRepository.findById(orderItemDto.prod_id()).get())
                                                                    .quantity(orderItemDto.quantity())
                                                                    .unitPrice(orderItemDto.unitPrice())
                                                                    .build())
                                                            .collect(Collectors.toList());


       Order newOrder = Order.builder()
               .user(easyBuyUser)
               .address(easyBuyUser.getAddresses().stream().collect(Collectors.toList()).get(0))
               .orderItems(orderItems)
               .build();

       orderItems.forEach(orderItem -> orderItem.setOrder(newOrder));

       orderRepository.save(newOrder);

        return ResponseEntity.status(HttpStatus.CREATED).body("Ordered successfully");
    }
}
