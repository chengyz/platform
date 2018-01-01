package com.platform.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;
/**
 * 菜单会员关联表
 * @author hshzh
 *
 */
@Table(tableName="menu_vip")
public class MenuVip {
	@TableField(isPKey=true,isAutoIncrement=true,comment="主键id,自动增长")
	private Long id;
	@TableField(fieldSize=36,isNotNull=true,comment="菜单uuid")
	private String menuUUID;
	
	@TableField(fieldSize=36,isNotNull=true,comment="会员uuid")
	private String vipUUID;
	
	@TableField(fieldSize=36,comment="公司、单位uuid")
	private String unitUUID;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuUUID() {
		return menuUUID;
	}

	public void setMenuUUID(String menuUUID) {
		this.menuUUID = menuUUID;
	}

	public String getVipUUID() {
		return vipUUID;
	}

	public void setVipUUID(String vipUUID) {
		this.vipUUID = vipUUID;
	}

	public String getUnitUUID() {
		return unitUUID;
	}

	public void setUnitUUID(String unitUUID) {
		this.unitUUID = unitUUID;
	}
	
	
}
