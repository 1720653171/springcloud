package com.gqb.sleuth.controller;

import com.gqb.sleuth.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/{id}")
    public Object selectById(@PathVariable("id") Integer id){

        return productService.getProduct();
    }


}
