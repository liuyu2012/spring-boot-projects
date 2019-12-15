package com.liuyu.mango.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： yu Liu
 * @date： 2019/12/15 0015 21:17
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Object hello() {
        return "hello Mango!";
    }
}
