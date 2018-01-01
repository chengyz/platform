package com.platform.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * app管理
 * @author chengyz
 *
 */
@Table(tableName="app_info")
public class AppInfo {
	
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36,isNotNull=true,comment="appUUID,全球唯一标识")
	private String appUUID;
	
	@TableField(fieldSize=30,comment="app名称：如paotui")
	private String appName;
	
	@TableField(fieldSize=30,comment="文件名")
	private String fileName;
	
	@TableField(fieldSize=20,comment="app版本号：如1.0.0")
	private String appVersion;
	
	@TableField(fieldSize=8000,comment="app更新日志")
	private String updateLog;
	
	@TableField(fieldSize=100,comment="外网app下载地址:下载到手机上")
	private String outsideDownloadAddress;
	
	@TableField(fieldSize=100,comment="直接下载到本地")
	private String directDownloadAddress;
	
	@TableField(fieldSize=10,comment="app类型:android  ios  windows")
	private String appType;
	
	@TableField(fieldSize=2,comment="ios审核状态：1是审核通过，2是审核中")
	private String iosAuditStatus;
	
	@TableField(fieldSize=20,comment="ios正在审核的版本")
	private String iosAuditVersion;
	
	@TableField(fieldSize=20,comment="更新时间")
	private String updateTime;
	
	@TableField(fieldSize=20,comment="提交者用户名")
	private String userName;
	
	@TableField(fieldSize=36,comment="提交者UUID")
	private String userUUID;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppUUID() {
		return appUUID;
	}

	public void setAppUUID(String appUUID) {
		this.appUUID = appUUID;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getUpdateLog() {
		return updateLog;
	}

	public void setUpdateLog(String updateLog) {
		this.updateLog = updateLog;
	}

	public String getOutsideDownloadAddress() {
		return outsideDownloadAddress;
	}

	public void setOutsideDownloadAddress(String outsideDownloadAddress) {
		this.outsideDownloadAddress = outsideDownloadAddress;
	}

	public String getDirectDownloadAddress() {
		return directDownloadAddress;
	}

	public void setDirectDownloadAddress(String directDownloadAddress) {
		this.directDownloadAddress = directDownloadAddress;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getIosAuditStatus() {
		return iosAuditStatus;
	}

	public void setIosAuditStatus(String iosAuditStatus) {
		this.iosAuditStatus = iosAuditStatus;
	}

	public String getIosAuditVersion() {
		return iosAuditVersion;
	}

	public void setIosAuditVersion(String iosAuditVersion) {
		this.iosAuditVersion = iosAuditVersion;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}



}
