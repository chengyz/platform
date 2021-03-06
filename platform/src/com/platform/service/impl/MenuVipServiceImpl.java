package com.platform.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spark.annotation.Auto;

import com.mysql.jdbc.StringUtils;
import com.platform.entity.MenuInfo;
import com.platform.entity.MenuVip;
import com.platform.service.IMenuVipService;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;

public class MenuVipServiceImpl implements IMenuVipService{

	@Auto(name=EntityDao.class)
	private EntityDao entitydao;
	
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	/**
	 * 保存菜单会员关联信息
	 */
	@Override
	public boolean saveMenuVip(String sourceId,boolean closeConn,List<MenuVip> mvList) {
		if(mvList==null || mvList.size()<1){
			return false;
		}
		try {
			return entitydao.saveBatch(sourceId, mvList, closeConn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除菜单会员关联信息
	 */
	@Override
	public boolean deleteMenuVip(String sourceId,boolean closeConn, String menuUUID, String vipUUID) {
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("delete from menu_vip where 1 = 1");
		if(menuUUID!=null && !"".equals(menuUUID) && !"null".equals(menuUUID)){
			sql.append(" and menuUUID = ?");
			params.add(menuUUID);
		}
		if(vipUUID!=null && !"".equals(vipUUID) && !"null".equals(vipUUID)){
			sql.append(" and vipUUID = ?");
			params.add(vipUUID);
		}
		return sqldao.executeSql(sourceId, sql.toString(), closeConn, params);
	}
	/**
	 * 通过会员uuid查菜单信息
	 */
	@Override
	public List<MenuInfo> findMenuByVipUUID(String sourceId,boolean closeConn, String vipUUID) {
		if(vipUUID==null || "".equals(vipUUID) || "null".equals(vipUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from menu_info m where 1 = 1");
		sql.append(" and menuUUID in(");
			sql.append("select menuUUID from menu_vip mu where 1 = 1");
			sql.append(" and mu.vipUUID = ?");
			params.add(vipUUID);
		sql.append(")");
		return (List<MenuInfo>)sqldao.findListBySql(sourceId, sql.toString(), MenuInfo.class, closeConn, params);
	}
	@Override
	public List<Map> findAllMenuItemForVip(String sourceId, boolean closeConn,
			String vipUUID, String unitUUID) {
		if (StringUtils.isNullOrEmpty(unitUUID)&&StringUtils.isNullOrEmpty(vipUUID)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT mri.menuUUID,mri.menuName,mr.menuUUID AS selected FROM (SELECT mi.menuUUID,mi.menuName,mi.menuCode FROM menu_info mi WHERE menuUUID IN (SELECT menuUUID FROM menu_unit mu WHERE mu.unitUUID = '"+unitUUID+"')) mri LEFT JOIN ( SELECT menuUUID FROM menu_vip ai WHERE ai.vipUUID = '"+vipUUID+"' AND ai.unitUUID = '"+unitUUID+"' ) mr ON mri.menuUUID = mr.menuUUID ORDER BY menuCode");		
		List<Map> listMap = (List<Map>)sqldao.findMapListBysql(sourceId, sql.toString(), closeConn, null);
		if(listMap==null || listMap.size() < 1){
			return null;
		}
		for(Map map : listMap){
			if(map.get("selected") != null){
				map.put("selected", "selected");
			}else{
				map.put("selected", "");
			}
		}
		return listMap;
	}
}
