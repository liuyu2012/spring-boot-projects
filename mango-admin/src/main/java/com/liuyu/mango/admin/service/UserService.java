package com.liuyu.mango.admin.service;

import com.liuyu.mango.admin.model.User;
import com.liuyu.mango.core.service.CurdService;

import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/15 0015 22:57
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public interface UserService extends CurdService<User> {

    /**
     * 查询所有用户信息
     *
     * @return 所有用户信息
     */
    List<User> findAll();

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    List<User> findPage();

    /**
     * 根据姓名查找用户信息
     * @param name 姓名
     * @return 用户信息
     */
    User findByName(String name);
}
