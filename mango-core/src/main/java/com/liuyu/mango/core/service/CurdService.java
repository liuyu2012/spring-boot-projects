package com.liuyu.mango.core.service;

import com.liuyu.mango.core.page.PageRequest;
import com.liuyu.mango.core.page.PageResult;

import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/19 0019 18:40
 * @description： 通用CURD接口
 * @modifiedBy：
 * @version: 1.0
 */
public interface CurdService<T> {
    /**
     * 保存操作
     *
     * @param record 记录
     * @return 返回
     */
    int save(T record);

    /**
     * 删除操作
     *
     * @param record 记录
     * @return 返回
     */
    int delete(T record);

    /**
     * 批量删除操作
     *
     * @param records 记录
     * @return 返回
     */
    int delete(List<T> records);

    /**
     * 根据Id 查询
     *
     * @param id Id
     * @return 返回
     */
    T findById(Long id);

    /**
     * 分页查询
     *
     * @param pageRequest 统一分页查询请求
     * @return 统一分页查询结果
     */
    PageResult findPage(PageRequest pageRequest);
}
