package com.welltech.ecommerceRestApi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quantities")
public class Quantites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;
}
