package com.liuyu.mango.admin.service;

import com.liuyu.mango.admin.model.Config;
import com.liuyu.mango.core.service.CurdService;

import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/28 0028 17:36
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public interface ConfigService extends CurdService<Config> {
	/**
	 * 根据标签查找集合
	 *
	 * @param label 标签
	 * @return 结果
	 */
	List<Config> findByLabel(String label);
}
