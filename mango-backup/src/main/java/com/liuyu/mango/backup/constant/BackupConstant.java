package com.liuyu.mango.backup.constant;

import java.io.File;

/**
 * @author： yu Liu
 * @date： 2019/12/30 0030 15:14
 * @description： 数据备份常量类
 * @modifiedBy：
 * @version: 1.0
 */
public interface BackupConstant {


	/** 备份目录名称 */
	public static final String BACKUP_FOLDER_NAME = "_mango_backup";
	/** 备份目录 */
	public static final String BACKUP_FOLDER = System.getProperty("user.home") + File.separator + BACKUP_FOLDER_NAME + File.separator;
	/** 还原目录，默认就是备份目录 */
	public static final String RESTORE_FOLDER = BACKUP_FOLDER;
	/** 日期格式 */
	public static final String DATE_FORMAT = "yyyy-MM-dd_HHmmss";
	/** SQL拓展名 */
	public static final String SQL_EXT = ".sql";
	/** 默认备份文件名 */
	public static final String BACKUP_FILE_NAME = "mango" + SQL_EXT;
	/** 默认备份还原目录名称 */
	public static final String DEFAULT_BACKUP_NAME = "backup";
	/** 默认备份还原文件 */
	public static final String DEFAULT_RESTORE_FILE = BACKUP_FOLDER + DEFAULT_BACKUP_NAME + File.separator + BACKUP_FILE_NAME;

}
