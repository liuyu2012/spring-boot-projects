package com.liuyu.mango.admin.security;

import com.liuyu.mango.admin.utils.PasswordEncoder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 身份验证提供者
 *
 * @author： yu Liu
 * @date： 2019/12/23 0023 13:33
 * @description： 身份验证提供者
 * @modifiedBy：
 * @version: 1.0
 */
public class JwtAuthenticationProvider extends DaoAuthenticationProvider {

    /**
     * 配置构造方法
     *
     * @param userDetailsService 设置服务类
     */
    public JwtAuthenticationProvider(UserDetailsService userDetailsService) {
        setUserDetailsService(userDetailsService);
    }

    /**
     * 附加身份验证检查
     *
     * @param userDetails         用户新
     * @param authenticationToken 认证token
     * @throws AuthenticationException 异常信息
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authenticationToken) throws AuthenticationException {
        // 没有验证信息
        if (authenticationToken.getCredentials() == null) {
            logger.info("Authentication failed: no credentials provided");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }

        // 获取当前密码
        String presentedPassword = authenticationToken.getCredentials().toString();
        // 获取盐
        String salt = ((JwtUserDetails) userDetails).getSalt();
        // 覆写密码验证逻辑
        if (!new PasswordEncoder(salt).matches(userDetails.getPassword(), presentedPassword)) {
            logger.warn("Authentication failed: password does not match");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }
    }

}
