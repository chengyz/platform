package com.platform.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 
 * @author fengxuefeng
 *
 */
@Table(tableName="trade_type")
public class TradeType {
	
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键，自动增长")
	private Long id; //Id
	@TableField(fieldSize=36,isNotNull=true,comment="UUID")
	private String typeUUID;//行业UUID
	@TableField(fieldSize=100,isNotNull=true,comment="")
	private String typeCode;
	@TableField(fieldSize=100,isNotNull=true,comment="")
	private String typeName;
	@TableField(fieldSize=100,isNotNull=true,comment="")
	private String typeParentCode;
	@TableField(fieldSize=100,comment="")
	private String typeParentName;
	@TableField(fieldSize=200,comment="菜单连接地址（无连接地址用#号表示）")
	private String typeUrl;
	@TableField(fieldSize=2,comment="菜单类型（0顶级菜单，1级菜单，2二级菜单,3三级菜单 ）")
	private String typeType;
	@TableField(fieldSize=1,comment="菜单是否显示(0不显示，1显示）")
	private String isShow;
	@TableField(fieldSize=1,comment="是否有下级节点(1有,0没有)")
    private String typeHaveLowerNode;
	@TableField(fieldSize=500,comment="")
	private String typeIntruduce;
	@TableField(fieldSize=20,isNotNull=true,comment="")
	private String typeCreateTime;
	@TableField(fieldSize=36,isNotNull=true,comment="")
	private String typeCreateUserUUID;
	@TableField(fieldSize=100,isNotNull=true,comment="")
	private String typeCreateUserName;
	@TableField(fieldSize=20,comment="")
	private String typeUpTime;
	@TableField(fieldSize=36,comment="")
	private String typeUpUserUUID;
	@TableField(fieldSize=100,comment="")
	private String typeUpUserName;

	public TradeType() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeUUID() {
		return typeUUID;
	}

	public void setTypeUUID(String typeUUID) {
		this.typeUUID = typeUUID;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeParentCode() {
		return typeParentCode;
	}

	public void setTypeParentCode(String typeParentCode) {
		this.typeParentCode = typeParentCode;
	}

	public String getTypeParentName() {
		return typeParentName;
	}

	public void setTypeParentName(String typeParentName) {
		this.typeParentName = typeParentName;
	}

	public String getTypeUrl() {
		return typeUrl;
	}

	public void setTypeUrl(String typeUrl) {
		this.typeUrl = typeUrl;
	}

	public String getTypeType() {
		return typeType;
	}

	public void setTypeType(String typeType) {
		this.typeType = typeType;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public String getTypeHaveLowerNode() {
		return typeHaveLowerNode;
	}

	public void setTypeHaveLowerNode(String typeHaveLowerNode) {
		this.typeHaveLowerNode = typeHaveLowerNode;
	}

	public String getTypeIntruduce() {
		return typeIntruduce;
	}

	public void setTypeIntruduce(String typeIntruduce) {
		this.typeIntruduce = typeIntruduce;
	}

	public String getTypeCreateTime() {
		return typeCreateTime;
	}

	public void setTypeCreateTime(String typeCreateTime) {
		this.typeCreateTime = typeCreateTime;
	}

	public String getTypeCreateUserUUID() {
		return typeCreateUserUUID;
	}

	public void setTypeCreateUserUUID(String typeCreateUserUUID) {
		this.typeCreateUserUUID = typeCreateUserUUID;
	}

	public String getTypeCreateUserName() {
		return typeCreateUserName;
	}

	public void setTypeCreateUserName(String typeCreateUserName) {
		this.typeCreateUserName = typeCreateUserName;
	}

	public String getTypeUpTime() {
		return typeUpTime;
	}

	public void setTypeUpTime(String typeUpTime) {
		this.typeUpTime = typeUpTime;
	}

	public String getTypeUpUserUUID() {
		return typeUpUserUUID;
	}

	public void setTypeUpUserUUID(String typeUpUserUUID) {
		this.typeUpUserUUID = typeUpUserUUID;
	}

	public String getTypeUpUserName() {
		return typeUpUserName;
	}

	public void setTypeUpUserName(String typeUpUserName) {
		this.typeUpUserName = typeUpUserName;
	}
	
	
}
