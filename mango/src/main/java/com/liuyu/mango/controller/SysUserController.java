package com.liuyu.mango.controller;

import com.liuyu.mango.model.SysUser;
import com.liuyu.mango.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class SysUserController {


    @Autowired
    private SysUserService userService;

    @GetMapping("/findAll")
    public List<SysUser> findAll() {
        return userService.findAll();
    }
}
