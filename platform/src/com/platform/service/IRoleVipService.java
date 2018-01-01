package com.platform.service;

import java.util.List;
import java.util.Map;

import com.platform.entity.MenuInfo;
import com.platform.entity.RoleInfo;
import com.platform.entity.RoleVip;
import com.platform.entity.VipInfo;

public interface IRoleVipService {
	/**
	 * 批量保存角色会员关联信息
	 * @param ruList
	 * @return
	 */
	public boolean saveRoleVip(String sourceId,boolean closeConn,List<RoleVip> ruList);
	
	/**
	 * 删除角色会员关联
	 * @param unitUUID
	 * @param roleUUID
	 * @param VipUUID
	 * @return
	 */
	public boolean deleteRoleVip(String sourceId,boolean closeConn,String roleUUID,String vipUUID);
	/**
	 * 通过角色UUID查关联的会员
	 * @param roleUUID
	 * @return
	 */
	public List<VipInfo> findVipByRoleUUID(String sourceId,boolean closeConn,String roleUUID);
	/**
	 * 通过角色UUID查非关联会员
	 * @param roleUUID
	 * @return
	 */
	public List<VipInfo> findNotVipByRoleUUID(String sourceId,boolean closeConn,String roleUUID);
	/**
	 * 通过会员UUID查关联的角色
	 * @param unitUUID
	 * @param VipUUID
	 * @return
	 */
	public List<RoleInfo> findRoleByVipUUID(String sourceId,boolean closeConn,String vipUUID);
	
	/**
	 * 通过会员UUID查非关联的角色
	 * @param unitUUID
	 * @param VipUUID
	 * @return
	 */
	public List<RoleInfo> findNotRoleByVipUUID(String sourceId,boolean closeConn,String vipUUID);
	
	@SuppressWarnings("rawtypes")
	public List<Map> findRoleToAssignRole(String sourceId,boolean closeConn,String vipUUID, String unitUUID);
	public List<MenuInfo> findMenuForVip(String sourceId,boolean closeConn,String vipUUID, String unitUUID);
}
