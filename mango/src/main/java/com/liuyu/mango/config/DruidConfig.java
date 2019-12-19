package com.liuyu.mango.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.google.common.collect.Maps;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;
import java.util.Map;

/**
 * @author： yu Liu
 * @date： 2019/12/17 0017 14:56
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean<Servlet> statViewServlet(){
        ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = Maps.newHashMap();

        // 登录查看信息的账号和密码
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword", "admin");
        // 白名单
        initParams.put("allow", "");//默认就是允许所有访问
        // 黑名单
        initParams.put("deny", "192.168.1.1");
        // 是否能够重置数据
        initParams.put("resetEnable","false");

        servletRegistrationBean.setInitParameters(initParams);
        return servletRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions",  "*.js,*.css,/druid/*");
        return filterRegistrationBean;
    }






}
