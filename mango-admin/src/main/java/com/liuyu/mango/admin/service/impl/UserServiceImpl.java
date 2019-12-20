package com.liuyu.mango.admin.service.impl;

import com.liuyu.mango.admin.model.User;
import com.liuyu.mango.admin.mapper.UserMapper;
import com.liuyu.mango.admin.service.UserService;
import com.liuyu.mango.core.page.MybatisPageHelper;
import com.liuyu.mango.core.page.PageRequest;
import com.liuyu.mango.core.page.PageResult;
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

    @Override
    public List<User> findPage() {
        return userMapper.findPage();
    }

    @Override
    public int save(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int delete(User record) {
        return userMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<User> records) {
        for (User record : records) {
            userMapper.deleteByPrimaryKey(record.getId());
        }
        return 1;
    }

    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, userMapper);
    }
}
