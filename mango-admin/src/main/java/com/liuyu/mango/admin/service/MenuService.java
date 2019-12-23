package com.liuyu.mango.admin.service;

import com.liuyu.mango.admin.model.Menu;
import com.liuyu.mango.core.service.CurdService;

import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/23 0023 16:34
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public interface MenuService extends CurdService<Menu> {

    /**
     * 根据用户ID，查询菜单树
     *
     * @param username 用户名
     * @param menuType 菜单级别
     * @return 菜单列表
     */
    List<Menu> findTree(String username, int menuType);

    /**
     * 根据用户名查询菜单列表
     *
     * @param username 用户名
     * @return 菜单列表
     */
    List<Menu> findByUser(String username);
}
