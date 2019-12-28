package com.liuyu.mango.admin.service.impl;

import com.liuyu.mango.admin.mapper.ConfigMapper;
import com.liuyu.mango.admin.model.Config;
import com.liuyu.mango.admin.service.ConfigService;
import com.liuyu.mango.core.page.MybatisPageHelper;
import com.liuyu.mango.core.page.PageRequest;
import com.liuyu.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author： yu Liu
 * @date： 2019/12/28 0028 17:43
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Service
public class ConfigServiceImpl implements ConfigService {
	@Resource
	private ConfigMapper configMapper;

	/**
	 * 删除操作
	 *
	 * @param record 记录
	 * @return 返回
	 */
	@Override
	public int delete(Config record) {
		return configMapper.deleteByPrimaryKey(record.getId());
	}

	/**
	 * 批量删除操作
	 *
	 * @param records 记录
	 * @return 返回
	 */
	@Override
	public int delete(List<Config> records) {
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
	public Config findById(Long id) {
		return configMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据标签查找集合
	 *
	 * @param label 标签
	 * @return 结果
	 */
	@Override
	public List<Config> findByLabel(String label) {
		return configMapper.findByLabel(label);
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
		Object label = params.get("label");
		if (label != null) {
			return MybatisPageHelper.findPage(pageRequest, configMapper, "findPageByLabel", label);
		}
		return MybatisPageHelper.findPage(pageRequest, configMapper);
	}

	/**
	 * 保存操作
	 *
	 * @param record 记录
	 * @return 返回
	 */
	@Override
	public int save(Config record) {
		if ((record.getId() == null) || (record.getId() == 0)) {
			return configMapper.insertSelective(record);
		}
		return configMapper.updateByPrimaryKeySelective(record);
	}
}


