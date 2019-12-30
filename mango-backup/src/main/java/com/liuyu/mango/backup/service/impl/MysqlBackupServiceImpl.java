package com.liuyu.mango.backup.service.impl;

import com.liuyu.mango.backup.service.MysqlBackupService;
import com.liuyu.mango.backup.utils.MySqlBackupRestoreUtils;
import org.springframework.stereotype.Service;

/**
 * @author： yu Liu
 * @date： 2019/12/30 0030 11:10
 * @description： 数据库备份恢复实现类
 * @modifiedBy：
 * @version: 1.0
 */
@Service
public class MysqlBackupServiceImpl implements MysqlBackupService {
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
	@Override
	public boolean backup(String host, String userName, String password, String backupFolderPath, String fileName, String database) throws Exception {
		return MySqlBackupRestoreUtils.backup(host,userName,password,backupFolderPath,fileName,database);
	}

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
	@Override
	public boolean restore(String restoreFilePath, String host, String userName, String password, String database) throws Exception {
		return MySqlBackupRestoreUtils.restore(restoreFilePath,host,userName,password,database);
	}
}
