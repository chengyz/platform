package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 系统自动扫描及时间间隔
 * @author chengyz
 *
 */
@Table(tableName="change_time")
public class ChangeTime {
	
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36,isNotNull=true,comment="timeUUID,全球唯一标识")
	private String timeUUID;

	@TableField(fieldSize=20,comment="支付超时时间,单位：分钟")
	private String payTimeOut;
	
	@TableField(fieldSize=20,comment="支付 首次扫描的时间,单位：秒")
	private String payFirstScanTime;
	
	@TableField(fieldSize=20,comment="支付扫描间隔时间，单位：秒")
	private String payScanTime;
	
	@TableField(fieldSize=20,comment="未确认订单 首次扫描的时间,单位：秒")
	private String firstScanOrderTime;
	
	@TableField(fieldSize=10,comment="双方未确认订单的时间长度，单位：天")
	private String allUnconfirmedTime;
	
	@TableField(fieldSize=10,comment="跑客确认，派单者未确认的时间长度，单位：天")
	private String vipUnconfirmedTime;
	
	@TableField(fieldSize=20,comment="未确认订单的扫描间隔时间，单位：秒")
	private String scanOrderTime;
	
	@TableField(fieldSize=20,comment="未被抢订单 首次扫描的时间,单位：秒")
	private String noGetFirstScanTime;
	
	@TableField(fieldSize=20,comment="未被抢订单的扫描间隔时间，单位：秒")
	private String noGetScanTime;
	
	@TableField(fieldSize=20,comment="创建时间")
	private String createTime;
	
	@TableField(fieldSize=20,comment="修改时间")
	private String updateTime;
	
	@TableField(fieldSize=10,comment="所属平台: 1是好快当")
	private String belongPlatform;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTimeUUID() {
		return timeUUID;
	}

	public void setTimeUUID(String timeUUID) {
		this.timeUUID = timeUUID;
	}

	public String getPayTimeOut() {
		return payTimeOut;
	}

	public void setPayTimeOut(String payTimeOut) {
		this.payTimeOut = payTimeOut;
	}

	public String getPayFirstScanTime() {
		return payFirstScanTime;
	}

	public String getNoGetFirstScanTime() {
		return noGetFirstScanTime;
	}

	public void setNoGetFirstScanTime(String noGetFirstScanTime) {
		this.noGetFirstScanTime = noGetFirstScanTime;
	}

	public String getNoGetScanTime() {
		return noGetScanTime;
	}

	public void setNoGetScanTime(String noGetScanTime) {
		this.noGetScanTime = noGetScanTime;
	}

	public void setPayFirstScanTime(String payFirstScanTime) {
		this.payFirstScanTime = payFirstScanTime;
	}

	public String getPayScanTime() {
		return payScanTime;
	}

	public void setPayScanTime(String payScanTime) {
		this.payScanTime = payScanTime;
	}

	public String getFirstScanOrderTime() {
		return firstScanOrderTime;
	}

	public void setFirstScanOrderTime(String firstScanOrderTime) {
		this.firstScanOrderTime = firstScanOrderTime;
	}

	public String getAllUnconfirmedTime() {
		return allUnconfirmedTime;
	}

	public void setAllUnconfirmedTime(String allUnconfirmedTime) {
		this.allUnconfirmedTime = allUnconfirmedTime;
	}

	public String getVipUnconfirmedTime() {
		return vipUnconfirmedTime;
	}

	public void setVipUnconfirmedTime(String vipUnconfirmedTime) {
		this.vipUnconfirmedTime = vipUnconfirmedTime;
	}

	public String getScanOrderTime() {
		return scanOrderTime;
	}

	public void setScanOrderTime(String scanOrderTime) {
		this.scanOrderTime = scanOrderTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getBelongPlatform() {
		return belongPlatform;
	}

	public void setBelongPlatform(String belongPlatform) {
		this.belongPlatform = belongPlatform;
	}

}