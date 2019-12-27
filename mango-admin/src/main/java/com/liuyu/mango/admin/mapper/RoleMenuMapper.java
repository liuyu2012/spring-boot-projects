package com.liuyu.mango.admin.mapper;

import com.liuyu.mango.admin.model.Menu;
import com.liuyu.mango.admin.model.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface RoleMenuMapper {

	/**
	 * 根据主键删除
	 *
	 * @param id 入参
	 * @return 结果
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 根据角色Id删除菜单
	 *
	 * @param roleId 角色Id
	 * @return 删除juese
	 */
	int deleteByRoleId(@Param(value = "roleId") Long roleId);

	/**
	 * 菜单集合
	 *
	 * @return 菜单集合
	 */
	List<Menu> findAll();

	/**
	 * 根据角色Id查找菜单集合
	 *
	 * @param roleId 角色Id
	 * @return 菜单集合
	 */
	List<Menu> findRoleMenus(@Param(value = "roleId") Long roleId);

	/**
	 * 插入
	 *
	 * @param record 入参
	 * @return 结果
	 */
	int insert(RoleMenu record);

	/**
	 * 选择性插入
	 *
	 * @param record 入参
	 * @return 结果
	 */
	int insertSelective(RoleMenu record);

	/**
	 * 根据主键查询
	 *
	 * @param id 入参
	 * @return 结果
	 */
	RoleMenu selectByPrimaryKey(Long id);

	/**
	 * 根据主键更新
	 *
	 * @param record 入参
	 * @return 结果
	 */
	int updateByPrimaryKey(RoleMenu record);

	/**
	 * 根据主键更新
	 *
	 * @param record 入参
	 * @return 结果
	 */
	int updateByPrimaryKeySelective(RoleMenu record);
}


//~ Formatted by Jindent --- http://www.jindent.com
