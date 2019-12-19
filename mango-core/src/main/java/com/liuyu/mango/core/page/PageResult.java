package com.liuyu.mango.core.page;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/19 0019 18:24
 * @description：分页返回结果
 * @modifiedBy：
 * @version: 1.0
 */
public class PageResult {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPage;
    /**
     * 分页数据
     */
    private List<?> content;

    public PageResult() {
    }

    public int getPageNum() {
        return pageNum;
    }

    public PageResult setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageResult setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public PageResult setTotalSize(long totalSize) {
        this.totalSize = totalSize;
        return this;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public PageResult setTotalPage(int totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public List<?> getContent() {
        return content;
    }

    public PageResult setContent(List<?> content) {
        this.content = content;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
