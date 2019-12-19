package com.liuyu.mango.admin.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
public class RoleDept implements Serializable {
    private Long id;

    private Long roleId;

    private Long deptId;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    public RoleDept() {
    }

    public static RoleDept build() {
        return new RoleDept();
    }

    public Long getId() {
        return id;
    }

    public RoleDept setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public RoleDept setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }

    public Long getDeptId() {
        return deptId;
    }

    public RoleDept setDeptId(Long deptId) {
        this.deptId = deptId;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public RoleDept setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public RoleDept setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public RoleDept setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
        return this;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public RoleDept setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}