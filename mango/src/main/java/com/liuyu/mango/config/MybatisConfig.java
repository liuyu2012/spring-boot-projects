package com.liuyu.mango.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author： yu Liu
 * @date： 2019/12/15 0015 21:41
 * @description： Mybatis 配置
 * @modifiedBy：
 * @version: 1.0
 */
@Configuration
@MapperScan("com.liuyu.mango.**.dao")
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        // 配置数据源
        sessionFactoryBean.setDataSource(dataSource);
        // 设置 Bean 扫描路径
        sessionFactoryBean.setTypeAliasesPackage("com.liuyu.mango.**.model");

        // 路径匹配资源正则解析器
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 扫描映射文件
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:**/sqlmap/*.xml"));
        return sessionFactoryBean.getObject();
    }
}
