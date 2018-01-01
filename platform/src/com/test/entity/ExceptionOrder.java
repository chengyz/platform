package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 异常订单处理实体类
 * @author chengyz
 *
 */
@Table(tableName="exception_order")
public class ExceptionOrder {
	
	@TableField(isPKey=true, isNotNull=true, isAutoIncrement=true, comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36, isNotNull=true, comment="uuid,全球唯一标识")
	private String uuid;

	@TableField(fieldSize=36, isNotNull=true, comment="订单UUID")
	private String orderUUID;
	
	@TableField(fieldSize=32, isNotNull=true, comment="订单号")
	private String orderNumber;
	
	@TableField(fieldSize=10, comment="申请方")
	private String applicant;
	
	@TableField(fieldSize=36,isNotNull=true,comment="会员UUID")
	private String vipUUID;
	
	@TableField(fieldSize=20 , comment="会员姓名")
	private String vipName;
	
	@TableField(fieldSize=13, comment="会员手机号")
	private String vipMobile;
	
	@TableField(fieldSize=36, comment="跑客UUID")
	private String getVipUUID;
	
	@TableField(fieldSize=20, comment="跑客名称")
	private String getVipName;
	
	@TableField(fieldSize=13, comment="跑客手机号")
	private String getVipModile;
	
	@TableField(fieldSize=500, comment="申请理由")
	private String applayReason;
	
	@TableField(fieldSize=5, comment="处理状态：1表示待处理、2表示已处理")
	private String handleStatus;
	
	@TableField(fieldSize=36, comment="处理人UUID")
	private String handleUserUUID;
	
	@TableField(fieldSize=20, comment="处理人名称")
	private String handleUserName;
	
	@TableField(fieldSize=20, comment="申请时间")
	private String applayTime;
	
	@TableField(fieldSize=20, comment="处理时间")
	private String handleTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getOrderUUID() {
		return orderUUID;
	}

	public void setOrderUUID(String orderUUID) {
		this.orderUUID = orderUUID;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getVipUUID() {
		return vipUUID;
	}

	public void setVipUUID(String vipUUID) {
		this.vipUUID = vipUUID;
	}

	public String getVipName() {
		return vipName;
	}

	public void setVipName(String vipName) {
		this.vipName = vipName;
	}

	public String getVipMobile() {
		return vipMobile;
	}

	public void setVipMobile(String vipMobile) {
		this.vipMobile = vipMobile;
	}

	public String getGetVipUUID() {
		return getVipUUID;
	}

	public void setGetVipUUID(String getVipUUID) {
		this.getVipUUID = getVipUUID;
	}

	public String getGetVipName() {
		return getVipName;
	}

	public void setGetVipName(String getVipName) {
		this.getVipName = getVipName;
	}

	public String getGetVipModile() {
		return getVipModile;
	}

	public void setGetVipModile(String getVipModile) {
		this.getVipModile = getVipModile;
	}

	public String getApplayReason() {
		return applayReason;
	}

	public void setApplayReason(String applayReason) {
		this.applayReason = applayReason;
	}

	public String getHandleStatus() {
		return handleStatus;
	}

	public void setHandleStatus(String handleStatus) {
		this.handleStatus = handleStatus;
	}

	public String getHandleUserUUID() {
		return handleUserUUID;
	}

	public void setHandleUserUUID(String handleUserUUID) {
		this.handleUserUUID = handleUserUUID;
	}

	public String getHandleUserName() {
		return handleUserName;
	}

	public void setHandleUserName(String handleUserName) {
		this.handleUserName = handleUserName;
	}

	public String getApplayTime() {
		return applayTime;
	}

	public void setApplayTime(String applayTime) {
		this.applayTime = applayTime;
	}

	public String getHandleTime() {
		return handleTime;
	}

	public void setHandleTime(String handleTime) {
		this.handleTime = handleTime;
	}
	
	
}