package com.liuyu.mango.admin.utils;

import com.google.common.collect.Maps;
import com.liuyu.mango.admin.security.GrantedAuthorityImpl;
import com.liuyu.mango.admin.security.JwtAuthenticationToken;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 根据请求令牌获取登录认证信息
 *
 * @author： yu Liu
 * @date： 2019/12/23 0023 14:43
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class JwtTokenUtils {

	/**
	 * 权限列表
	 */
	private static final String AUTHORITIES = "authorities";
	/**
	 * 用户名称
	 */
	private static final String USERNAME = Claims.SUBJECT;
	/**
	 * 密钥
	 */
	private static final String SECRET = "abcdefgh";
	/**
	 * 创建时间
	 */
	private static final String CREATED = "created";
	/**
	 * 有效期12小时
	 */
	private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;


	private static Logger logger = LoggerFactory.getLogger(JwtTokenUtils.class);

	/**
	 * 从token中获取认证信息
	 *
	 * @param request 请求信息
	 * @return 认证信息
	 */
	public static Authentication getAuthenticationFromToken(HttpServletRequest request) {

		Authentication authentication = null;
		// 获取请求携带的令牌
		String token = getToken(request);

		if (token != null) {
			// 请求令牌不能为空
			if (SecurityUtils.getAuthentication() == null) {

				// 上下文信息为空
				Claims claims = getClaimsFromToken(token);
				if (claims == null) {
					return null;
				}

				// 用户名为空
				String username = claims.getSubject();
				if (username == null) {
					return null;
				}

				// token 超时
				if (isTokenExpired(token)) {
					return null;
				}

				Object authors = claims.get(AUTHORITIES);
				List<GrantedAuthority> authorities = new ArrayList<>();

				if (authors instanceof List) {
					for (Object author : (List) authors) {
						authorities.add(new GrantedAuthorityImpl((String) ((Map) author).get("authority")));
					}
				}

				authentication = new JwtAuthenticationToken(username, null, authorities, token);

			} else {
				if (validateToken(token, SecurityUtils.getUsername())) {
					// 直接返回当前登录认证信息
					authentication = SecurityUtils.getAuthentication();
				}
			}

		}

		return authentication;
	}

	/**
	 * 验证token有效性
	 *
	 * @param token    token
	 * @param username 登录信息
	 * @return 验证结果
	 */
	private static boolean validateToken(String token, String username) {
		String userName = getUsernameFromToken(token);
		if (userName != null) {
			return userName.equals(username) && !isTokenExpired(token);
		}
		return false;
	}

	/**
	 * 从token中获取用户名称
	 *
	 * @param token token
	 * @return 用户名
	 */
	private static String getUsernameFromToken(String token) {

		String username;
		try {
			Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	/**
	 * 判断token是否已经过时
	 *
	 * @param token token
	 * @return token是否过时
	 */
	private static boolean isTokenExpired(String token) {
		try {
			Claims claims = getClaimsFromToken(token);
			Date expiration = claims.getExpiration();
			return expiration.before(new Date());
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 从令牌中获取数据声明
	 *
	 * @param token 令牌
	 * @return 数据声明
	 */
	private static Claims getClaimsFromToken(String token) {
		Claims claims = null;
		try {
			claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			logger.warn("从令牌中获取数据声明发生异常，异常信息：", e);
		}
		return claims;
	}

	/**
	 * 获取请求token
	 *
	 * @param request 请求
	 * @return token
	 */
	public static String getToken(HttpServletRequest request) {
		String token = request.getHeader("Authentication");
		String tokenHead = "Bearer";

		if (token == null) {
			token = request.getHeader("token");
		} else if (token.contains(tokenHead)) {
			token = token.substring(tokenHead.length());
		}

		if ("".equals(token)) {
			token = null;
		}

		return token;
	}

	/**
	 * 生成token
	 *
	 * @param authentication 认证机构
	 * @return token
	 */
	public static String generateToken(Authentication authentication) {
		Map<String, Object> claims = Maps.newHashMap();

		claims.put(USERNAME, SecurityUtils.getUsername(authentication));
		claims.put(CREATED, new Date());
		claims.put(AUTHORITIES, authentication.getAuthorities());
		return generateToken(claims);
	}

	/**
	 * 生成token
	 *
	 * @param claims 列表
	 * @return token
	 */
	private static String generateToken(Map<String, Object> claims) {
		Date expirationDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
		return Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, SECRET).compact();
	}
}
