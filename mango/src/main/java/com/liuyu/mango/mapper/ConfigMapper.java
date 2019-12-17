package com.liuyu.mango.mapper;

import com.liuyu.mango.model.Config;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 */
@Mapper
public interface ConfigMapper {
    /**
     * 根据主键删除指定对象
     *
     * @param id Id
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据
     *
     * @param record 入参
     * @return 插入结果
     */
    int insert(Config record);

    /**
     * 选择性插入
     *
     * @param record 入参
     * @return 结果
     */
    int insertSelective(Config record);

    /**
     * 根据主键查询配置
     *
     * @param id 入参主键
     * @return 结果
     */
    Config selectByPrimaryKey(Long id);

    /**
     * 选择性根据主键更新配置
     *
     * @param record 配置
     * @return 结果
     */
    int updateByPrimaryKeySelective(Config record);

    /**
     * 根据主键更新配置
     *
     * @param record 配置入参
     * @return 结果
     */
    int updateByPrimaryKey(Config record);
}