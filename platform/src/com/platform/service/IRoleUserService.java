package com.platform.service;

import java.util.List;
import java.util.Map;

import com.platform.entity.MenuInfo;
import com.platform.entity.RoleInfo;
import com.platform.entity.RoleUser;
import com.platform.entity.UserInfo;

/**
 * 角色用户关联信息service接口
 * @author hshzh
 *
 */
public interface IRoleUserService {
	/**
	 * 批量保存角色用户关联信息
	 * @param ruList
	 * @return
	 */
	public boolean saveRoleUser(String sourceId,boolean closeConn,List<RoleUser> ruList);	
	/**
	 * 删除角色用户关联
	 * @param unitUUID
	 * @param roleUUID
	 * @param userUUID
	 * @return
	 */
	public boolean deleteRoleUser(String sourceId,boolean closeConn,String roleUUID,String userUUID);
	/**
	 * 通过角色UUID查关联的用户
	 * @param roleUUID
	 * @return
	 */
	public List<UserInfo> findUserByRoleUUID(String sourceId,boolean closeConn,String roleUUID);
	/**
	 * 通过角色UUID查非关联用户
	 * @param roleUUID
	 * @return
	 */
	public List<UserInfo> findNotUserByRoleUUID(String sourceId,boolean closeConn,String roleUUID);
	/**
	 * 通过用户UUID查关联的角色
	 * @param unitUUID
	 * @param userUUID
	 * @return
	 */
	public List<RoleInfo> findRoleByUserUUID(String sourceId,boolean closeConn,String userUUID);
	/**
	 * 通过用户UUID查非关联的角色
	 * @param unitUUID
	 * @param userUUID
	 * @return
	 */
	public List<RoleInfo> findNotRoleByUserUUID(String sourceId,boolean closeConn,String userUUID);
	
	@SuppressWarnings("rawtypes")
	public List<Map> findRoleToAssignRole(String sourceId,boolean closeConn,String userUUID, String unitUUID);
	public List<MenuInfo> findMenuForUser(String sourceId,boolean closeConn,String userUUID, String unitUUID);
}
