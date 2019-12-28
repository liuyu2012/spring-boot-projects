package com.liuyu.mango.admin.controller;

import com.liuyu.mango.admin.model.Log;
import com.liuyu.mango.admin.service.LogService;
import com.liuyu.mango.core.http.HttpResult;
import com.liuyu.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/28 0028 18:10
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("/log")
public class LogController {

	@Resource
	private LogService logService;


	/**
	 * 分页查询
	 *
	 * @param pageRequest 分页请求
	 * @return 结果
	 */
	@GetMapping("/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(logService.findPage(pageRequest));
	}


	/**
	 * 清除操作日志
	 *
	 * @param records 记录集合
	 * @return 结果
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody List<Log> records) {
		return HttpResult.ok(logService.delete(records));
	}
}
