package com.gqb.eurekaclient.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class ConsumerController {

    @Resource
    private Registration registration;

    @Resource
    private DiscoveryClient client;//源数据对象，用来获取服务列表

    @Resource
    private RestTemplate restTemplate;


    /**
     * 方式1：通过getForEntity（）方法
     * @return
     */
    @RequestMapping(value = "/getOrderById1", method = RequestMethod.GET)
    public Object index() {

        return restTemplate.getForEntity("http://eureka-client-producer/getOrderById", Object.class).getBody();
    }

    /**
     * 方式2：通过exchange方法
     * @param id
     * @return
     */
    @RequestMapping("/getOrderById2")
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

        //在注入RestTemplate时，加上LoadBalanced注解，则只能通过 应用名称+访问路径来调用服务
        //在注入RestTemplate时，不加上LoadBalanced注解，则只能通过 ip+端口号
        //http://eureka-client-producer/getOrderById   应用名称+访问路径
        ResponseEntity<Map> responseEntity = restTemplate.exchange(address,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map>() {});
        return responseEntity.getBody();
    }


}
