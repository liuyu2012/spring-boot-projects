package com.liuyu.mango.admin.controller;

import com.liuyu.mango.admin.model.Dict;
import com.liuyu.mango.admin.service.DictService;
import com.liuyu.mango.core.http.HttpResult;
import com.liuyu.mango.core.page.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/20 0020 14:05
 * @description： 字典控制器
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("/dict")
public class DictController {

	@Resource
	private DictService dictService;


	/**
	 * 保存字典
	 *
	 * @param dict 记录
	 * @return 结果
	 */
	@PreAuthorize("hasAuthority('sys:dict:add') AND hasAuthority('sys:dict:edit')")
	@PostMapping("/save")
	public HttpResult save(@RequestBody Dict dict) {
		return HttpResult.ok(dictService.save(dict));
	}

	/**
	 * 删除字典
	 *
	 * @param records 记录集合
	 * @return 结果
	 */
	@PreAuthorize("hasAuthority('sys:dict:delete')")
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody List<Dict> records) {
		return HttpResult.ok(dictService.delete(records));
	}

	/**
	 * 分页查询
	 *
	 * @param pageRequest 分页请求
	 * @return 结果
	 */
	@PreAuthorize("hasAuthority('sys:dict:view')")
	@PostMapping("/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(dictService.findPage(pageRequest));
	}

	/**
	 * 根据标签查询
	 *
	 * @param label 标签
	 * @return 结果
	 */
	@PreAuthorize("hasAuthority('sys:dict:view')")
	@GetMapping("/findByLabel")
	public HttpResult findByLabel(@RequestParam String label) {
		return HttpResult.ok(dictService.findByLabel(label));
	}
}
