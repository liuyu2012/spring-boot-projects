package com.liuyu.mango.admin.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
public class Dept implements Serializable {
    private Long id;

    private String name;

    private Long parentId;

    private Integer orderNum;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Byte delFlag;


    public Dept() {
    }

    public static Dept build() {
        return new Dept();
    }

    public Long getId() {
        return id;
    }

    public Dept setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dept setName(String name) {
        this.name = name;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public Dept setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public Dept setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public Dept setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Dept setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public Dept setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
        return this;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public Dept setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public Dept setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}