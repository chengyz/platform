package com.test.entity;

import java.math.BigDecimal;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 会员提现
 * @author chengyz
 *
 */
@Table(tableName="withdraw_cash")
public class WithdrawCash {
	
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36,isNotNull=true,comment="提现uuid,全局唯一标识")
	private String cashUUID;
	
	@TableField(fieldSize=36,isNotNull=true,comment="会员UUID")
	private String vipUUID;
	
	@TableField(fieldSize=36,isNotNull=true,comment="会员登录名")
	private String vipName;
	
	@TableField(fieldSize=11,isNotNull=true,comment="会员手机号")
	private String vipPhoneNumber;
	
	@TableField(fieldSize=10,isNotNull=true,comment="提现金额")
	private BigDecimal withdrawCashAmount;
	
	@TableField(fieldSize=5,comment="提现手续费")
	private BigDecimal withdrawCashFee;
	
	@TableField(fieldSize=10,comment="可提现金额")
	private BigDecimal canWithdrawCashAmount;
	
	@TableField(fieldSize=10,isNotNull=true,comment="会员的余额")
	private BigDecimal vipBalance;
	
	@TableField(fieldSize=25,isNotNull=true,comment="提现账号")
	private String withdrawCashAccount;
	
	@TableField(fieldSize=20,isNotNull=true,comment="提现申请时间")
	private String applyTime;
	
	@TableField(fieldSize=30,comment="提现时间")
	private String withdrawCashTime;
	
	@TableField(fieldSize=2,isNotNull=true,comment="提现状态:1为申请中，2为失败，3为成功")
	private String status;
	
	@TableField(fieldSize=10,isNotNull=true,comment="提现方式")
	private String withdrawStyle;

	
	public BigDecimal getCanWithdrawCashAmount() {
		return canWithdrawCashAmount;
	}

	public void setCanWithdrawCashAmount(BigDecimal canWithdrawCashAmount) {
		this.canWithdrawCashAmount = canWithdrawCashAmount;
	}

	public BigDecimal getWithdrawCashFee() {
		return withdrawCashFee;
	}

	public void setWithdrawCashFee(BigDecimal withdrawCashFee) {
		this.withdrawCashFee = withdrawCashFee;
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

	public String getWithdrawStyle() {
		return withdrawStyle;
	}

	public void setWithdrawStyle(String withdrawStyle) {
		this.withdrawStyle = withdrawStyle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCashUUID() {
		return cashUUID;
	}

	public void setCashUUID(String cashUUID) {
		this.cashUUID = cashUUID;
	}

	public String getVipUUID() {
		return vipUUID;
	}

	public void setVipUUID(String vipUUID) {
		this.vipUUID = vipUUID;
	}


	public BigDecimal getWithdrawCashAmount() {
		return withdrawCashAmount;
	}

	public void setWithdrawCashAmount(BigDecimal withdrawCashAmount) {
		this.withdrawCashAmount = withdrawCashAmount;
	}

	public String getWithdrawCashAccount() {
		return withdrawCashAccount;
	}

	public void setWithdrawCashAccount(String withdrawCashAccount) {
		this.withdrawCashAccount = withdrawCashAccount;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getWithdrawCashTime() {
		return withdrawCashTime;
	}

	public void setWithdrawCashTime(String withdrawCashTime) {
		this.withdrawCashTime = withdrawCashTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
}
