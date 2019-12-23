package com.liuyu.mango.admin.security;

import com.liuyu.mango.admin.model.User;
import com.liuyu.mango.admin.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author： yu Liu
 * @date： 2019/12/23 0023 16:18
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        // 标准的接口对比，决定是否调用该接口
        Set<String> permissions = userService.findPermissions(user.getName());

        List<GrantedAuthorityImpl> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(user.getName(), user.getPassword());
    }
}
