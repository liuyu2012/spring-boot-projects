package com.liuyu.mango.admin.service.impl;

import com.liuyu.mango.admin.constant.Constant;
import com.liuyu.mango.admin.mapper.RoleMapper;
import com.liuyu.mango.admin.mapper.RoleMenuMapper;
import com.liuyu.mango.admin.model.Menu;
import com.liuyu.mango.admin.model.Role;
import com.liuyu.mango.admin.model.RoleMenu;
import com.liuyu.mango.admin.service.RoleService;
import com.liuyu.mango.core.page.MybatisPageHelper;
import com.liuyu.mango.core.page.PageRequest;
import com.liuyu.mango.core.page.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author： yu Liu
 * @date： 2019/12/27 0027 13:52
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {


	@Resource
	private RoleMapper roleMapper;

	@Resource
	private RoleMenuMapper roleMenuMapper;

	/**
	 * 查询所有
	 *
	 * @return 插叙结果
	 */
	@Override
	public List<Role> findAll() {
		return roleMapper.findAll();
	}

	/**
	 * 查询橘色菜单集合
	 *
	 * @param roleId 角色Id
	 * @return 结果
	 */
	@Override
	public List<Menu> findRoleMenus(Long roleId) {
		Role role = roleMapper.selectByPrimaryKey(roleId);
		if (Constant.ADMIN.equals(role.getName())) {
			return roleMenuMapper.findAll();
		}
		return roleMenuMapper.findRoleMenus(roleId);
	}

	/**
	 * 保存角色菜单
	 *
	 * @param records 保存集合
	 * @return 保存结果
	 */
	@Override
	public int saveRoleMenus(List<RoleMenu> records) {
		if (CollectionUtils.isEmpty(records)) {
			return 1;
		}
		// 根据角色Id，删除所有的菜单
		Long roleId = records.get(0).getRoleId();
		roleMenuMapper.deleteByRoleId(roleId);
		//循环池插入数据
		records.forEach(roleMenuMapper::insertSelective);
		return 1;
	}

	/**
	 * 查询角色集合
	 *
	 * @param name 根据角色名称查询
	 * @return 查询角色
	 */
	@Override
	public List<Role> findByName(String name) {
		return roleMapper.findByName(name);
	}

	/**
	 * 保存操作
	 *
	 * @param record 记录
	 * @return 返回
	 */
	@Override
	public int save(Role record) {
		if (record.getId() == null || record.getId() == 0) {
			return roleMapper.insertSelective(record);
		}
		return roleMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 删除操作
	 *
	 * @param record 记录
	 * @return 返回
	 */
	@Override
	public int delete(Role record) {
		return roleMapper.deleteByPrimaryKey(record.getId());
	}

	/**
	 * 批量删除操作
	 *
	 * @param records 记录
	 * @return 返回
	 */
	@Override
	public int delete(List<Role> records) {
		records.forEach(this::delete);
		return 1;
	}

	/**
	 * 根据Id 查询
	 *
	 * @param id Id
	 * @return 返回
	 */
	@Override
	public Role findById(Long id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	/**
	 * 分页查询
	 *
	 * @param pageRequest 统一分页查询请求
	 * @return 统一分页查询结果
	 */
	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Map<String, Object> params = pageRequest.getParams();
		Object label = params.get("name");
		if (label != null) {
			return MybatisPageHelper.findPage(pageRequest, roleMapper, "findPageByName", label);
		}
		return MybatisPageHelper.findPage(pageRequest, roleMapper);
	}

}
