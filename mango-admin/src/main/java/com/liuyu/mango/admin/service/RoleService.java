package com.liuyu.mango.admin.service;

import com.liuyu.mango.admin.model.Menu;
import com.liuyu.mango.admin.model.Role;
import com.liuyu.mango.admin.model.RoleMenu;
import com.liuyu.mango.core.service.CurdService;

import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/27 0027 11:17
 * @description： 角色管理
 * @modifiedBy：
 * @version: 1.0
 */
public interface RoleService extends CurdService<Role> {

	/**
	 * 查询所有
	 *
	 * @return 插叙结果
	 */
	List<Role> findAll();

	/**
	 * 查询橘色菜单集合
	 *
	 * @param roleId 角色Id
	 * @return 结果
	 */
	List<Menu> findRoleMenus(Long roleId);

	/**
	 * 保存角色菜单
	 *
	 * @param records 保存集合
	 * @return 保存结果
	 */
	int saveRoleMenus(List<RoleMenu> records);

	/**
	 * 查询角色集合
	 *
	 * @param name 根据角色名称查询
	 * @return 查询角色
	 */
	List<Role> findByName(String name);
}
