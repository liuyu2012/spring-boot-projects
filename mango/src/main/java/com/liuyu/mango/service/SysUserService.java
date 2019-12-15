package com.liuyu.mango.service;

import com.liuyu.mango.model.SysUser;

import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/15 0015 22:57
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public interface SysUserService {

    /**
     * 查询所有用户信息
     * @return 所有用户信息
     */
    List<SysUser> findAll();
}
