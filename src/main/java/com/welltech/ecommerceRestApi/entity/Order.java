package com.welltech.ecommerceRestApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "onlineOrders")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    private EasyBuyUser user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id",nullable = false)
    private Address address;

    @OneToMany(mappedBy = "order",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Quantites> quantites = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EasyBuyUser getUser() {
        return user;
    }

    public void setUser(EasyBuyUser user) {
        this.user = user;
    }


}
