package com.liuyu.micro.service.consumer.movie.controller;

import com.liuyu.micro.service.consumer.movie.bo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author： yu Liu
 * @date： 2019/12/13 0013 14:58
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
public class MovieController {

    private final RestTemplate restTemplate;

    public MovieController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://localhost/user/" + id, User.class);
    }

}
