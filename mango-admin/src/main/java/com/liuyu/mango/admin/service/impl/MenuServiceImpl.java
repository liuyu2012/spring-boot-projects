package com.liuyu.mango.admin.service.impl;

import com.google.common.collect.Lists;
import com.liuyu.mango.admin.mapper.MenuMapper;
import com.liuyu.mango.admin.model.Menu;
import com.liuyu.mango.admin.service.MenuService;
import com.liuyu.mango.core.page.PageRequest;
import com.liuyu.mango.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/23 0023 16:34
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * 根据用户ID，查询菜单树
     *
     * @param username 用户名
     * @param menuType 菜单级别
     * @return 菜单列表
     */
    @Override
    public List<Menu> findTree(String username, int menuType) {

        List<Menu> menus = Lists.newArrayList();

        List<Menu> menusList = findByUser(username);
        for (Menu menu : menusList) {
            if (menu.getParentId() == null || menu.getParentId() == 0) {
                menu.setLevel(0);
                if (!exists(menus, menu)) {
                    menus.add(menu);
                }
            }
        }
        menus.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(menus, menusList, menuType);
        return menusList;
    }

    private void findChildren(List<Menu> menus, List<Menu> menusList, int menuType) {
        for (Menu menu : menus) {
            List<Menu> children = Lists.newArrayList();
            for (Menu menu1 : menusList) {
                if (menuType == 1 && menu1.getType() == 2) {
                    continue;
                }

                if (menu.getId() != null && menu.getId().equals(menu1.getParentId())) {
                    menu1.setParentName(menu.getName());
                    menu1.setLevel(menu.getLevel() + 1);
                    if (!exists(children, menu1)) {
                        children.add(menu1);
                    }
                }
            }

            menu.setChildren(children);
            children.sort((o1, o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
            findChildren(children, menusList, menuType);
        }

    }

    private boolean exists(List<Menu> menus, Menu menu) {
        boolean exist = false;

        for (Menu menu1 : menus) {
            if (menu1.getId().equals(menu.getId())) {
                exist = true;
            }
        }
        return exist;
    }

    /**
     * 根据用户名查询菜单列表
     *
     * @param username 用户名
     * @return 菜单列表
     */
    @Override
    public List<Menu> findByUser(String username) {
        return null;
    }

    /**
     * 保存操作
     *
     * @param record 记录
     * @return 返回
     */
    @Override
    public int save(Menu record) {
        return 0;
    }

    /**
     * 删除操作
     *
     * @param record 记录
     * @return 返回
     */
    @Override
    public int delete(Menu record) {
        return 0;
    }

    /**
     * 批量删除操作
     *
     * @param records 记录
     * @return 返回
     */
    @Override
    public int delete(List<Menu> records) {
        return 0;
    }

    /**
     * 根据Id 查询
     *
     * @param id Id
     * @return 返回
     */
    @Override
    public Menu findById(Long id) {
        return null;
    }

    /**
     * 分页查询
     *
     * @param pageRequest 统一分页查询请求
     * @return 统一分页查询结果
     */
    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }
}
