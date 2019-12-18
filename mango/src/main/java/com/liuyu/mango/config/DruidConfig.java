package com.liuyu.mango.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.liuyu.mango.properties.DruidDataSourceProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author： yu Liu
 * @date： 2019/12/17 0017 14:56
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Configuration
@EnableConfigurationProperties({DruidDataSourceProperties.class})
public class DruidConfig {

    @Resource
    private DruidDataSourceProperties properties;


    @Bean
    @ConditionalOnMissingBean
    public DataSource druid() {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(properties.getDriverClassName());
        druidDataSource.setUrl(properties.getUrl());
        druidDataSource.setUsername(properties.getUsername());
        druidDataSource.setPassword(properties.getPassword());
        druidDataSource.setInitialSize(properties.getInitialSize());
        druidDataSource.setMinIdle(properties.getMinIdle());
        druidDataSource.setMaxActive(properties.getMaxActive());
        druidDataSource.setMaxWait(properties.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(properties.getValidationQuery());
        druidDataSource.setTestWhileIdle(properties.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(properties.isTestOnBorrow());
        druidDataSource.setTestOnReturn(properties.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());


        try {
//            druidDataSource.setFilters(properties.getFilters());
            druidDataSource.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return druidDataSource;
    }


    @Bean
    @ConditionalOnMissingBean
    public ServletRegistrationBean<Servlet> druidServlet() {
        ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        // 白名单
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // 黑名单
        servletRegistrationBean.addInitParameter("deny", "192.168.1.119");

        // 登录查看信息的账号密码，用于登录 Druid 监控后台
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");

        // 是否能够重置数据


        return servletRegistrationBean;
    }


    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }

}
