package com.liuyu.micro.service.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaClient
public class MicroServiceProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceProviderUserApplication.class, args);
    }

}
