package com.liuyu.mango.admin.mapper;

import com.liuyu.mango.admin.model.Log;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 */
@Mapper
public interface LogMapper {
    /**
     * 根据逐渐删除
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
    int insert(Log record);

    /**
     * 选择性插入
     *
     * @param record 入参
     * @return 结果
     */
    int insertSelective(Log record);

    /**
     * 根据主键查询
     *
     * @param id 入参
     * @return 结果
     */
    Log selectByPrimaryKey(Long id);

    /**
     * 根据主键更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKeySelective(Log record);

    /**
     * 根据主键更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKey(Log record);
}