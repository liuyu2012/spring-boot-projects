package com.liuyu.mango.admin.controller;

import com.liuyu.mango.admin.model.Menu;
import com.liuyu.mango.admin.service.MenuService;
import com.liuyu.mango.core.http.HttpResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/27 0027 14:37
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

	@Resource
	private MenuService menuService;


	/**
	 * 保存菜单
	 *
	 * @param record 保存记录
	 * @return 结果
	 */
	@PostMapping("/save")
	public HttpResult save(@RequestBody Menu record) {
		return HttpResult.ok(menuService.save(record));
	}

	/**
	 * 删除结果
	 *
	 * @param records 菜单集合
	 * @return 结果
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody List<Menu> records) {
		return HttpResult.ok(menuService.delete(records));
	}


	/**
	 * 查找菜单树
	 *
	 * @return 结果
	 */
	@GetMapping("/findMenuTree")
	public HttpResult findMenuTree() {
		return HttpResult.ok(menuService.findTree(null, 0));
	}

	/**
	 * 查找导航树
	 *
	 * @param username 用户名
	 * @return 结果
	 */
	@GetMapping("/findNavTree")
	public HttpResult findNavTree(@RequestParam String username) {
		return HttpResult.ok(menuService.findTree(username, 1));
	}


}
