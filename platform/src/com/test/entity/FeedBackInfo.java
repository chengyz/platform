package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 会员反馈信息
 * @author chengyz
 *
 */
@Table(tableName="feed_back_info")
public class FeedBackInfo {
	
	@TableField(isPKey=true, isNotNull=true, isAutoIncrement=true, comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36, isNotNull=true, comment="uuid,全球唯一标识")
	private String uuid;

	@TableField(fieldSize=36, comment="会员uuid")
	private String vipUUID;
	
	@TableField(fieldSize=30, comment="会员名称")
	private String vipName;
	
	@TableField(fieldSize=13, comment="会员手机号")
	private String vipMobile;
	
	@TableField(fieldSize=20, comment="反馈时间")
	private String createTime;
	
	@TableField(fieldSize=200, comment="反馈内容")
	private String feedBackContent;
	
	@TableField(fieldSize=100,comment="评价的图片一")
	private String img1;
	@TableField(fieldSize=100,comment="评价的图片二")
	private String img2;
	@TableField(fieldSize=100,comment="评价的图片三")
	private String img3;
	@TableField(fieldSize=100,comment="评价的图片四")
	private String img4;
	
	@TableField(fieldSize=200, comment="联系方式：QQ或邮箱")
	private String contactWay;
	
	@TableField(fieldSize=2, comment="状态：1、已被查看；2、未被查看")
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getVipUUID() {
		return vipUUID;
	}

	public void setVipUUID(String vipUUID) {
		this.vipUUID = vipUUID;
	}
	

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	public String getContactWay() {
		return contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	public String getVipName() {
		return vipName;
	}

	public void setVipName(String vipName) {
		this.vipName = vipName;
	}

	public String getVipMobile() {
		return vipMobile;
	}

	public void setVipMobile(String vipMobile) {
		this.vipMobile = vipMobile;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getFeedBackContent() {
		return feedBackContent;
	}

	public void setFeedBackContent(String feedBackContent) {
		this.feedBackContent = feedBackContent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
