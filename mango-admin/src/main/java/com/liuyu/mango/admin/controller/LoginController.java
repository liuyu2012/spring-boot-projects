package com.liuyu.mango.admin.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录控制器
 *
 * @author： yu Liu
 * @date： 2019/12/23 0023 11:04
 * @description： 登录控制器
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
public class LoginController {

    @Resource
    private Producer producer;

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store,no-cache");
        response.setContentType("image/jpeg");

        // 生成验证码
        String text = producer.createText();
        logger.info("生成的验证码：{}", text);

        // 生成图片验证码
        BufferedImage image = producer.createImage(text);

        // 保存图片到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);

        // 关闭文件流
        IOUtils.closeQuietly(out);
    }
}

