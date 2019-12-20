package com.liuyu.mango.core.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuyu.mango.common.utils.ReflectionUtils;

import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/19 0019 18:45
 * @description： 分页查询助手
 * @modifiedBy：
 * @version: 1.0
 */
public class MybatisPageHelper {

    private static final String findPage = "findPage";


    /**
     * @param pageRequest 分页请求
     * @param mapper      Dao 对象，Mybatis 的 mapper
     * @return 分页结果
     */
    public static PageResult findPage(PageRequest pageRequest, Object mapper) {
        return findPage(pageRequest, mapper, findPage);
    }

    /**
     * 调用分页插件进行分页查询
     *
     * @param pageRequest     请求
     * @param mapper          请求对象
     * @param queryMethodName 请求方法
     * @param args            请求参数列表
     * @return 请求分页结果
     */
    @SuppressWarnings({"unchecked","rawtypes"})
    public static PageResult findPage(PageRequest pageRequest, Object mapper, String queryMethodName, Object... args) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);

        // 利用反射调用查询方法
        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
        return getPageResult(new PageInfo((List) result));
    }

    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageInfo    请求参数
     * @return 返回结果
     */
    private static PageResult getPageResult( PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPage(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;

    }
}
