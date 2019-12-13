package com.liuyu.micro.service.provider.user.controller;

import com.liuyu.micro.service.provider.user.bo.User;
import com.liuyu.micro.service.provider.user.dao.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author： yu Liu
 * @date： 2019/12/13 0013 13:55
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserJpa userJpa;

    @GetMapping("/user/{id}")
    public  User findById(@PathVariable Long id) {
        Optional<User> user = userJpa.findById(id);
        return user.orElse(null);
    }
}
