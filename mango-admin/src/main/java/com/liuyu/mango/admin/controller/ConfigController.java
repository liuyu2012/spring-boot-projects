package com.liuyu.mango.admin.controller;

import com.liuyu.mango.admin.model.Config;
import com.liuyu.mango.admin.service.ConfigService;
import com.liuyu.mango.core.http.HttpResult;
import com.liuyu.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 配置管理
 *
 * @author： yu Liu
 * @date： 2019/12/28 0028 17:35
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("/config")
public class ConfigController {


	@Resource
	private ConfigService configService;

	/**
	 * 保存配置
	 *
	 * @param record 记录
	 * @return 结果
	 */
	@PostMapping("/save")
	public HttpResult save(@RequestBody Config record) {
		return HttpResult.ok(configService.save(record));
	}

	/**
	 * 删除配置
	 *
	 * @param records 集合
	 * @return 结果
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody List<Config> records) {
		return HttpResult.ok(configService.delete(records));
	}

	/**
	 * 分页查询
	 *
	 * @param pageRequest 分页请求
	 * @return 请求结果
	 */
	@GetMapping("/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(configService.findPage(pageRequest));
	}


	/**
	 * 根据标签名称查找
	 *
	 * @param label 标签
	 * @return 结果
	 */
	@GetMapping("/findByLabel")
	public HttpResult findByLabel(@RequestParam String label) {
		return HttpResult.ok(configService.findByLabel(label));
	}


}
