package com.test.entity;

import java.math.BigDecimal;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 会员消费记录
 * @author chengyz
 *
 */
@Table(tableName = "vip_consumption_record")
public class VipConsumptionRecord {
	@TableField(isPKey=true,isAutoIncrement=true,comment="主键，自动增长!")
	private Long id;
	@TableField(fieldSize=36,comment="uuid,全局唯一")
	private String UUID;
	@TableField(fieldSize=36,comment="会员uuid")
	private String vipUUID;
	@TableField(fieldSize=20,comment="会员名称")
	private String vipName;
	@TableField(fieldSize=36,comment="会员手机号")
	private String vipMobilePhone;
	@TableField(fieldSize=36,comment="交易流水号")
	private String tradeNo;
	@TableField(fieldSize=36,comment="消费模块uuid")
	private String moduleUUID;
	@TableField(fieldSize=50,comment="模块名称")
	private String moduleName;
	@TableField(fieldSize=10,comment="消费金额")
	private BigDecimal consumptionMoney;
	@TableField(fieldSize=20,comment="消费时间")
	private String consumptionTime;
	@TableField(fieldSize=1000,comment="消费详情")
	private String consumptionDetails;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
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
	public String getVipMobilePhone() {
		return vipMobilePhone;
	}
	public void setVipMobilePhone(String vipMobilePhone) {
		this.vipMobilePhone = vipMobilePhone;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getModuleUUID() {
		return moduleUUID;
	}
	public void setModuleUUID(String moduleUUID) {
		this.moduleUUID = moduleUUID;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public BigDecimal getConsumptionMoney() {
		return consumptionMoney;
	}
	public void setConsumptionMoney(BigDecimal consumptionMoney) {
		this.consumptionMoney = consumptionMoney;
	}
	public String getConsumptionTime() {
		return consumptionTime;
	}
	public void setConsumptionTime(String consumptionTime) {
		this.consumptionTime = consumptionTime;
	}
	public String getConsumptionDetails() {
		return consumptionDetails;
	}
	public void setConsumptionDetails(String consumptionDetails) {
		this.consumptionDetails = consumptionDetails;
	}
}
