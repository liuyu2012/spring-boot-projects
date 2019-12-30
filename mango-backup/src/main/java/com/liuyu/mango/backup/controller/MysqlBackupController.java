package com.liuyu.mango.backup.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.liuyu.mango.backup.config.BackupDataSourceProperties;
import com.liuyu.mango.backup.constant.BackupConstant;
import com.liuyu.mango.backup.service.MysqlBackupService;
import com.liuyu.mango.common.http.HttpResult;
import com.liuyu.mango.common.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author： yu Liu
 * @date： 2019/12/30 0030 15:12
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
public class MysqlBackupController {

	@Resource
	private MysqlBackupService mysqlBackupService;

	@Resource
	private BackupDataSourceProperties properties;

	private static Logger logger = LoggerFactory.getLogger(MysqlBackupController.class);

	/**
	 * 数据备份
	 *
	 * @return 数据备份结果
	 */
	@GetMapping("/backup")
	public HttpResult backup() {
		// 备份文件夹名称
		String backupFolderName = BackupConstant.DEFAULT_BACKUP_NAME + "_" + (new SimpleDateFormat(BackupConstant.DATE_FORMAT)).format(new Date());
		return backup(backupFolderName);
	}

	/**
	 * 数据备份操作
	 *
	 * @param backupFolderName 备份文件夹名称
	 * @return 备份结果
	 */
	private HttpResult backup(String backupFolderName) {

		String host = properties.getHost();
		String userName = properties.getUserName();
		String password = properties.getPassword();
		String database = properties.getDatabase();
		// 备份文件夹路径
		String backupFolderPath = BackupConstant.BACKUP_FOLDER + backupFolderName + File.separator;

		// 备份文件名称
		String fileName = BackupConstant.BACKUP_FILE_NAME;

		try {
			boolean success = mysqlBackupService.backup(host, userName, password, backupFolderPath, fileName, database);
			if (!success) {
				logger.warn("数据备份失败");
				HttpResult.error("数据备份失败");
			}
		} catch (Exception e) {
			logger.error("数据恢复发生异常，异常信息：", e);
			HttpResult.error("数据库备份失败");
		}
		return HttpResult.ok();
	}

	/**
	 * 数据恢复
	 *
	 * @param name 要恢复的数据文件名称
	 * @return 恢复结果
	 * @throws IOException 异常信息
	 */
	@GetMapping("/restore")
	public HttpResult restore(@RequestParam String name) throws IOException {
		String host = properties.getHost();
		String password = properties.getPassword();
		String userName = properties.getUserName();
		String database = properties.getDatabase();

		// 数据恢复路径
		String restoreFilePath = BackupConstant.DEFAULT_RESTORE_FILE + name;

		try {
			boolean restore = mysqlBackupService.restore(restoreFilePath, host, userName, password, database);
			if (!restore) {
				logger.info("数据恢复失败");
				return HttpResult.error("数据库恢复失败");
			}
		} catch (Exception e) {
			logger.info("数据恢复异常：", e);
			return HttpResult.error(500, e.getMessage());
		}
		return HttpResult.ok();
	}


	@GetMapping("/findRecords")
	public HttpResult findBackupRecords() {
		// 如果文件不存在
		if (!new File(BackupConstant.DEFAULT_RESTORE_FILE).exists()) {
			// 初始化默认备份文件
			backup(BackupConstant.DEFAULT_BACKUP_NAME);
		}

		List<Map<String, String>> backupRecords = Lists.newArrayList();
		// 恢复文件夹文件
		File restoreFolderFile = new File(BackupConstant.RESTORE_FOLDER);
		// 文件夹存在
		if (restoreFolderFile.exists()) {
			// 循环遍历文件，然后将文件名称放到map中
			for (File file : Objects.requireNonNull(restoreFolderFile.listFiles())) {
				Map<String, String> backup = Maps.newHashMap();
				backup.put("name", file.getName());
				backup.put("title", file.getName());

				// 默认名称
				if (BackupConstant.DEFAULT_BACKUP_NAME.equalsIgnoreCase(file.getName())) {
					backup.put("title", "系统默认备份");
				}
				// 将记录添加到集合中
				backupRecords.add(backup);
			}
		}

		// 排序，默认备份最前，然后按照时间戳排序，新备份在最前面
		backupRecords.sort(((o1, o2) -> BackupConstant.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o1.get("name")) ? -1
				: BackupConstant.DEFAULT_BACKUP_NAME.equalsIgnoreCase(o2.get("name")) ? 1 : o2.get("name").compareTo(o1.get("name"))));

		return HttpResult.ok(backupRecords);
	}

	/**
	 * 删除数据库
	 *
	 * @param name 要删除的数据库
	 * @return 删除结果
	 */
	@GetMapping("/delete")
	public HttpResult deleteBackupRecord(@RequestParam String name) {

		// 是否是系统默认备份
		if (BackupConstant.DEFAULT_BACKUP_NAME.equals(name)) {
			return HttpResult.error("系统默认备份无法删除");
		}

		String restoreFilePath = BackupConstant.BACKUP_FOLDER + name;
		try {
			FileUtils.deleteFile(new File(restoreFilePath));
		} catch (Exception e) {
			logger.error("删除文件发生异常", e);
			return HttpResult.error(500, e.getMessage());
		}
		return HttpResult.ok();
	}
}
