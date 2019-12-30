package com.liuyu.mango.backup.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author： yu Liu
 * @date： 2019/12/30 0030 11:14
 * @description： 数据库备份恢复工具类
 * @modifiedBy：
 * @version: 1.0
 */
public class MySqlBackupRestoreUtils {
	private static Logger logger = LoggerFactory.getLogger(MySqlBackupRestoreUtils.class);

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
	public static boolean backup(String host, String userName, String password,
	                             String backupFolderPath, String fileName,
	                             String database) throws Exception {
		// 创建备份文件
		File backupFolderFile = new File(backupFolderPath);
		if (!backupFolderFile.exists()) {
			// 目录如果不存在，则创建相应目录
			boolean mkdirs = backupFolderFile.mkdirs();
			logger.info("文件目录创建 结果：{}", mkdirs);
		}

		// 文件夹路径不以分隔符或者/结尾，则需要拼接路径
		if (!backupFolderPath.endsWith(File.separator) && !backupFolderPath.endsWith("/")) {
			backupFolderPath += File.separator;
		}

		// 文件路径
		String backupFilePath = backupFolderPath + fileName;
		// 拼接命令行执行的命令
		StringBuilder builder = new StringBuilder();
		builder.append("mysqldump --opt")
				.append(" --add-drop-database")
				.append(" --add-drop-database")

				.append(" -h")
				.append(host)
				.append(" -u")
				.append(userName)
				.append(" -p")
				.append(password)

				.append(" --result-file=")
				.append(backupFilePath)
				.append(" --default-character=utf-8 ")
				.append(database);

		// 调用外部执行 exe 文件的 java API
		Process process = Runtime.getRuntime().exec(getCommand(builder.toString()));
		if (process.waitFor() == 0) {
			// 0 表示线程正常终止
			logger.info("数据已经备份到 {} 文件中", backupFilePath);
			return true;
		}
		return false;
	}

	/**
	 * 执行命令行
	 *
	 * @param command 命令行
	 * @return 执行结果
	 */
	private static String[] getCommand(String command) {
		String os = System.getProperty("os.name");
		String shell = "/bin/bash";
		String c = "-c";
		if (os.toLowerCase().startsWith("win")) {
			shell = "cmd";
			c = "/c";
		}
		String[] cmd = {shell, command};
		return cmd;
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
	public static boolean restore(String restoreFilePath, String host, String userName,
	                              String password, String database) throws Exception {

		File restoreFile = new File(restoreFilePath);

		// 如果是文件夹
		if (restoreFile.isDirectory()) {

			// 遍历文件夹，然后找到文件存在，且文件后缀是以.sql的，直接退出，并获取文件的全部路径
			for (File file : Objects.requireNonNull(restoreFile.listFiles())) {
				if (file.exists() && file.getPath().endsWith(".sql")) {
					// 获取文件路径，给存储变量路径
					restoreFilePath = file.getAbsolutePath();
					break;
				}
			}
		}

		// 拼接执行命令行，操作
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("mysql -h")
				.append(host)
				.append(" -p")
				.append(password)
				.append(" ")
				.append("database")
				.append("<")
				.append(restoreFilePath);

		try {
			Process process = Runtime.getRuntime().exec(getCommand(stringBuilder.toString()));
			if (process.waitFor() == 0) {
				logger.info("数据已经从 {} 导入到数据库中", restoreFilePath);
				return true;
			}
		} catch (IOException e) {
			logger.error("执行数据恢复操作发生异常，异常信息：", e);
			return false;
		}

		return false;
	}
}
