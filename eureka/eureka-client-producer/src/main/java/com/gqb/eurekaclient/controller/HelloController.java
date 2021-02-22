package com.gqb.eurekaclient.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Resource
    private Registration registration;

    @Resource
    private DiscoveryClient client;


    @RequestMapping("/getOrderById")
    public Object getOrderById(String id){
        Map<String,String> result = new HashMap<>();
        result.put("id",id);
        result.put("name","学习资料");
        result.put("price","30");
        result.put("number","1");
        return result;
    }
}