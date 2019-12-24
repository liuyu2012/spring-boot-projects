package com.liuyu.mango.admin.mapper;

import com.liuyu.mango.admin.model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface MenuMapper {
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
    int insert(Menu record);

    /**
     * 选择性插入
     *
     * @param record 入参
     * @return 结果
     */
    int insertSelective(Menu record);

    /**
     * 根据主键查询
     *
     * @param id 入参
     * @return 结果
     */
    Menu selectByPrimaryKey(Long id);

    /**
     * 根据主键更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * 根据主键更新
     *
     * @param record 入参
     * @return 结果
     */
    int updateByPrimaryKey(Menu record);

    /**
     * 查找所有菜单信息
     *
     * @return 所有菜单信息
     */
    List<Menu> findAll();

    /**
     * 根据用户名查找菜单列表
     *
     * @param username 用户名
     * @return 菜单列表
     */
    List<Menu> findByUserName(@Param("username") String username);
}