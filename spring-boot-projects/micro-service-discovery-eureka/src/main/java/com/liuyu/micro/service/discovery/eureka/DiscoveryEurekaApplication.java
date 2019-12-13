package com.liuyu.micro.service.discovery.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Administrator
 * Eureka 服务端
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryEurekaApplication.class, args);
    }

}
