package com.welltech.ecommerceRestApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello world";
    }
}
