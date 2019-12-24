package com.liuyu.mango.admin.utils;

import java.util.UUID;

/**
 * 密码工具
 *
 * @author： yu Liu
 * @date： 2019/12/24 0024 16:18
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class PasswordUtils {

	/**
	 * 验证密码是否匹配
	 *
	 * @param salt    盐
	 * @param rawPass 明文
	 * @param encPass 密文
	 * @return 匹配程度
	 */
	public static boolean matches(String salt, String rawPass, String encPass) {
		return new PasswordEncoder(salt).matches(encPass, rawPass);
	}


	/**
	 * 明文密码加密
	 *
	 * @param rawPass 明文
	 * @param salt    盐
	 * @return 密文
	 */
	public static String encode(String rawPass, String salt) {
		return new PasswordEncoder(salt).encode(rawPass);
	}

	/**
	 * 获取加密盐
	 *
	 * @return 返回加密盐
	 */
	public static String getSalt() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
	}

}
