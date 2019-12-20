package com.liuyu.mango.admin.controller;

import com.liuyu.mango.admin.model.User;
import com.liuyu.mango.admin.service.UserService;
import com.liuyu.mango.core.http.HttpResult;
import com.liuyu.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(userService.findPage(pageRequest));
    }

    @PostMapping("/save")
    public HttpResult save(@RequestBody User user) {
        return HttpResult.ok(userService.save(user));
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<User> users) {
        return HttpResult.ok(userService.delete(users));
    }

    @GetMapping("/findByName")
    public HttpResult findByName(@RequestParam String name) {
        return HttpResult.ok(userService.findByName(name));
    }
}
