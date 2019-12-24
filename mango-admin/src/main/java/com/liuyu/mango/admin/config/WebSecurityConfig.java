package com.liuyu.mango.admin.config;

import com.liuyu.mango.admin.security.JwtAuthenticationFilter;
import com.liuyu.mango.admin.security.JwtAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.annotation.Resource;

/**
 * 安全相关配置
 *
 * @author： yu Liu
 * @date： 2019/12/23 0023 13:23
 * @description： 安全相关配置表
 * @modifiedBy：
 * @version: 1.0
 */
// 配置注解
@Configuration
// 开启权限注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
// 开启spring security 注解
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource
	private UserDetailsService userDetailsService;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new JwtAuthenticationProvider(userDetailsService));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 禁用 csrf,由于使用的是JWT ，不需要crsf
		http.cors().and().csrf().disable().authorizeRequests()
				// 跨域预检请求
				.antMatchers("/webjars/**", "/**").permitAll()
				// 查看Sql监控
				.antMatchers("/druid/**").permitAll()
				// 首页和登录页面
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				// swagger
				.antMatchers("/swagger-ui.html").permitAll()
				.antMatchers("/swagger-resources/**").permitAll()
				.antMatchers("/v2/api-docs").permitAll()
				.antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
				// 验证码
				.antMatchers("/captchar.jpg**").permitAll()
				// 服务监控
				.antMatchers("/actuator/**").permitAll()
				// 其他所有请求需要身份认证
				.anyRequest().authenticated();

		// 退出登录处理器
		http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
		// token 验证过滤器
		http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);

	}

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

}
