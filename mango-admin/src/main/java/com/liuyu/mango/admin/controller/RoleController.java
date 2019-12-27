package com.liuyu.mango.admin.controller;

import com.liuyu.mango.admin.constant.Constant;
import com.liuyu.mango.admin.model.Role;
import com.liuyu.mango.admin.model.RoleMenu;
import com.liuyu.mango.admin.service.RoleService;
import com.liuyu.mango.core.http.HttpResult;
import com.liuyu.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/27 0027 11:15
 * @description： 角色控制器
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {


	@Resource
	private RoleService roleService;

	/**
	 * 保存记录
	 *
	 * @param record 角色
	 * @return 保存记录
	 */
	@PostMapping("/save")
	public HttpResult save(@RequestBody Role record) {
		// 根据主键
		Role role = roleService.findById(record.getId());
		if (role != null) {
			if (Constant.ADMIN.equals(record.getName())) {
				return HttpResult.error("超级管理员不允许修改");
			}
		}
		// 新增角色
		if ((record.getId() == null || record.getId() == 0) && !roleService.findByName(record.getName()).isEmpty()) {
			return HttpResult.error("角色已经存在");
		}
		return HttpResult.ok(roleService.save(record));
	}

	/**
	 * 删除角色
	 *
	 * @param roles 角色集合
	 * @return 删除角色
	 */
	@PostMapping("/delete")
	public HttpResult delete(List<Role> roles) {
		return HttpResult.ok(roleService.delete(roles));
	}


	/**
	 * 分页查询
	 *
	 * @param pageRequest 分页请求
	 * @return 分页查询结果
	 */
	@PostMapping("/findPage")
	public HttpResult findPage(PageRequest pageRequest) {
		return HttpResult.ok(roleService.findPage(pageRequest));
	}


	/**
	 * 查询全部
	 *
	 * @return 插叙结果
	 */
	@GetMapping("/findAll")
	public HttpResult findAll() {
		return HttpResult.ok(roleService.findAll());
	}

	/**
	 * 查询角色菜单
	 *
	 * @param roleId 角色Id
	 * @return 查询角色菜单
	 */
	@GetMapping("/findRoleMenus")
	public HttpResult findRoleMenus(@RequestParam Long roleId) {
		return HttpResult.ok(roleService.findRoleMenus(roleId));
	}


	/**
	 * 保存角色菜单集合
	 *
	 * @param records 角色菜单集合
	 * @return 保存结果
	 */
	@PostMapping("/saveRoleMenus")
	public HttpResult saveRoleMenus(List<RoleMenu> records) {
		for (RoleMenu record : records) {
			Role role = roleService.findById(record.getRoleId());
			if (Constant.ADMIN.equals(role.getName())) {
				return HttpResult.error("超级管理员的所有权限不允许修改");
			}

		}
		return HttpResult.ok(roleService.saveRoleMenus(records));
	}

}
