package com.welltech.ecommerceRestApi.services.serviceImpl;

import com.welltech.ecommerceRestApi.entity.Product;
import com.welltech.ecommerceRestApi.repository.ProductRepository;
import com.welltech.ecommerceRestApi.services.serviceInter.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository =productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
