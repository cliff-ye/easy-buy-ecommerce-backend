package com.welltech.ecommerceRestApi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Entity
@Table(name = "address")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    /**
     * the primary street address or delivery location
     * contains : street name, house number
     */
    @Column(nullable = false,length = 512)
    private String addressLine1;

    /**
     * used for additional information like apartment numbers or
     * other details that can help in identifying the exact location of the address
     */
    @Column(length = 512)
    private String addressLine2;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String country;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    private EasyBuyUser user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
