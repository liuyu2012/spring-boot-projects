package com.liuyu.mango.service.impl;

import com.liuyu.mango.mapper.UserMapper;
import com.liuyu.mango.model.User;
import com.liuyu.mango.service.UserService;
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
