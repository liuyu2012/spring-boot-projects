package com.liuyu.mango.admin.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author： yu Liu
 * @date： 2019/12/23 0023 15:39
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    public static final long serialVersionUID = 1L;
    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public GrantedAuthorityImpl setAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
