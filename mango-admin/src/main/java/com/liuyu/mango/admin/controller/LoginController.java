package com.liuyu.mango.admin.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.liuyu.mango.admin.model.User;
import com.liuyu.mango.admin.security.JwtAuthenticationToken;
import com.liuyu.mango.admin.service.UserService;
import com.liuyu.mango.admin.utils.PasswordUtils;
import com.liuyu.mango.admin.utils.SecurityUtils;
import com.liuyu.mango.admin.vo.LoginBean;
import com.liuyu.mango.core.http.HttpResult;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
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
	@Resource
	private UserService userService;
	@Resource
	private AuthenticationManager authenticationManager;

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/captcha.jpg")
	public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
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

	@PostMapping("/login")
	public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) {
		String username = loginBean.getAccount();
		String password = loginBean.getPassword();
		String captcha = loginBean.getCaptcha();
		// 从session中获取到token
		Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (kaptcha == null) {
			return HttpResult.error("验证码已经失效");
		}

		if (!captcha.equals(kaptcha)) {
			return HttpResult.error("验证码不正确");
		}

		// 用户信息
		User user = userService.findByName(username);
		if (user == null) {
			return HttpResult.error("账号信息不存在");
		}

		// 密码不正确
		if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
			return HttpResult.error("密码不正确");
		}

		// 账号已锁定
		if (user.getStatus() == 0) {
			return HttpResult.error("账号已锁定，请联系管理员");
		}


		// 系统登录认证
		JwtAuthenticationToken token = SecurityUtils.login(request, username, password, authenticationManager);

		return HttpResult.ok(token);


	}
}

