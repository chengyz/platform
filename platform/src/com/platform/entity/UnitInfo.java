package com.platform.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 单位信息
 * @author hshzh,fxf
 *
 */
@Table(tableName="unit_info")
public class UnitInfo {
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键，自动增长")
	private Long id; //Id
	@TableField(fieldSize=36,isNotNull=true,comment="UUID")
	private String unitUUID;//单位UUID
	@TableField(fieldSize=100,isNotNull=true,comment="组织机构代码")
	private String unitCode;//组织机构代码
	@TableField(fieldSize=100,isNotNull=true,comment="营业执照号码")
	private String LicenseNo;//营业执照号码
	@TableField(fieldSize=100,isNotNull=true,comment="单位名称")
	private String unitName;//单位名称
	@TableField(fieldSize=36,isNotNull=true,comment="法定代表人")
	private String LegalRepresentative;//法定代表人
	@TableField(fieldSize=100,isNotNull=true,comment="单位所在区域编码")
	private String unitRegionCode;//单位所在区域编码
	@TableField(fieldSize=100,isNotNull=true,comment="单位所在区域名称")
	private String unitRegionName;//单位所在区域名称
	@TableField(fieldSize=100,isNotNull=true,comment="单位详细地址")
	private String unitAddress;//单位详细地址
	@TableField(fieldSize=50,isNotNull=true,comment="联系人姓名")
	private String linkMan;//联系人姓名
	@TableField(fieldSize=11,isNotNull=true,comment="联系人电话")
	private String contactNumber;//联系人电话
	@TableField(fieldSize=50,isNotNull=true,comment="单位隶属关系")
	private String unitSubjection;//单位隶属关系
	@TableField(fieldSize=50,isNotNull=true,comment="单位性质")
	private String unitNature;//单位性质
	@TableField(fieldSize=36,isNotNull=true,comment="行业UUID")
	private String tradeUUID;//行业UUID
	@TableField(fieldSize=36,isNotNull=true,comment="单位行业")
	private String unitTrades;//单位行业
	@TableField(fieldSize=50,isNotNull=true,comment="街道,乡镇")
	private String street;//街道,乡镇
	@TableField(fieldSize=50,isNotNull=true,comment="村,社")
	private String village;//村,社
	@TableField(fieldSize=50,isNotNull=true,comment="工商执照登记类型")
	private String licenseType;//工商执照登记类型
	@TableField(fieldSize=500,isNotNull=true,comment="重点场所")
	private String unitKeyplace;//重点场所
	@TableField(fieldSize=500,isNotNull=true,comment="单位描述")
	private String unitDescribe;//单位描述
	@TableField(fieldSize=20,isNotNull=true,comment="创建日期（登记日期）")
	private String createTime;//创建日期（登记日期）
	@TableField(fieldSize=36,isNotNull=true,comment="创建人UUID")
	private String createUserUUID;//创建人UUID
	@TableField(fieldSize=50,isNotNull=true,comment="创建人姓名")
	private String createUserName;//创建人姓名
	@TableField(fieldSize=20,comment="修改日期")
	private String updateTime;//修改日期
	@TableField(fieldSize=36,comment="修改人UUID")
	private String updateUserUUID;//修改人UUID
	@TableField(fieldSize=50,comment="修改人姓名")
	private String updateUserName;//修改人姓名
	@TableField(fieldSize=1,comment="修改人姓名")
	private String status;//修改人姓名
	
	public UnitInfo() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUnitUUID() {
		return unitUUID;
	}
	public void setUnitUUID(String unitUUID) {
		this.unitUUID = unitUUID;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getLicenseNo() {
		return LicenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		LicenseNo = licenseNo;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getLegalRepresentative() {
		return LegalRepresentative;
	}
	public void setLegalRepresentative(String legalRepresentative) {
		LegalRepresentative = legalRepresentative;
	}
	public String getUnitRegionCode() {
		return unitRegionCode;
	}
	public void setUnitRegionCode(String unitRegionCode) {
		this.unitRegionCode = unitRegionCode;
	}
	public String getUnitRegionName() {
		return unitRegionName;
	}
	public void setUnitRegionName(String unitRegionName) {
		this.unitRegionName = unitRegionName;
	}
	public String getUnitAddress() {
		return unitAddress;
	}
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}
	public String getLinkMan() {
		return linkMan;
	}
	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getUnitSubjection() {
		return unitSubjection;
	}
	public void setUnitSubjection(String unitSubjection) {
		this.unitSubjection = unitSubjection;
	}
	public String getUnitNature() {
		return unitNature;
	}
	public void setUnitNature(String unitNature) {
		this.unitNature = unitNature;
	}
	public String getTradeUUID() {
		return tradeUUID;
	}
	public void setTradeUUID(String tradeUUID) {
		this.tradeUUID = tradeUUID;
	}
	public String getUnitTrades() {
		return unitTrades;
	}
	public void setUnitTrades(String unitTrades) {
		this.unitTrades = unitTrades;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	public String getUnitKeyplace() {
		return unitKeyplace;
	}
	public void setUnitKeyplace(String unitKeyplace) {
		this.unitKeyplace = unitKeyplace;
	}
	public String getUnitDescribe() {
		return unitDescribe;
	}
	public void setUnitDescribe(String unitDescribe) {
		this.unitDescribe = unitDescribe;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateUserUUID() {
		return createUserUUID;
	}
	public void setCreateUserUUID(String createUserUUID) {
		this.createUserUUID = createUserUUID;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateUserUUID() {
		return updateUserUUID;
	}
	public void setUpdateUserUUID(String updateUserUUID) {
		this.updateUserUUID = updateUserUUID;
	}
	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}