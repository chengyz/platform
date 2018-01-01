package com.platform.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;
/**
 * 会员信息
 * @author hshzh
 *
 */
@Table(tableName="vip_info")
public class VipInfo {
	@TableField(isPKey=true,isAutoIncrement=true,comment="主键，自动增长")
	private Long id;
	@TableField(isNotNull=true,fieldSize=36,comment="全局唯一编号,UUID自动生成")
	private String vipUUID;
	@TableField(isNotNull=true,fieldSize=30,comment="登陆名，长度不超过30字符,建议用手机号")
	private String loginName;
	@TableField(fieldSize=36,comment="登陆密码，md5加密")
	private String vipPwd;
	@TableField(fieldSize=36,comment="归属单位统一编号,UUID自动生成")
	private String unitUUID;
	@TableField(fieldSize=100,comment="会员姓名")
	private String vipName;
	@TableField(fieldSize=2,isNotNull=true,comment="会员类型（0超级会员， 1一般会员， 2普通会员）")
	private String vipType;
	@TableField(fieldSize=11,isUKey=true,comment="会员手机,11位标准手机长度,全局唯一")
	private String vipMobile;
	@TableField(fieldSize=100,comment="办公电话,可允许有多个电话")
	private String vipTel;
	@TableField(fieldSize=100,comment="邮箱")
	private String vipEmail;
	@TableField(fieldSize=50,comment="昵称")
	private String nickName;
	@TableField(fieldSize=1,comment="会员性别（1男 2女 3其他：未知）")
	private String vipSex;
	@TableField(fieldSize=2,comment="状态：1正常启用,2注销, 3停用,4接单中")
	private String vipStatus;
	@TableField(fieldSize=30,comment="创建时间")
	private String createTime;
	@TableField(fieldSize=30,comment="修改时间")
	private String updateTime;
	@TableField(fieldSize=50,comment="姓名简拼")
	private String simpleSpelling;
	@TableField(fieldSize=100,comment="真实姓名的全拼")
	private String fullSpelling;
	@TableField(fieldSize=500,comment="组合查询(手机/姓名/姓名简拼/姓名全拼)")
	private String queryCombination;
	@TableField(fieldSize=200,comment="会员头像,存放相对地址")
	private String vipPic;
	@TableField(fieldSize=500,comment="备注，描述")
	private String vipDescription;
	@TableField(fieldSize=300,comment="登陆时间")
	private String loginTime;
	@TableField(fieldSize=10,comment="登陆次数")
	private int loginNum = 0;
	@TableField(fieldSize=10,comment="科类：1：文科，2：理科")
	private String kelei;
	@TableField(fieldSize=50,comment="所在学校(高中)")
	private String suozaixuexiao;
	@TableField(fieldSize=10,comment="考试总分数")
	private String zongfen;
	@TableField(fieldSize=10,comment="位次(考试排名)")
	private String paiming;
	@TableField(fieldSize=20,comment="身份证号")
	private String identityCard;
	@TableField(fieldSize=50,comment="民族")
	private String ethnic;
	@TableField(fieldSize=50,comment="考生所在地区")
	private String vipArea;
	@TableField(fieldSize=2,comment="实名认证状态:1为认证失败，2为认证中，3为认证成功则可接单,4为未认证（默认）")
	private String certificateStatus;
	@TableField(fieldSize=20,comment="政治面貌") 
	private String autonomyFace;
	@TableField(fieldSize=30,comment="会员支付宝账号") 
	private String alipayAccount;
	@TableField(fieldSize=10,comment="会员信用分（默认为5分）") 
	private String vipCredit;
	
	public String getCertificateStatus() {
		return certificateStatus;
	}
	public void setCertificateStatus(String certificateStatus) {
		this.certificateStatus = certificateStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getVipCredit() {
		return vipCredit;
	}
	public void setVipCredit(String vipCredit) {
		this.vipCredit = vipCredit;
	}
	public String getVipUUID() {
		return vipUUID;
	}
	public void setVipUUID(String vipUUID) {
		this.vipUUID = vipUUID;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getVipPwd() {
		return vipPwd;
	}
	public void setVipPwd(String vipPwd) {
		this.vipPwd = vipPwd;
	}
	public String getUnitUUID() {
		return unitUUID;
	}
	public void setUnitUUID(String unitUUID) {
		this.unitUUID = unitUUID;
	}
	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public String getVipType() {
		return vipType;
	}
	public void setVipType(String vipType) {
		this.vipType = vipType;
	}
	public String getVipMobile() {
		return vipMobile;
	}
	public void setVipMobile(String vipMobile) {
		this.vipMobile = vipMobile;
	}
	public String getVipTel() {
		return vipTel;
	}
	public void setVipTel(String vipTel) {
		this.vipTel = vipTel;
	}
	public String getVipEmail() {
		return vipEmail;
	}
	public void setVipEmail(String vipEmail) {
		this.vipEmail = vipEmail;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getVipSex() {
		return vipSex;
	}
	public void setVipSex(String vipSex) {
		this.vipSex = vipSex;
	}
	public String getVipStatus() {
		return vipStatus;
	}
	public void setVipStatus(String vipStatus) {
		this.vipStatus = vipStatus;
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
	public String getSimpleSpelling() {
		return simpleSpelling;
	}
	public void setSimpleSpelling(String simpleSpelling) {
		this.simpleSpelling = simpleSpelling;
	}
	public String getFullSpelling() {
		return fullSpelling;
	}
	public void setFullSpelling(String fullSpelling) {
		this.fullSpelling = fullSpelling;
	}
	public String getQueryCombination() {
		return queryCombination;
	}
	public void setQueryCombination(String queryCombination) {
		this.queryCombination = queryCombination;
	}
	public String getVipPic() {
		return vipPic;
	}
	public void setVipPic(String vipPic) {
		this.vipPic = vipPic;
	}
	public String getVipDescription() {
		return vipDescription;
	}
	public void setVipDescription(String vipDescription) {
		this.vipDescription = vipDescription;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public int getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(int loginNum) {
		this.loginNum = loginNum;
	}
	public String getKelei() {
		return kelei;
	}
	public void setKelei(String kelei) {
		this.kelei = kelei;
	}
	public String getSuozaixuexiao() {
		return suozaixuexiao;
	}
	public void setSuozaixuexiao(String suozaixuexiao) {
		this.suozaixuexiao = suozaixuexiao;
	}
	public String getZongfen() {
		return zongfen;
	}
	public void setZongfen(String zongfen) {
		this.zongfen = zongfen;
	}
	public String getPaiming() {
		return paiming;
	}
	public void setPaiming(String paiming) {
		this.paiming = paiming;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getEthnic() {
		return ethnic;
	}
	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}
	public String getAutonomyFace() {
		return autonomyFace;
	}
	public void setAutonomyFace(String autonomyFace) {
		this.autonomyFace = autonomyFace;
	}
	public String getVipArea() {
		return vipArea;
	}
	public void setVipArea(String vipArea) {
		this.vipArea = vipArea;
	}
	public String getAlipayAccount() {
		return alipayAccount;
	}
	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}
	
}
