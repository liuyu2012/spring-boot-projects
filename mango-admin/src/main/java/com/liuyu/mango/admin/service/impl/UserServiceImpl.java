package com.liuyu.mango.admin.service.impl;

import com.google.common.collect.Lists;
import com.liuyu.mango.admin.mapper.UserMapper;
import com.liuyu.mango.admin.model.User;
import com.liuyu.mango.admin.service.UserService;
import com.liuyu.mango.common.utils.DateTimeUtils;
import com.liuyu.mango.common.utils.PoiUtils;
import com.liuyu.mango.core.page.MybatisPageHelper;
import com.liuyu.mango.core.page.PageRequest;
import com.liuyu.mango.core.page.PageResult;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @author： yu Liu
 * @date： 2019/12/15 0015 23:05
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findPage() {
        return userMapper.findPage();
    }

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }


    @Override
    public int save(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int delete(User record) {
        return userMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<User> records) {
        for (User record : records) {
            userMapper.deleteByPrimaryKey(record.getId());
        }
        return 1;
    }

    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, userMapper);
    }

    @Override
    public File createUserExcelFile(PageRequest pageRequest) {
        PageResult pageResult = findPage(pageRequest);
        return createUserExcelFile(pageResult.getContent());
    }

    private static File createUserExcelFile(List<?> records) {
        if (records == null) {
            records = Lists.newArrayList();
        }

        // 创建工作空间
        Workbook workbook = new XSSFWorkbook();
        // 创建工作表
        Sheet sheet = workbook.createSheet();
        // 创建第一行
        Row row0 = sheet.createRow(0);
        int columnIndex = 0;

        // 设置表头
        row0.createCell(columnIndex).setCellValue("No");
        row0.createCell(++columnIndex).setCellValue("ID");
        row0.createCell(++columnIndex).setCellValue("用户名");
        row0.createCell(++columnIndex).setCellValue("昵称");
        row0.createCell(++columnIndex).setCellValue("机构");
        row0.createCell(++columnIndex).setCellValue("角色");
        row0.createCell(++columnIndex).setCellValue("邮箱");
        row0.createCell(++columnIndex).setCellValue("手机号");
        row0.createCell(++columnIndex).setCellValue("状态");
        row0.createCell(++columnIndex).setCellValue("头像");
        row0.createCell(++columnIndex).setCellValue("创建人");
        row0.createCell(++columnIndex).setCellValue("创建时间");
        row0.createCell(++columnIndex).setCellValue("最后更新人");
        row0.createCell(++columnIndex).setCellValue("最后更新时间");


        for (int i = 0; i < records.size(); i++) {
            //  获取数据
            User user = (User) records.get(i);
            Row row = sheet.createRow(i + 1);
            // 循环创建单元格
            for (int j = 0; j < columnIndex; j++) {
                row.createCell(j);
            }

            columnIndex = 0;
            // 给单元格赋值
            row.getCell(columnIndex).setCellValue(i + 1);
            row.getCell(++columnIndex).setCellValue(user.getId());
            row.getCell(++columnIndex).setCellValue(user.getName());
            row.getCell(++columnIndex).setCellValue(user.getNickName());
            row.getCell(++columnIndex).setCellValue(user.getDeptName());
            row.getCell(++columnIndex).setCellValue(user.getRoleNames());
            row.getCell(++columnIndex).setCellValue(user.getEmail());
            row.getCell(++columnIndex).setCellValue(user.getStatus());
            row.getCell(++columnIndex).setCellValue(user.getAvatar());
            row.getCell(++columnIndex).setCellValue(user.getCreateBy());
            row.getCell(++columnIndex).setCellValue(DateTimeUtils.getDateTime(user.getCreateTime()));
            row.getCell(++columnIndex).setCellValue(user.getLastUpdateBy());
            row.getCell(++columnIndex).setCellValue(DateTimeUtils.getDateTime(user.getLastUpdateTime()));
        }

        return PoiUtils.createExcelFile(workbook, "download_user");
    }
}
