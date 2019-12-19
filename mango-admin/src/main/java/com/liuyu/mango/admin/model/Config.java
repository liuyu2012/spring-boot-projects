package com.liuyu.mango.admin.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
public class Config implements Serializable {
    private Long id;

    private String value;

    private String label;

    private String type;

    private String description;

    private Long sort;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private String remarks;

    private Byte delFlag;

    public Config() {
    }

    public static Config build() {
        return new Config();
    }

    public Long getId() {
        return id;
    }

    public Config setId(Long id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Config setValue(String value) {
        this.value = value;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public Config setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getType() {
        return type;
    }

    public Config setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Config setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getSort() {
        return sort;
    }

    public Config setSort(Long sort) {
        this.sort = sort;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public Config setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Config setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public Config setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
        return this;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public Config setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public Config setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public Config setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
        return this;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}