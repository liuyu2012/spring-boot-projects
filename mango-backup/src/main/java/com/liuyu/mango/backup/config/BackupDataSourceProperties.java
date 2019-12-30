package com.liuyu.mango.backup.config;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author： yu Liu
 * @date： 2019/12/30 0030 10:58
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "mango.backup.datasource")
public class BackupDataSourceProperties {
	private String host;
	private String userName;
	private String password;
	private String database;

	public String getHost() {
		return host;
	}

	public BackupDataSourceProperties setHost(String host) {
		this.host = host;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public BackupDataSourceProperties setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public BackupDataSourceProperties setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getDatabase() {
		return database;
	}

	public BackupDataSourceProperties setDatabase(String database) {
		this.database = database;
		return this;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
