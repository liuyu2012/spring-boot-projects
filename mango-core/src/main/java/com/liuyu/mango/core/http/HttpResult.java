package com.liuyu.mango.core.http;

/**
 * @author： yu Liu
 * @date： 2019/12/20 0020 10:53
 * @description： HTTP 结果封装
 * @modifiedBy：
 * @version: 1.0
 */
public class HttpResult {

    private int code = 200;
    private String msg;
    private Object data;

    public static HttpResult error() {
        return error(HtpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static HttpResult error(String msg) {
        return error(HtpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    private static HttpResult error(int code, String msg) {
        HttpResult re = new HttpResult();
        re.setCode(code);
        re.setMsg(msg);
        return re;
    }

    public static HttpResult ok(Object data) {
        HttpResult httpResult = new HttpResult();
        httpResult.setData(data);
        return httpResult;
    }

    public static HttpResult ok() {
        return new HttpResult();
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
