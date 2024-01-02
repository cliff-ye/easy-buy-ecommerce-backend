package com.welltech.ecommerceRestApi.repository;

import com.welltech.ecommerceRestApi.entity.EasyBuyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<EasyBuyUser,Long> {

    public boolean existsByEmail(String email);

    Optional<EasyBuyUser> findByEmail(String email);
}
