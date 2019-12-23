package com.liuyu.mango.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author： yu Liu
 * @date： 2019/12/23 0023 9:08
 * @description： 文件相关操作
 * @modifiedBy：
 * @version: 1.0
 */
public class FileUtils {
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 下载文件
     *
     * @param response    请求响应
     * @param file        要下载文件
     * @param newFileName 要生成的文件名称
     */
    public static void downloadFile(HttpServletResponse response, File file, String newFileName) {

        // 设置请求响应头信息
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(newFileName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));

        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

            InputStream is = new FileInputStream(file.getAbsolutePath());

            BufferedInputStream bis = new BufferedInputStream(is);

            int length = 0;

            byte[] temp = new byte[1024 * 10];

            while ((length = bis.read(temp)) != -1) {
                bos.write(temp);
            }

            bos.flush();
            bis.close();
            bos.close();
            is.close();
        } catch (IOException e) {
            logger.info("下载文件异常信息：", e);
        }
    }

}
