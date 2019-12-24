package com.liuyu.mango.admin.utils;

import com.liuyu.mango.admin.security.JwtAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取令牌进行认证
 *
 * @author： yu Liu
 * @date： 2019/12/23 0023 14:40
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class SecurityUtils {


	public static void checkAuthentication(HttpServletRequest request) {
		// 获取令牌，并根据令牌获取登录认证信息
		Authentication authentication = JwtTokenUtils.getAuthenticationFromToken(request);
		// 设置登录认证信息到上下文
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	/**
	 * 获取当前登录信息
	 *
	 * @return 认证信息
	 */
	public static Authentication getAuthentication() {

		// 如果上下文为 null ，直接返回
		if (SecurityContextHolder.getContext() == null) {
			return null;
		}

		// 直接返回上下文的认证信息
		return SecurityContextHolder.getContext().getAuthentication();

	}

	/**
	 * 获取用户名
	 *
	 * @return 用户名
	 */
	public static String getUsername() {
		String username = null;
		Authentication authentication = getAuthentication();
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			if (principal != null && principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			}
		}
		return username;
	}

	/**
	 * 获取用户名
	 *
	 * @return 用户名
	 */
	public static String getUsername(Authentication authentication) {
		String username = null;
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			if (principal != null && principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			}
		}
		return username;
	}

	/**
	 * 系统登录认证
	 *
	 * @param request               请求
	 * @param username              用户名称
	 * @param password              密码
	 * @param authenticationManager 认证工具
	 * @return token
	 */
	public static JwtAuthenticationToken login(HttpServletRequest request, String username, String password, AuthenticationManager authenticationManager) {
		JwtAuthenticationToken token = new JwtAuthenticationToken(username, password);
		token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		// 执行登录认证过程
		Authentication authentication = authenticationManager.authenticate(token);
		// 认证成功，存储认证信息到上下文
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// 生成令牌并返回给客户端
		token.setToken(JwtTokenUtils.generateToken(authentication));
		return token;
	}
}
