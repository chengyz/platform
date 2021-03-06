package com.platform.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;


/**
 * 菜单角色关联
 * @author hshzh
 *
 */
@Table(tableName="menu_role")
public class MenuRole {
	@TableField(isPKey=true,isAutoIncrement=true,comment="主键，自动增长")
	private Long id;
	@TableField(fieldSize=36,isNotNull=true,comment="菜单uuid")
	private String menuUUID;
	@TableField(fieldSize=36,isNotNull=true,comment="角色uuid")
	private String roleUUID;
	@TableField(fieldSize=36,comment="集团、公司uuid")
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
	public String getRoleUUID() {
		return roleUUID;
	}
	public void setRoleUUID(String roleUUID) {
		this.roleUUID = roleUUID;
	}
	public String getUnitUUID() {
		return unitUUID;
	}
	public void setUnitUUID(String unitUUID) {
		this.unitUUID = unitUUID;
	}
	
}
