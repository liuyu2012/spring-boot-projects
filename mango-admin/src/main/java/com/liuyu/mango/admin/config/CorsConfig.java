package com.liuyu.mango.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author： yu Liu
 * @date： 2019/12/19 0019 14:38
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        允许跨域访问的路径
        registry.addMapping("/**")
//                允许跨域访问的源
                .allowedOrigins("*")
                // 允许的请求方方法
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                // 预检时间间隔
                .maxAge(168000)
                // 允许头部设置
                .allowedHeaders("*")
                // 是否发送cookie
                .allowCredentials(true);

    }

}
