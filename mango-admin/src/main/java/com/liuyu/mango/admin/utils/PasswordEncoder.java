package com.liuyu.mango.admin.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 密码加密
 *
 * @author： yu Liu
 * @date： 2019/12/23 0023 13:56
 * @description： 密码加密
 * @modifiedBy：
 * @version: 1.0
 */
public class PasswordEncoder {

    private static Logger logger = LoggerFactory.getLogger(PasswordEncoder.class);
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f"};
    private static final String MD5 = "MD5";

    private Object salt;
    private String algorithm;

    public PasswordEncoder(Object salt) {
        this(salt, MD5);
    }

    public PasswordEncoder(Object salt, String algorithm) {
        this.salt = salt;
        this.algorithm = algorithm;
    }


    /**
     * 密码加密
     *
     * @param rawsPass 原始密码
     * @return 加密后的密码
     */
    public String encode(String rawsPass) {

        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            result = byteArrayToHexString(md.digest(mergePasswordAndSalt(rawsPass).getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            logger.warn("加密发生异常：", e);
        }
        return result;

    }

    /**
     * 转换字节数组为16进制字符串
     *
     * @param b 字节数组
     * @return 16进制字符串
     */
    private String byteArrayToHexString(byte[] b) {

        StringBuilder resultSb = new StringBuilder();
        for (byte value : b) {
            resultSb.append(byteToHexString(value));
        }

        return resultSb.toString();
    }

    /**
     * 将字节转换为16进制
     *
     * @param b 字节
     * @return 16进制
     */
    private String byteToHexString(byte b) {

        int n = b;
        if (n < 0) {
            n = 256 + n;
        }

        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 合并密码和盐
     *
     * @param rawsPass 原始密码
     * @return 合并合并后的密码和盐
     */
    private String mergePasswordAndSalt(String rawsPass) {
        return null;
    }

    /**
     * 密码匹配
     *
     * @param password          密文
     * @param presentedPassword 明文
     * @return 匹配结果
     */
    public boolean matches(String password, String presentedPassword) {
        String pass1 = "" + password;
        String pass2 = encode(presentedPassword);
        return pass1.equals(pass2);
    }
}
