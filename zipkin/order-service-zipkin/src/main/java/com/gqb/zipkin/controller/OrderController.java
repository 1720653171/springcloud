package com.gqb.zipkin.controller;


import com.gqb.zipkin.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private ProductService productService;

    @GetMapping("/{id}")
    public Object selectOrderById(@PathVariable("id") Integer id){


        return productService.getProduct(id);
    }
}
