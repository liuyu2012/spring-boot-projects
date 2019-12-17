package com.liuyu.mango.service.impl;

import com.liuyu.mango.mapper.SysUserMapper;
import com.liuyu.mango.model.SysUser;
import com.liuyu.mango.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/15 0015 23:05
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {


    @Autowired
    private SysUserMapper userMapper;

    @Override
    public List<SysUser> findAll() {
        return userMapper.findAll();
    }
}
