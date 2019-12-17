package com.liuyu.mango.mapper;

import com.liuyu.mango.model.Dict;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 */
@Mapper
public interface DictMapper {
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
    int insert(Dict record);

    /**
     * 选择性插入
     *
     * @param record 入参
     * @return 结果
     */
    int insertSelective(Dict record);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 结果
     */
    Dict selectByPrimaryKey(Long id);

    /**
     * 根据主键选择性更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKeySelective(Dict record);

    /**
     * 根据主键更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKey(Dict record);
}