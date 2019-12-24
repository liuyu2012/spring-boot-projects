package com.liuyu.mango.admin.vo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author： yu Liu
 * @date： 2019/12/24 0024 15:48
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class LoginBean {
	private String account;
	private String password;
	private String captcha;

	public LoginBean() {
	}

	public LoginBean(String account, String password, String captcha) {
		this.account = account;
		this.password = password;
		this.captcha = captcha;
	}

	public String getAccount() {
		return account;
	}

	public LoginBean setAccount(String account) {
		this.account = account;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public LoginBean setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getCaptcha() {
		return captcha;
	}

	public LoginBean setCaptcha(String captcha) {
		this.captcha = captcha;
		return this;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
