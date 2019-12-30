package com.liuyu.mango.backup.service;

/**
 * @author： yu Liu
 * @date： 2019/12/30 0030 11:04
 * @description： 数据备份还原服务接口
 * @modifiedBy：
 * @version: 1.0
 */
public interface MysqlBackupService {


	/**
	 * 数据库备份
	 *
	 * @param host             地址
	 * @param userName         用户名
	 * @param password         密码
	 * @param backupFolderPath 备份路径
	 * @param fileName         备份文件名称
	 * @param database         需要备份的数据库
	 * @return 备份结果
	 * @throws Exception 异常信息
	 */
	boolean backup(String host, String userName, String password, String backupFolderPath, String fileName, String database) throws Exception;


	/**
	 * 恢复数据库
	 *
	 * @param restoreFilePath 数据库备份的脚本路径
	 * @param host            IP地址
	 * @param userName        数据库名称
	 * @param password        密码
	 * @param database        数据库
	 * @return 恢复结果
	 * @throws Exception 异常信息
	 */
	boolean restore(String restoreFilePath, String host, String userName, String password, String database) throws Exception;

}
