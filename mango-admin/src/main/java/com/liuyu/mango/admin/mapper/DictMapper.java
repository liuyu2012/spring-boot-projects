package com.liuyu.mango.admin.mapper;

import com.liuyu.mango.admin.model.Dict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 分页查询
     * @return 分页列表
     */
    List<Dict> findPage();

    /**
     * 根据标签名称查询
     *
     * @param label 标签
     * @return 结果
     */
    List<Dict> findByLabel(@Param(value = "label") String label);

    /**
     *  根据标签名称分页查询
     * @param label 标签
     * @return 分页结果
     */
    List<Dict> findPageByLabel(@Param(value = "label") String label);

}