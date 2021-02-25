package com.gqb.sleuth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "product-service")
public interface ProductService {

    @GetMapping("/product/{id}")
    public Object getProduct(@PathVariable("id") Integer id);
}
