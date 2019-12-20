package com.liuyu.mango.admin.service;

import com.liuyu.mango.admin.model.Dict;
import com.liuyu.mango.core.service.CurdService;

import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/20 0020 13:50
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public interface DictService extends CurdService<Dict> {
    /**
     * 根据名称查询
     *
     * @param label 标签
     * @return 结果
     */
    List<Dict> findByLabel(String label);

}
