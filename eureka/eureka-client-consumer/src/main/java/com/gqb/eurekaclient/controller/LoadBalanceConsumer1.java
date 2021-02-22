package com.gqb.eurekaclient.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

/**
 * 负载均衡有两种方式
 * 该方式在注入RestTemplate类是使用注解@LoadBalanced//负载均衡使用
 *
 *
 */
@RestController
public class LoadBalanceConsumer1 {

    @Resource
    private DiscoveryClient client;//源数据对象，用来获取服务列表

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/loadbalance1/getOrderById2")
    public Object getOrderById(String id){
        //获取服务列表,如果没有服务，则直接返回null，满足健壮性
        List<String> services = client.getServices();
        if(CollectionUtils.isEmpty(services)){
            return null;
        }

        //根据服务名称获取服务
        List<ServiceInstance> instances = client.getInstances("eureka-client-producer");
        if(CollectionUtils.isEmpty(instances)){
            return null;
        }

        ServiceInstance serviceInstance = instances.get(0);
        String address = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"getOrderById";

        //在使用负载均衡策略之后，也就是在使用LoadBalanced注解之后，将不再通过ip+端口号的方式来调用服务，只能够通过 http://eureka-client-producer/getOrderById   应用名称+访问路径
        ResponseEntity<Map> responseEntity = restTemplate.exchange("http://eureka-client-producer/getOrderById",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map>() {});        return responseEntity.getBody();
    }
}
