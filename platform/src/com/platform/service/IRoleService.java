package com.platform.service;

import java.util.List;
import java.util.Map;

import com.platform.entity.RoleInfo;

import dbengine.util.Page;


/**
 * 
 * @author 角色信息service接口
 *
 */
public interface IRoleService {
	/**
	 * 保存或修改角色
	 * @param role
	 * @return
	 */
	public boolean saveOrUpRole(String sourceId,boolean closeConn,RoleInfo role);
	/**
	 * 删除角色
	 * @param unitUUID
	 * @param roleUUID
	 * @return
	 */
	public boolean deleteRole(String sourceId,boolean closeConn,String roleUUID);
	
	/**
	 * 查角色信息
	 * @param unitUUID
	 * @param roleUUID
	 * @return
	 */
	public RoleInfo findRole(String sourceId,boolean closeConn,String roleUUID);
	/**
	 * 查角色信息列表
	 * @param unitUUID
	 * @return
	 */
	public List<RoleInfo> findRoleList(String sourceId,boolean closeConn,Page page, Map<String,String> findMap);
}
