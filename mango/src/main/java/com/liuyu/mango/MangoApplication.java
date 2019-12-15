package com.liuyu.mango;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication(scanBasePackages = {"com.liuyu.mango"})
public class MangoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoApplication.class, args);
    }

}
