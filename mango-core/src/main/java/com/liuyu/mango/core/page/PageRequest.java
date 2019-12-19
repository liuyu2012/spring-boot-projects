package com.liuyu.mango.core.page;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： yu Liu
 * @date： 2019/12/19 0019 18:09
 * @description： 分页请求
 * @modifiedBy：
 * @version: 1.0
 */
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum = 1;
    /**
     * 每页数量
     */
    private int pageSize = 10;
    /**
     * 查询参数
     */
    private Map<String, Object> params = new HashMap<>();

    public PageRequest() {
    }

    public PageRequest(int pageNum, int pageSize, Map<String, Object> params) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.params = params;
    }

    public int getPageNum() {
        return pageNum;
    }

    public PageRequest setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageRequest setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public PageRequest setParams(Map<String, Object> params) {
        this.params = params;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
