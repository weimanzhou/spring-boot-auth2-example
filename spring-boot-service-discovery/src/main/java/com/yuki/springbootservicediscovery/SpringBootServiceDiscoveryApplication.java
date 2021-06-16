package com.yuki.springbootservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringBootServiceDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootServiceDiscoveryApplication.class, args);
    }

}
