package com.liuyu.mango.admin.controller;

import com.liuyu.mango.admin.model.Dept;
import com.liuyu.mango.admin.service.DeptService;
import com.liuyu.mango.core.http.HttpResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/25 0025 10:31
 * @description： 机构控制器
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

	@Resource
	private DeptService deptService;

	/**
	 * 保存记录
	 *
	 * @param dept 机构信息
	 * @return 保存结果
	 */
	@PostMapping("/save")
	public HttpResult save(@RequestBody Dept dept) {
		return HttpResult.ok(deptService.save(dept));
	}

	/**
	 * 删除机构
	 *
	 * @param depts 机构集合
	 * @return 删除结果
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody List<Dept> depts) {
		return HttpResult.ok(deptService.delete(depts));
	}


	@GetMapping("/findTree")
	public HttpResult findTree() {

		return HttpResult.ok(deptService.findTree());
	}
}
