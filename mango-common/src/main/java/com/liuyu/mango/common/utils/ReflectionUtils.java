package com.liuyu.mango.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author： yu Liu
 * @date： 2019/12/20 0020 9:44
 * @description： 反射相关辅助方法
 * @modifiedBy：
 * @version: 1.0
 */
public class ReflectionUtils {

    /**
     * 方法调用
     * @param object 参数对象
     * @param method 方法名称
     * @param args 参数列表
     * @return 结果对象
     */
    public static Object invoke(Object object, String method, Object... args) {

        Object result = null;
        Class<? extends Object> aClass = object.getClass();
        Method queryMethod = getMethod(aClass, method, args);
        // 找到该类的相关方法
        if (queryMethod != null) {

            try {
                result = queryMethod.invoke(object, args);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new NoSuchMethodException(aClass.getName() + " 类中没有找到 " + method + " 方法");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 根据方法名和参数名查找方法
     *
     * @param aClass     查找类
     * @param methodName 方法名称
     * @param args       参数结合
     * @return 方法
     */
    private static Method getMethod(Class<? extends Object> aClass, String methodName, Object[] args) {
        // 获取所有方法
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {

            // 方法名称相同 遍历方法数据
            if (method.getName().equals(methodName)) {

                Class<?>[] parameterTypes = method.getParameterTypes();
                // 参数类型个数 == 参数个数
                if (parameterTypes.length == args.length) {

                    boolean isSameMethod = true;
                    // 判断每一个参数类型和 类型是否一致，如果不一致，表明不是该方法
                    for (int i = 0; i < args.length; i++) {

                        // 参数类型不匹配，退出该循环
                        if (parameterTypes[i] != args[i].getClass()) {
                            isSameMethod = false;
                            break;
                        }
                    }

                    // 找到该方法，直接返回
                    if (isSameMethod) {
                        return method;
                    }
                }
            }
        }

        return null;
    }

}
