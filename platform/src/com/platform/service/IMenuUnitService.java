package com.platform.service;

import java.util.List;
import java.util.Map;

import com.platform.entity.MenuInfo;
import com.platform.entity.MenuUnit;

public interface IMenuUnitService {

	/**
	 * 保存菜单用户关联信息
	 * @param muList
	 * @return
	 */
	public boolean saveMenuUnit(String sourceId,boolean closeConn,List<MenuUnit> muList);
	
	/**
	 * 删除菜单用户信息
	 * @param unitUUID
	 * @param menuUUID
	 * @return
	 */
	public boolean deleteMenuUnit(String sourceId,boolean closeConn,String menuUUID,String unitUUID);
	/**
	 * 通过单位ID查关联的菜信息
	 * @param unitUUID
	 * @return
	 */
	public List<MenuInfo> findMenuByUnitUUID(String sourceId,boolean closeConn,String unitUUID);
	
	
	@SuppressWarnings("rawtypes")
	public List<Map> findAllMenuItemForUnit(String sourceId,boolean closeConn,String unitUUID);
	
}
