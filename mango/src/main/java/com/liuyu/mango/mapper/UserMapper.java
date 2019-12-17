package com.liuyu.mango.mapper;

import com.liuyu.mango.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface UserMapper {
    /**
     * 根据主键删除
     *
     * @param id 入参
     * @return 结果
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入
     *
     * @param record 入参
     * @return 结果
     */
    int insert(User record);

    /**
     * 选择性插入
     *
     * @param record 入参
     * @return 结果
     */
    int insertSelective(User record);

    /**
     * 根据主键查询
     *
     * @param id 入参
     * @return 结果
     */
    User selectByPrimaryKey(Long id);

    /**
     * 根据主键更细腻
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 根据主键更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKey(User record);

    /**
     * 查询所有用户信息
     *
     * @return 查询所有用户信息
     */
    List<User> findAll();
}