package com.welltech.ecommerceRestApi.repository;

import com.welltech.ecommerceRestApi.entity.EasyBuyUser;
import com.welltech.ecommerceRestApi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByUser(EasyBuyUser easyBuyUser);
}
