package com.gqb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SecurityConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityConfigServerApplication.class,args);
    }
}
