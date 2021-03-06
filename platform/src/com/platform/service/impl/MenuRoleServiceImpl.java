package com.platform.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;
import com.platform.entity.MenuInfo;
import com.platform.entity.MenuRole;
import com.platform.service.IMenuRoleService;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import spark.annotation.Auto;
/**
 * 菜单角色信息service
 * @author hshzh
 *
 */
public class MenuRoleServiceImpl implements IMenuRoleService{
	@Auto(name=EntityDao.class)
	private EntityDao entitydao;
	
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	/**
	 * 保存菜单角色信息
	 */
	@Override
	public boolean saveMenuRole(String sourceId,boolean closeConn,List<MenuRole> mrList) {
		if(mrList==null || mrList.size()<1){
			return false;
		}
		try {
			return entitydao.saveBatch(sourceId, mrList, closeConn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除菜单角色信息
	 */
	@Override
	public boolean deleteMenuRole(String sourceId,boolean closeConn,String roleUUID, String menuUUID) {
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("delete from menu_role  where 1 = 1");
		if(roleUUID!=null && !"".equals(roleUUID) && !"null".equals(roleUUID)){
			sql.append(" and roleUUID = ?");
			params.add(roleUUID);
		}
		if(menuUUID!=null && !"".equals(menuUUID) && !"null".equals(menuUUID)){
			sql.append(" and menuUUID = ?");
			params.add(menuUUID);
		}
		return sqldao.executeSql(sourceId, sql.toString(), closeConn, params);
	}
    /**
     * 通过角色uuid查菜单信息
     */
	@Override
	public List<MenuInfo> findMenuByRoleUUID(String sourceId,boolean closeConn, String roleUUID) {
		if(roleUUID==null || "".equals(roleUUID) || "null".equals(roleUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from menu_info m where 1 = 1");
		sql.append(" and menuUUID in(");
			sql.append("select menuUUID from menu_role where roleUUID=?");
			params.add(roleUUID);
		sql.append(")");
		return (List<MenuInfo>)sqldao.findListBySql(sourceId, sql.toString(), MenuInfo.class, closeConn, params);
	}
	@Override
	public List<MenuInfo> findNotMenuByRoleUUID(String sourceId,boolean closeConn,String roleUUID) {
		if(roleUUID==null || "".equals(roleUUID) || "null".equals(roleUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from menu_info m where 1 = 1");
		sql.append(" and menuUUID not in(");
			sql.append("select menuUUID from menu_role where roleUUID=?");
			params.add(roleUUID);
		sql.append(")");
		return (List<MenuInfo>)sqldao.findListBySql(sourceId, sql.toString(), MenuInfo.class, closeConn, params);
	}
	@Override
	public List<Map> findAllMenuItemForRole(String sourceId, boolean closeConn,
			String roleUUID, String unitUUID) {
		if (StringUtils.isNullOrEmpty(unitUUID)&&StringUtils.isNullOrEmpty(roleUUID)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT mri.menuUUID,mri.menuName,mr.menuUUID AS selected FROM (SELECT mi.menuUUID,mi.menuName,mi.menuCode FROM menu_info mi WHERE menuUUID IN (SELECT menuUUID FROM menu_unit mu WHERE mu.unitUUID = '"+unitUUID+"')) mri LEFT JOIN ( SELECT menuUUID FROM menu_role ai WHERE ai.roleUUID = '"+roleUUID+"' AND ai.unitUUID = '"+unitUUID+"' ) mr ON mri.menuUUID = mr.menuUUID ORDER BY menuCode");		
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
