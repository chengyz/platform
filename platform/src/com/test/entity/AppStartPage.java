package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 好快当app启动页面
 * @author chengyz
 *
 */
@Table(tableName="app_start_page")
public class AppStartPage {
	
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36,isNotNull=true,comment="启动页uuid,全球唯一标识")
	private String pageUUID;

	@TableField(fieldSize=1,comment="标记是否为广告")
	private String flag;
	
	@TableField(fieldSize=100,comment="图片路径")
	private String imagePath;
	
	@TableField(fieldSize=3,comment="显示顺序  1、2、3、4")
	private String displayOrder;
	
	@TableField(fieldSize=1,comment="是否禁用，1为禁用，2为启用")
	private String disable;
	
	@TableField(fieldSize=200,comment="备注")
	private String remark;
	
	@TableField(fieldSize=20,comment="创建时间")
	private String createTime;

	@TableField(fieldSize=30,comment="图片名称")
	private String imageName;
	
	@TableField(fieldSize=5,comment="所属app")
	private String belongApp;
	
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public String getBelongApp() {
		return belongApp;
	}

	public void setBelongApp(String belongApp) {
		this.belongApp = belongApp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPageUUID() {
		return pageUUID;
	}

	public void setPageUUID(String pageUUID) {
		this.pageUUID = pageUUID;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(String displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDisable() {
		return disable;
	}

	public void setDisable(String disable) {
		this.disable = disable;
	}

}
