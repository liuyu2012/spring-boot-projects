package com.liuyu.mango.admin.service.impl;

import com.liuyu.mango.admin.mapper.DictMapper;
import com.liuyu.mango.admin.model.Dict;
import com.liuyu.mango.admin.service.DictService;
import com.liuyu.mango.core.page.MybatisPageHelper;
import com.liuyu.mango.core.page.PageRequest;
import com.liuyu.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author： yu Liu
 * @date： 2019/12/20 0020 13:51
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Service("dictService")
public class DictServiceImpl implements DictService {
    @Resource
    private DictMapper dictMapper;

    @Override
    public int save(Dict record) {
        if (record.getId() == null || record.getId() == 0) {
            return dictMapper.insertSelective(record);
        }
        return dictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(Dict record) {
        return dictMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<Dict> records) {
        records.forEach(this::delete);
        return 1;
    }

    @Override
    public Dict findById(Long id) {
        return dictMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Map<String, Object> params = pageRequest.getParams();
        if (params != null) {
            Object label = params.get("label");
            if (label != null) {
                return MybatisPageHelper.findPage(pageRequest, dictMapper, "findPageByLabel", label);
            }
        }
        return MybatisPageHelper.findPage(pageRequest, dictMapper);
    }

    @Override
    public List<Dict> findByLabel(String label) {
        return dictMapper.findByLabel(label);
    }
}
