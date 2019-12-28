package com.liuyu.mango.admin.controller;

import com.liuyu.mango.admin.model.LoginLog;
import com.liuyu.mango.admin.service.LoginLogService;
import com.liuyu.mango.core.http.HttpResult;
import com.liuyu.mango.core.page.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/28 0028 17:57
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("/loginLog")
public class LoginLogController {


	@Resource
	private LoginLogService loginLogService;

	/**
	 * 分页查询
	 *
	 * @param pageRequest 分页请求
	 * @return 结果
	 */
	@GetMapping("/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(loginLogService.findPage(pageRequest));
	}


	/**
	 * 清除登录日志
	 *
	 * @param records 日志信息
	 * @return 结果
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody List<LoginLog> records) {
		return HttpResult.ok(loginLogService.delete(records));
	}
}
