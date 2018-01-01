package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 系统消息
 * @author chengyz
 *
 */
@Table(tableName="system_message")
public class SystemMessage {
	
	@TableField(isPKey=true, isNotNull=true, isAutoIncrement=true, comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36, isNotNull=true, comment="uuid,全球唯一标识")
	private String uuid;

	@TableField(fieldSize=100, comment="消息标题")
	private String messageTitle;
	
	@TableField(fieldSize=500, comment="消息内容")
	private String messageContent;
	
	@TableField(fieldSize=20, comment="创建时间")
	private String createTime;
	
	@TableField(fieldSize=10, comment="所属App")
	private String belongApp;

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

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getBelongApp() {
		return belongApp;
	}

	public void setBelongApp(String belongApp) {
		this.belongApp = belongApp;
	}
	
	
}
