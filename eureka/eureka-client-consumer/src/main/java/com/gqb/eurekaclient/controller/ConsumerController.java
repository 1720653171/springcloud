package com.gqb.eurekaclient.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private Registration registration;

    @Resource
    private DiscoveryClient client;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/hello", method = RequestMethod.GET)
    public String index() {
        return restTemplate.getForEntity("http://eureka-client-producer/hello", String.class).getBody();
    }
}
