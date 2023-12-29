package com.welltech.ecommerceRestApi.repository;

import com.welltech.ecommerceRestApi.entity.EasyBuyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<EasyBuyUser,Long> {

    public boolean existsByEmail(String email);
}
