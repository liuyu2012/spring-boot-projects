package com.liuyu.mango.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author： yu Liu
 * @date： 2019/12/23 0023 9:31
 * @description： 日期时间相关操作
 * @modifiedBy：
 * @version: 1.0
 */
public class DateTimeUtils {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前日期时间
     *
     * @return 当前日期时间
     */
    public static String getDateTime() {
        return getDateTime(new Date());
    }

    /**
     * 标准化日期格式时间
     *
     * @param date 日期
     * @return 标准化日期时间
     */
    public static String getDateTime(Date date) {
        return (new SimpleDateFormat(DATE_FORMAT)).format(date);
    }
}
