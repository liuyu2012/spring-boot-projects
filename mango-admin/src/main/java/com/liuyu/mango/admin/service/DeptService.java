package com.liuyu.mango.admin.service;

import com.liuyu.mango.admin.model.Dept;
import com.liuyu.mango.core.service.CurdService;

import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/25 0025 10:33
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public interface DeptService extends CurdService<Dept> {

	/**
	 * 查询机构树
	 *
	 * @return 机构集合
	 */
	List<Dept> findTree();
}
