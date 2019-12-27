package com.liuyu.mango.admin.service.impl;

import com.liuyu.mango.admin.mapper.DeptMapper;
import com.liuyu.mango.admin.model.Dept;
import com.liuyu.mango.admin.service.DeptService;
import com.liuyu.mango.core.page.MybatisPageHelper;
import com.liuyu.mango.core.page.PageRequest;
import com.liuyu.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author： yu Liu
 * @date： 2019/12/25 0025 10:34
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {

	@Resource
	private DeptMapper deptMapper;

	/**
	 * 查询机构树
	 *
	 * @return 机构集合
	 */
	@Override
	public List<Dept> findTree() {

		List<Dept> depts = deptMapper.findAll();
		// 过滤处理
		List<Dept> deptList = depts
				.stream()
				.filter(dept -> dept.getParentId() == null || dept.getParentId() == 0)
				.collect(Collectors.toList());
		// 循环赋值
		deptList.forEach(dept -> dept.setLevel(0));

		// 查找子查询
		findChildren(deptList, depts);

		return deptList;
	}

	private void findChildren(List<Dept> deptList, List<Dept> depts) {
		deptList.forEach(dept -> {
			depts.forEach(dept1 -> {

			});
		});
	}

	/**
	 * 保存操作
	 *
	 * @param record 记录
	 * @return 返回
	 */
	@Override
	public int save(Dept record) {
		if (record.getId() == null || record.getId() == 0) {
			return deptMapper.insertSelective(record);
		}

		return deptMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 删除操作
	 *
	 * @param record 记录
	 * @return 返回
	 */
	@Override
	public int delete(Dept record) {
		return deptMapper.deleteByPrimaryKey(record.getId());
	}

	/**
	 * 批量删除操作
	 *
	 * @param records 记录
	 * @return 返回
	 */
	@Override
	public int delete(List<Dept> records) {
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
	public Dept findById(Long id) {
		return deptMapper.selectByPrimaryKey(id);
	}

	/**
	 * 分页查询
	 *
	 * @param pageRequest 统一分页查询请求
	 * @return 统一分页查询结果
	 */
	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, deptMapper);
	}
}
