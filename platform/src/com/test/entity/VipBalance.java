package com.test.entity;

import java.math.BigDecimal;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 会员余额
 * @author chengyz
 *
 */
@Table(tableName="vip_balance")
public class VipBalance {
	
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36,isNotNull=true,comment="余额uuid,全局唯一标识")
	private String balanceUUID;
	
	@TableField(fieldSize=36,comment="会员UUID")
	private String vipUUID;
	
	@TableField(fieldSize=10,comment="会员余额")
	private BigDecimal vipBalance;
	
	@TableField(fieldSize=30,comment="会员名")
	private String vipName;
	
	@TableField(fieldSize=11,comment="会员手机号")
	private String vipPhoneNumber;
	
	@TableField(fieldSize=30,comment="创建时间")
	private String createTime;
	
	@TableField(fieldSize=30,comment="修改时间，最近一次更新的时间")
	private String updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBalanceUUID() {
		return balanceUUID;
	}

	public void setBalanceUUID(String balanceUUID) {
		this.balanceUUID = balanceUUID;
	}

	public String getVipUUID() {
		return vipUUID;
	}

	public void setVipUUID(String vipUUID) {
		this.vipUUID = vipUUID;
	}

	public BigDecimal getVipBalance() {
		return vipBalance;
	}

	public void setVipBalance(BigDecimal vipBalance) {
		this.vipBalance = vipBalance;
	}

	public String getVipName() {
		return vipName;
	}

	public void setVipName(String vipName) {
		this.vipName = vipName;
	}

	public String getVipPhoneNumber() {
		return vipPhoneNumber;
	}

	public void setVipPhoneNumber(String vipPhoneNumber) {
		this.vipPhoneNumber = vipPhoneNumber;
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
	
	
	
	
}
