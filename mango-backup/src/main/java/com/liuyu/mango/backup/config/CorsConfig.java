package com.liuyu.mango.backup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author： yu Liu
 * @date： 2019/12/30 0030 10:48
 * @description： 跨域配置类
 * @modifiedBy：
 * @version: 1.0
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

	/**
	 * 添加跨域访问器
	 *
	 * @param registry 注册器
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedHeaders("*")
				.allowedOrigins("*")
				.allowedMethods("POST", "GET", "DELETE", "PUT", "OPTION")
				.maxAge(168000)
				.allowCredentials(true);
	}

}
