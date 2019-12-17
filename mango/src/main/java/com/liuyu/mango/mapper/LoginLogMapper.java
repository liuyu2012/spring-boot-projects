package com.liuyu.mango.mapper;

import com.liuyu.mango.model.LoginLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 */
@Mapper
public interface LoginLogMapper {
    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return 结果
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入
     *
     * @param record 入参
     * @return 结果
     */
    int insert(LoginLog record);

    /**
     * 选择性插入
     *
     * @param record 入参
     * @return 结果
     */
    int insertSelective(LoginLog record);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 结果
     */
    LoginLog selectByPrimaryKey(Long id);

    /**
     * 根据主键选择性更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKeySelective(LoginLog record);

    /**
     * 根据主键更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKey(LoginLog record);
}