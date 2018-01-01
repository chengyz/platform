package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 会员实名认证信息
 * @author chengyz
 *
 */
@Table(tableName="certificate_info")
public class CertificateInfo {
	
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36,isNotNull=true,comment="认证uuid,全局唯一标识")
	private String certUUID;
	
	@TableField(fieldSize=36,isNotNull=true,comment="会员UUID")
	private String vipUUID;
	
	@TableField(fieldSize=11,isNotNull=true,comment="会员手机号码")
	private String vipPhoneNumber;
	
	@TableField(fieldSize=20,isNotNull=true,comment="真实姓名")
	private String trueName;
	
	@TableField(fieldSize=18,isNotNull=true,comment="身份证号")
	private String idNumber;
	
	@TableField(fieldSize=2,isNotNull=true,comment="交通工具:1是私家小轿车，2是摩托车，3是单车，4是其他")
	private String transport;
	
	@TableField(fieldSize=11,isNotNull=true,comment="手机号码")
	private String phoneNumber;
	
	@TableField(fieldSize=20,isNotNull=true,comment="紧急联系人真实姓名")
	private String emergencyContact;
	
	@TableField(fieldSize=11,isNotNull=true,comment="紧急联系人手机号码")
	private String emergencyNumber;
	
	@TableField(fieldSize=100,isNotNull=true,comment="手持身份证照片")
	private String handleCard;
	
	@TableField(fieldSize=100,isNotNull=true,comment="身份证正面")
	private String faceCard;
	
	@TableField(fieldSize=100,isNotNull=true,comment="身份证反面")
	private String reverseCard;
	
	@TableField(fieldSize=1,isNotNull=true,comment="审核状态   1为审核未通过、2为待审核、3为审核通过")
	private String status;
	
	@TableField(fieldSize=20,comment="创建时间")
	private String createTime;
	
	@TableField(fieldSize=20,comment="修改时间")
	private String updateTime;
	
	@TableField(fieldSize=30,comment="审核人姓名")
	private String userName;
	
	@TableField(fieldSize=36,comment="审核人UUID")
	private String userUUID;
	
	@TableField(fieldSize=500,comment="审核结果，不通过的要填")
	private String auditResult;
	
	


	public String getAuditResult() {
		return auditResult;
	}

	public void setAuditResult(String auditResult) {
		this.auditResult = auditResult;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
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

	public String getCertUUID() {
		return certUUID;
	}

	public void setCertUUID(String certUUID) {
		this.certUUID = certUUID;
	}

	public String getVipUUID() {
		return vipUUID;
	}

	public void setVipUUID(String vipUUID) {
		this.vipUUID = vipUUID;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}


	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getEmergencyNumber() {
		return emergencyNumber;
	}

	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}

	public String getHandleCard() {
		return handleCard;
	}

	public void setHandleCard(String handleCard) {
		this.handleCard = handleCard;
	}

	public String getFaceCard() {
		return faceCard;
	}

	public void setFaceCard(String faceCard) {
		this.faceCard = faceCard;
	}

	public String getReverseCard() {
		return reverseCard;
	}

	public void setReverseCard(String reverseCard) {
		this.reverseCard = reverseCard;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
    
	
	
}
