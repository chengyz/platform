package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 好快当商家信息
 * @author hshzh
 *
 */
@Table(tableName="business_info")
public class BusinessInfo {
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键Id，自动增长")
	private Long id;
	
	@TableField(fieldSize=36,isNotNull=true,comment="商家uuid，全球唯一标识")
	private String businessUUID;
	
	@TableField(fieldSize=36,isNotNull=true,comment="单位uuid，必填，用于标识具体单位下的商家")
	private String unitUUID;
	
	@TableField(fieldSize=100,comment="商家简称")
	private String businessName;
	
	@TableField(fieldSize=100,isNotNull=true,isUKey=true,comment="商家全名称，全局唯一约束")
	private String businessFullName;
	
	@TableField(fieldSize=50,comment="商家类别")
	private String businessType;
	
	@TableField(fieldSize=50,comment="商家电话")
	private String businessTel;
	
	@TableField(fieldSize=50,comment="商家所在区域")
	private String businessArea;
	
	@TableField(fieldSize=500,comment="商家详细地址")
	private String businessAddr;
	
	@TableField(fieldSize=1000,comment="商家介绍")
	private String businessIntro;
	
	@TableField(fieldSize=50,comment="商家坐标,经度")
	private String businessCoordLongitude;
	
	@TableField(fieldSize=50,comment="商家坐标,纬度")
	private String businessCoordLatitude;
	
	@TableField(fieldSize=200,comment="商家门面图片信息")
	private String businessImg1;
	
	@TableField(fieldSize=200,comment="商家门面图片信息2")
	private String businessImg2;
	
	@TableField(fieldSize=200,comment="商家门面图片信息3")
	private String businessImg3;
	
	@TableField(fieldSize=200,comment="商家门面图片信息4")
	private String businessImg4;
	
	@TableField(fieldSize=500,comment="商家备注")
	private String businessMark;
	
	@TableField(fieldSize=500,comment="商家添加时间")
	private String businessTime;
	
	@TableField(fieldSize=2,comment="是否是热卖商家（首页推广）1：是      2：否，默认2")
	private String businessHot = "2";

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

	public String getUnitUUID() {
		return unitUUID;
	}

	public void setUnitUUID(String unitUUID) {
		this.unitUUID = unitUUID;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getBusinessFullName() {
		return businessFullName;
	}

	public void setBusinessFullName(String businessFullName) {
		this.businessFullName = businessFullName;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessTel() {
		return businessTel;
	}

	public void setBusinessTel(String businessTel) {
		this.businessTel = businessTel;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	public String getBusinessAddr() {
		return businessAddr;
	}

	public void setBusinessAddr(String businessAddr) {
		this.businessAddr = businessAddr;
	}

	public String getBusinessCoordLongitude() {
		return businessCoordLongitude;
	}

	public void setBusinessCoordLongitude(String businessCoordLongitude) {
		this.businessCoordLongitude = businessCoordLongitude;
	}

	public String getBusinessCoordLatitude() {
		return businessCoordLatitude;
	}

	public void setBusinessCoordLatitude(String businessCoordLatitude) {
		this.businessCoordLatitude = businessCoordLatitude;
	}

	public String getBusinessImg1() {
		return businessImg1;
	}

	public void setBusinessImg1(String businessImg1) {
		this.businessImg1 = businessImg1;
	}

	public String getBusinessImg2() {
		return businessImg2;
	}

	public void setBusinessImg2(String businessImg2) {
		this.businessImg2 = businessImg2;
	}

	public String getBusinessImg3() {
		return businessImg3;
	}

	public void setBusinessImg3(String businessImg3) {
		this.businessImg3 = businessImg3;
	}

	public String getBusinessImg4() {
		return businessImg4;
	}

	public void setBusinessImg4(String businessImg4) {
		this.businessImg4 = businessImg4;
	}

	public String getBusinessMark() {
		return businessMark;
	}

	public void setBusinessMark(String businessMark) {
		this.businessMark = businessMark;
	}

	/**
	 * @return the businessTime
	 */
	public String getBusinessTime() {
		return businessTime;
	}

	/**
	 * @param businessTime the businessTime to set
	 */
	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

	/**
	 * @return the businessIntro
	 */
	public String getBusinessIntro() {
		return businessIntro;
	}

	/**
	 * @param businessIntro the businessIntro to set
	 */
	public void setBusinessIntro(String businessIntro) {
		this.businessIntro = businessIntro;
	}

	/**
	 * @return the businessHot
	 */
	public String getBusinessHot() {
		return businessHot;
	}

	/**
	 * @param businessHot the businessHot to set
	 */
	public void setBusinessHot(String businessHot) {
		this.businessHot = businessHot;
	}

    
	
}