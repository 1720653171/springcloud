package com.gqb.eurekaclient.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class LoadBalanceConsumer2 {

    @Resource
    private LoadBalancerClient client;//源数据对象，用来获取服务列表

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/loadbalance2/getOrderById2")
    public Object getOrderById(String id){


        ServiceInstance serviceInstance = client.choose("eureka-client-producer");
        String address = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"getOrderById";

        //在使用负载均衡策略之后，将不再通过ip+端口号的方式来调用服务，只能够通过 http://eureka-client-producer/getOrderById   应用名称+访问路径
        ResponseEntity<Map> responseEntity = restTemplate.exchange("http://eureka-client-producer/getOrderById",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map>() {});
        return responseEntity.getBody();
    }
}
