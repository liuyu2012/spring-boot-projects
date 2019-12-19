package com.liuyu.mango.admin.mapper;

import com.liuyu.mango.admin.model.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 */
@Mapper
public interface UserRoleMapper {
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
    int insert(UserRole record);

    /**
     * 选择性插入
     *
     * @param record 入参
     * @return 结果
     */
    int insertSelective(UserRole record);

    /**
     * 根据主键查询
     *
     * @param id 入参
     * @return 结果
     */
    UserRole selectByPrimaryKey(Long id);

    /**
     * 根据主键更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * 根据主键更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKey(UserRole record);
}