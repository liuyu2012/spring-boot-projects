package com.liuyu.mango.admin.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
public class Log implements Serializable {
    private Long id;

    private String userName;

    private String operation;

    private String method;

    private String params;

    private Long time;

    private String ip;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    public Log() {
    }

    public static Log build() {
        return new Log();
    }
    public Long getId() {
        return id;
    }

    public Log setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Log setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getOperation() {
        return operation;
    }

    public Log setOperation(String operation) {
        this.operation = operation;
        return this;
    }

    public String getMethod() {
        return method;
    }

    public Log setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getParams() {
        return params;
    }

    public Log setParams(String params) {
        this.params = params;
        return this;
    }

    public Long getTime() {
        return time;
    }

    public Log setTime(Long time) {
        this.time = time;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public Log setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public Log setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Log setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public Log setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
        return this;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public Log setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}