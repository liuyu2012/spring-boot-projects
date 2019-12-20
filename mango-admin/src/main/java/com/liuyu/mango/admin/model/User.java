package com.liuyu.mango.admin.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
public class User implements Serializable {
    private Long id;

    private String name;

    private String nickName;

    private String deptName;

    private String roleNames;

    private String avatar;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Byte status;

    private Long deptId;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Byte delFlag;

    public User() {
    }

    public static User build() {
        return new User();
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public User setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public User setAvatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public User setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public User setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Byte getStatus() {
        return status;
    }

    public User setStatus(Byte status) {
        this.status = status;
        return this;
    }

    public Long getDeptId() {
        return deptId;
    }

    public User setDeptId(Long deptId) {
        this.deptId = deptId;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public User setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public User setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public User setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
        return this;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public User setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public User setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public String getDeptName() {
        return deptName;
    }

    public User setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public User setRoleNames(String roleNames) {
        this.roleNames = roleNames;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


}