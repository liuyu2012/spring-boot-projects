package com.liuyu.mango.common.utils;


import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author： yu Liu
 * @date： 2019/12/23 0023 8:44
 * @description： POI 相关操作
 * @modifiedBy：
 * @version: 1.0
 */
public class PoiUtils {

    private static Logger logger = LoggerFactory.getLogger(PoiUtils.class);

    /**
     * 生成 Excel 文件
     *
     * @param workbook 工作簿
     * @param fileName 文件名称
     * @return 文件
     */
    public static File createExcelFile(Workbook workbook, String fileName) {

        File file = null;
        OutputStream stream = null;
        try {
            file = File.createTempFile(fileName, ".xlsx");
            stream = new FileOutputStream(file.getAbsoluteFile());

            workbook.write(stream);
        } catch (FileNotFoundException e) {
            logger.info("未找到文件异常：", e);

        } catch (IOException e) {
            logger.info("IO接口异常：", e);
        } finally {
            IOUtils.closeQuietly(workbook);
            IOUtils.closeQuietly(stream);
        }

        return file;
    }
}
