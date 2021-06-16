package com.yuki.springbootauthentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class SpringBootAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAuthenticationApplication.class, args);
    }

//    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String s = encoder.encode("snowflake");
//        System.out.println(s);
//
//    }

}
