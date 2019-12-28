package com.liuyu.mango.admin.service.impl;

import com.liuyu.mango.admin.mapper.LoginLogMapper;
import com.liuyu.mango.admin.model.LoginLog;
import com.liuyu.mango.admin.service.LoginLogService;
import com.liuyu.mango.core.page.MybatisPageHelper;
import com.liuyu.mango.core.page.PageRequest;
import com.liuyu.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author： yu Liu
 * @date： 2019/12/28 0028 18:02
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {


	@Resource
	private LoginLogMapper loginLogMapper;

	/**
	 * 保存操作
	 *
	 * @param record 记录
	 * @return 返回
	 */
	@Override
	public int save(LoginLog record) {
		if (record.getId() == null || record.getId() == 0) {
			return loginLogMapper.insertSelective(record);
		}
		return loginLogMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 删除操作
	 *
	 * @param record 记录
	 * @return 返回
	 */
	@Override
	public int delete(LoginLog record) {
		return loginLogMapper.deleteByPrimaryKey(record.getId());
	}

	/**
	 * 批量删除操作
	 *
	 * @param records 记录
	 * @return 返回
	 */
	@Override
	public int delete(List<LoginLog> records) {
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
	public LoginLog findById(Long id) {
		return loginLogMapper.selectByPrimaryKey(id);
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
		Object username = params.get("username");
		if (username != null) {
			return MybatisPageHelper.findPage(pageRequest, loginLogMapper, "findPageByUsername", username);
		}

		Object status = params.get("status");
		if (status != null) {
			return MybatisPageHelper.findPage(pageRequest, loginLogMapper, "findPageByStatus", status);
		}
		return MybatisPageHelper.findPage(pageRequest, loginLogMapper);
	}
}
