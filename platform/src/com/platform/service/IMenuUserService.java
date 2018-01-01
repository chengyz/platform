package com.platform.service;

import java.util.List;
import java.util.Map;

import com.platform.entity.MenuInfo;
import com.platform.entity.MenuUser;


/**
 * 菜单用户关联信息接口
 * @author hshzh
 *
 */
public interface IMenuUserService {
	/**
	 * 保存菜单用户关联信息
	 * @param muList
	 * @return
	 */
	public boolean saveMenuUser(String sourceId,boolean closeConn,List<MenuUser> muList);
	
	/**
	 * 删除菜单用户信息
	 * @param unitUUID
	 * @param menuUUID
	 * @param userUUID
	 * @return
	 */
	public boolean deleteMenuUser(String sourceId,boolean closeConn,String menuUUID,String userUUID);
	/**
	 * 通过用户ID查关联的菜信息
	 * @param unitUUID
	 * @param userUUID
	 * @return
	 */
	public List<MenuInfo> findMenuByUserUUID(String sourceId,boolean closeConn,String userUUID);
	
	@SuppressWarnings("rawtypes")
	public List<Map> findAllMenuItemForUser(String sourceId,boolean closeConn,String userUUID, String unitUUID);
}
