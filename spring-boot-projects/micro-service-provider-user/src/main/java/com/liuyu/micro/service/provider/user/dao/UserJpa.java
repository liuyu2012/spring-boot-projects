package com.liuyu.micro.service.provider.user.dao;

import com.liuyu.micro.service.provider.user.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author： yu Liu
 * @date： 2019/12/13 0013 13:54
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public interface UserJpa extends JpaRepository<User,Long> {
}
