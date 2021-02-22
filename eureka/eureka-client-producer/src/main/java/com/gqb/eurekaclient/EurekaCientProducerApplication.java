package com.gqb.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaCientProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaCientProducerApplication.class,args);
    }
}
