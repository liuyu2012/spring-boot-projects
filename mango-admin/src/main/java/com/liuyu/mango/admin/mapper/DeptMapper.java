package com.liuyu.mango.admin.mapper;

import com.liuyu.mango.admin.model.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface DeptMapper {
    /**
     * 删除
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
    int insert(Dept record);

    /**
     * 选择性插入
     *
     * @param record 入参
     * @return 结果
     */
    int insertSelective(Dept record);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 结果
     */
    Dept selectByPrimaryKey(Long id);

    /**
     * 选择性更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKeySelective(Dept record);

    /**
     * 根据主键更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKey(Dept record);

    /**
     * 查找所有
     * @return 机构集合
     */
	List<Dept> findAll();
}