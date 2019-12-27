package com.liuyu.mango.admin.mapper;

import com.liuyu.mango.admin.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface RoleMapper {
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
	int insert(Role record);

	/**
	 * 选择性插入
	 *
	 * @param record 入参
	 * @return 结果
	 */
	int insertSelective(Role record);

	/**
	 * 根据主键查询
	 *
	 * @param id 入参
	 * @return 结果
	 */
	Role selectByPrimaryKey(Long id);

	/**
	 * 根据主键更新
	 *
	 * @param record 入参
	 * @return 结果
	 */
	int updateByPrimaryKeySelective(Role record);

	/**
	 * 根据主键更新
	 *
	 * @param record 入参
	 * @return 结果
	 */
	int updateByPrimaryKey(Role record);

	/**
	 * 根据名称查找角色
	 *
	 * @param name 名称
	 * @return 根据名称查找角色
	 */
	List<Role> findByName(@Param(value = "name") String name);

	/**
	 * 查找全部菜单
	 *
	 * @return 角色列表
	 */
	List<Role> findAll();

}