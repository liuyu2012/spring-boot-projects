package com.liuyu.mango.admin.service.impl;

import com.liuyu.mango.admin.model.User;
import com.liuyu.mango.admin.mapper.UserMapper;
import com.liuyu.mango.admin.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/15 0015 23:05
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
