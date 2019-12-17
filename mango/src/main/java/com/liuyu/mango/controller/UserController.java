package com.liuyu.mango.controller;

import com.liuyu.mango.model.User;
import com.liuyu.mango.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/15 0015 23:02
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Resource
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }
}
