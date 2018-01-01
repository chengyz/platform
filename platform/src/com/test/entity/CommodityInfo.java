package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 商品信息
 * @author hshzh
 *
 */
@Table(tableName="commodity_info")
public class CommodityInfo {
	@TableField(isPKey=true,isAutoIncrement=true,comment="主键id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36,isUKey=true,comment="全球唯一标识")
	private String cmdtUUID;
	
	@TableField(fieldSize=100,isNotNull=true,comment="商品名称")
	private String cmdtName;
	
	@TableField(fieldSize=36,isNotNull=true,comment="商家uuid")
	private String businessUUID;
	
	@TableField(fieldSize=200,comment="商品图片地址1")
	private String cmdtImg1;
	
	@TableField(fieldSize=200,comment="商品图片地址2")
	private String cmdtImg2;
	
	@TableField(fieldSize=200,comment="商品图片地址3")
	private String cmdtImg3;
	
	@TableField(fieldSize=200,comment="商品图片地址4")
	private String cmdtImg4;
	
	@TableField(fieldSize=200,comment="商品图片地址5")
	private String cmdtImg5;
	
	@TableField(fieldSize=300,comment="商品介绍")
	private String  cmdtIntroduce;
	
	@TableField(comment="商品价格")
	private String cmdtPrice;
	
	@TableField(comment="商品状态(1上架，0下架)")
	private String cmdtState;
	
	@TableField(comment="商品数量")
	private long cmdtCount;
	
	@TableField(comment="创建时间")
	private String cmdtCreateTime;
	
	@TableField(fieldSize=2,comment="是否是热卖商品（首页推广）1：是 ,  2：否，默认2")
	private String cmdtHot = "2";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCmdtName() {
		return cmdtName;
	}

	public void setCmdtName(String cmdtName) {
		this.cmdtName = cmdtName;
	}

	public String getBusinessUUID() {
		return businessUUID;
	}

	public void setBusinessUUID(String businessUUID) {
		this.businessUUID = businessUUID;
	}

	public String getCmdtImg1() {
		return cmdtImg1;
	}

	public void setCmdtImg1(String cmdtImg1) {
		this.cmdtImg1 = cmdtImg1;
	}

	public String getCmdtImg2() {
		return cmdtImg2;
	}

	public void setCmdtImg2(String cmdtImg2) {
		this.cmdtImg2 = cmdtImg2;
	}

	public String getCmdtImg3() {
		return cmdtImg3;
	}

	public void setCmdtImg3(String cmdtImg3) {
		this.cmdtImg3 = cmdtImg3;
	}

	public String getCmdtImg4() {
		return cmdtImg4;
	}

	public void setCmdtImg4(String cmdtImg4) {
		this.cmdtImg4 = cmdtImg4;
	}

	public String getCmdtImg5() {
		return cmdtImg5;
	}

	public void setCmdtImg5(String cmdtImg5) {
		this.cmdtImg5 = cmdtImg5;
	}

	public String getCmdtIntroduce() {
		return cmdtIntroduce;
	}

	public void setCmdtIntroduce(String cmdtIntroduce) {
		this.cmdtIntroduce = cmdtIntroduce;
	}

	public String getCmdtState() {
		return cmdtState;
	}

	public void setCmdtState(String cmdtState) {
		this.cmdtState = cmdtState;
	}

	public long getCmdtCount() {
		return cmdtCount;
	}

	public void setCmdtCount(long cmdtCount) {
		this.cmdtCount = cmdtCount;
	}

	public String getCmdtUUID() {
		return cmdtUUID;
	}

	public void setCmdtUUID(String cmdtUUID) {
		this.cmdtUUID = cmdtUUID;
	}

	public String getCmdtCreateTime() {
		return cmdtCreateTime;
	}

	public void setCmdtCreateTime(String cmdtCreateTime) {
		this.cmdtCreateTime = cmdtCreateTime;
	}

	/**
	 * @return the cmdtHot
	 */
	public String getCmdtHot() {
		return cmdtHot;
	}

	/**
	 * @param cmdtHot the cmdtHot to set
	 */
	public void setCmdtHot(String cmdtHot) {
		this.cmdtHot = cmdtHot;
	}

	/**
	 * @return the cmdtPrice
	 */
	public String getCmdtPrice() {
		return cmdtPrice;
	}

	/**
	 * @param cmdtPrice the cmdtPrice to set
	 */
	public void setCmdtPrice(String cmdtPrice) {
		this.cmdtPrice = cmdtPrice;
	}
	
	

}
