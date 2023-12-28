package com.welltech.ecommerceRestApi.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Profile;

@Entity
@Table(name="inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(orphanRemoval = true,optional = false)
    @JoinColumn(name = "product_id",unique = true,nullable = false)
    private Product product;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
