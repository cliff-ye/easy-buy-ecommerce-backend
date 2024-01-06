package com.welltech.ecommerceRestApi.controller;

import com.welltech.ecommerceRestApi.entity.Product;
import com.welltech.ecommerceRestApi.repository.ProductRepository;
import com.welltech.ecommerceRestApi.services.serviceInter.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductService productService;
    @Autowired
    ProductRepository productRepository;

    public ProductController(ProductService productService){
        this.productService = productService;
    }
//    @GetMapping
//    public List<Product> getAllProducts(){
//        return productService.getAllProducts();
//    }

    @GetMapping
    public Product getAllProduct(){
        return productRepository.findById((long)2).get();
    }
}
