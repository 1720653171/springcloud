package com.gqb.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ClusterEurekaApplication1 {
    public static void main(String[] args) {
        SpringApplication.run(ClusterEurekaApplication1.class,args);
    }
}
