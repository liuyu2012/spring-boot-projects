package com.liuyu.mango.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author： yu Liu
 * @date： 2019/12/30 0030 10:42
 * @description： 数据备份还原
 * @modifiedBy：
 * @version: 1.0
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.liuyu.mango"})
public class MangoBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangoBackupApplication.class, args);
	}
}
