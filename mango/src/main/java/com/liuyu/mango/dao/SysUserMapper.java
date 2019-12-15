package com.liuyu.mango.dao;

import com.liuyu.mango.model.SysUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 查询所有用户信息
     * @return 查询所有用户信息
     */
    List<SysUser> findAll();
}