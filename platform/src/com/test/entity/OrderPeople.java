package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 订单和抢单者关联
 * @author chengyz
 *
 */
@Table(tableName="order_people")
public class OrderPeople {
	
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36,isNotNull=true,comment="关联uuid,全局唯一标识")
	private String relateUUID;
	
	@TableField(fieldSize=36,isNotNull=true,comment="订单UUID")
	private String orderUUID;
	
	@TableField(fieldSize=36,isNotNull=true,comment="订单类型")
	private String orderType;
	
	@TableField(fieldSize=36,isNotNull=true,comment="派单者会员UUID")
	private String vipUUID;

	@TableField(fieldSize=20,isNotNull=true,comment="抢单时间")
	private String lootTime;
	
	@TableField(fieldSize=36,isNotNull=true,comment="抢单者会员UUID")
	private String getUUID;
	
	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRelateUUID() {
		return relateUUID;
	}

	public void setRelateUUID(String relateUUID) {
		this.relateUUID = relateUUID;
	}

	public String getOrderUUID() {
		return orderUUID;
	}

	public void setOrderUUID(String orderUUID) {
		this.orderUUID = orderUUID;
	}

	public String getVipUUID() {
		return vipUUID;
	}

	public void setVipUUID(String vipUUID) {
		this.vipUUID = vipUUID;
	}

	public String getLootTime() {
		return lootTime;
	}

	public void setLootTime(String lootTime) {
		this.lootTime = lootTime;
	}

	public String getGetUUID() {
		return getUUID;
	}

	public void setGetUUID(String getUUID) {
		this.getUUID = getUUID;
	}
}