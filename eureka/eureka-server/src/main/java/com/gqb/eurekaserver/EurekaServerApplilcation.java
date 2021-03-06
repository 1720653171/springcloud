package com.gqb.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//@EnableEurekaServer 当前服务器为Eureka服务器端
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplilcation {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplilcation.class,args);
    }
}
