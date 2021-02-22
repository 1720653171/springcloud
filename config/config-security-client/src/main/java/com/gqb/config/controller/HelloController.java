package com.gqb.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {

    @Value("${name}")
    private String name;

    @RequestMapping("/name")
    public String getPort(){
        return name;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }


}
