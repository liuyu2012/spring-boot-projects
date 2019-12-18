package com.liuyu.mango.properties;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author： yu Liu
 * @date： 2019/12/17 0017 14:35
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */

@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidDataSourceProperties {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    private int initialSize;
    private int minIdle;
    private int maxActive = 100;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;

    private String filters;

    public DruidDataSourceProperties() {
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public DruidDataSourceProperties setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public DruidDataSourceProperties setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public DruidDataSourceProperties setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DruidDataSourceProperties setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getInitialSize() {
        return initialSize;
    }

    public DruidDataSourceProperties setInitialSize(int initialSize) {
        this.initialSize = initialSize;
        return this;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public DruidDataSourceProperties setMinIdle(int minIdle) {
        this.minIdle = minIdle;
        return this;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public DruidDataSourceProperties setMaxActive(int maxActive) {
        this.maxActive = maxActive;
        return this;
    }

    public long getMaxWait() {
        return maxWait;
    }

    public DruidDataSourceProperties setMaxWait(long maxWait) {
        this.maxWait = maxWait;
        return this;
    }

    public long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public DruidDataSourceProperties setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
        return this;
    }

    public long getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public DruidDataSourceProperties setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
        return this;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public DruidDataSourceProperties setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
        return this;
    }

    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }

    public DruidDataSourceProperties setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
        return this;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public DruidDataSourceProperties setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
        return this;
    }

    public boolean isTestOnReturn() {
        return testOnReturn;
    }

    public DruidDataSourceProperties setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
        return this;
    }

    public boolean isPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public DruidDataSourceProperties setPoolPreparedStatements(boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
        return this;
    }

    public int getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    public DruidDataSourceProperties setMaxPoolPreparedStatementPerConnectionSize(int maxPoolPreparedStatementPerConnectionSize) {
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
        return this;
    }

    public String getFilters() {
        return filters;
    }

    public DruidDataSourceProperties setFilters(String filters) {
        this.filters = filters;
        return this;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
