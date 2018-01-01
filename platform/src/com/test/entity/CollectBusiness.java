package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 收藏商家
 * @author chengyz
 *
 */
@Table(tableName="collect_business")
public class CollectBusiness {
	
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36,isNotNull=true,comment="收藏uuid,全局唯一标识")
	private String collectUUID;
	
	@TableField(fieldSize=36,isNotNull=true,comment="会员UUID")
	private String vipUUID;
	
	@TableField(fieldSize=11,isNotNull=true,comment="会员手机号")
	private String vipPhoneNumber;
	
	@TableField(fieldSize=36,isNotNull=true,comment="商家UUID")
	private String businessUUID;
	
	@TableField(fieldSize=20,isNotNull=true,comment="收藏时间")
	private String collectTime;
	
	
	public String getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}

	public String getVipPhoneNumber() {
		return vipPhoneNumber;
	}

	public void setVipPhoneNumber(String vipPhoneNumber) {
		this.vipPhoneNumber = vipPhoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBusinessUUID() {
		return businessUUID;
	}

	public void setBusinessUUID(String businessUUID) {
		this.businessUUID = businessUUID;
	}

	public String getCollectUUID() {
		return collectUUID;
	}

	public void setCollectUUID(String collectUUID) {
		this.collectUUID = collectUUID;
	}


	public String getVipUUID() {
		return vipUUID;
	}

	public void setVipUUID(String vipUUID) {
		this.vipUUID = vipUUID;
	}
}