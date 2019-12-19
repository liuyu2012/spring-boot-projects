package com.liuyu.mango.admin.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
public class Menu implements Serializable {
    private Long id;

    private String name;

    private Long parentId;

    private String url;

    private String perms;

    private Integer type;

    private String icon;

    private Integer orderNum;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Byte delFlag;

    public Menu() {
    }

    public static Menu build() {
        return new Menu();
    }

    public Long getId() {
        return id;
    }

    public Menu setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public Long getParentId() {
        return parentId;
    }

    public Menu setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Menu setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPerms() {
        return perms;
    }

    public Menu setPerms(String perms) {
        this.perms = perms;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Menu setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public Menu setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public Menu setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public Menu setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Menu setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public Menu setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
        return this;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public Menu setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public Menu setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}