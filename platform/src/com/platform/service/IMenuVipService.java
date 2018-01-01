package com.platform.service;

import java.util.List;
import java.util.Map;

import com.platform.entity.MenuInfo;
import com.platform.entity.MenuVip;

public interface IMenuVipService {
	/**
	 * 保存菜单会员 关联信息
	 * @param muList
	 * @return
	 */
	public boolean saveMenuVip(String sourceId,boolean closeConn,List<MenuVip> muList);
	
	/**
	 * 删除菜单会员 信息
	 * @param unitUUID
	 * @param menuUUID
	 * @param VipUUID
	 * @return
	 */
	public boolean deleteMenuVip(String sourceId,boolean closeConn,String menuUUID,String vipUUID);
	/**
	 * 通过会员 ID查关联的菜信息
	 * @param unitUUID
	 * @param VipUUID
	 * @return
	 */
	public List<MenuInfo> findMenuByVipUUID(String sourceId,boolean closeConn,String vipUUID);
	
	@SuppressWarnings("rawtypes")
	public List<Map> findAllMenuItemForVip(String sourceId,boolean closeConn,String vipUUID, String unitUUID);
}
