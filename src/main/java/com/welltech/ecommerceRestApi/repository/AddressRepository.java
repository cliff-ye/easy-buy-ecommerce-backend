package com.welltech.ecommerceRestApi.repository;

import com.welltech.ecommerceRestApi.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
}
