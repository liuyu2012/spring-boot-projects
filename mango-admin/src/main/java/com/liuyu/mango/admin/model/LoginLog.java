package com.liuyu.mango.admin.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
public class LoginLog implements Serializable {
    private Long id;

    private String userName;

    private String status;

    private String ip;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    public LoginLog() {
    }

    public static LoginLog build() {
        return new LoginLog();
    }

    public Long getId() {
        return id;
    }

    public LoginLog setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public LoginLog setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public LoginLog setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public LoginLog setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public LoginLog setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public LoginLog setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public LoginLog setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
        return this;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public LoginLog setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}