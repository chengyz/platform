package com.platform.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;
import com.platform.entity.MenuInfo;
import com.platform.entity.RoleInfo;
import com.platform.entity.RoleUser;
import com.platform.entity.UserInfo;
import com.platform.service.IRoleUserService;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import spark.annotation.Auto;

/**
 * 角色用户关联信息service
 * @author hshzh
 *
 */
public class RoleUserServiceImpl implements IRoleUserService {

	//注入EntityDao实体
	@Auto(name=EntityDao.class)
	private EntityDao entitydao;
	
	//注入SqlDao实体
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	/**
	 * 保存角色用户
	 */
	@Override
	public boolean saveRoleUser(String sourceId,boolean closeConn,List<RoleUser> ruList) {
		if(ruList==null || ruList.size()<1){
			return false;
		}		
		try {
			return entitydao.saveBatch(sourceId, ruList, closeConn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 删除用户角色
	 */
	@Override
	public boolean deleteRoleUser(String sourceId,boolean closeConn, String roleUUID, String userUUID) {
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("delete from role_user where 1 = 1");
		if(roleUUID!=null && !"".equals(roleUUID) && !"null".equals(roleUUID)){
			sql.append(" and roleUUID = ?");
			params.add(roleUUID);
		}
		if(userUUID != null && !"".equals(userUUID) && !"null".equals(userUUID)){
			sql.append(" and userUUID = ?");
			params.add(userUUID);
		}
		return sqldao.executeSql(sourceId, sql.toString(), closeConn, params);
	}
	/**
	 * 通过角色uuid查用户信息列表
	 */
	@Override
	public List<UserInfo> findUserByRoleUUID(String sourceId,boolean closeConn,String roleUUID) {
		if(roleUUID==null || "".equals(roleUUID) || "null".equals(roleUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from user_info u where 1=1");
		sql.append(" and userUUID in(");
			sql.append("select userUUID from role_user ru where 1 = 1");
			sql.append(" and ru.roleUUID=?");
			params.add(roleUUID);
		sql.append(")");
		return (List<UserInfo>)sqldao.findListBySql(sourceId, sql.toString(), UserInfo.class, closeConn, params);
	}
	/**
	 * 通过角色uuid查没有关联的用户
	 */
	@Override
	public List<UserInfo> findNotUserByRoleUUID(String sourceId,boolean closeConn,String roleUUID) {
		if(roleUUID==null || "".equals(roleUUID) || "null".equals(roleUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from user_info u where 1=1");
		sql.append(" and userUUID not in(");
			sql.append("select userUUID from role_user ru where 1=1");
			sql.append(" and ru.roleUUID=?");
			params.add(roleUUID);
		sql.append(")");
		return (List<UserInfo>)sqldao.findListBySql(sourceId, sql.toString(), UserInfo.class, closeConn, params);
	}
	/**
	 * 通过用户uuid查关联的角色信息
	 */
	@Override
	public List<RoleInfo> findRoleByUserUUID(String sourceId,boolean closeConn,String userUUID) {
		if(userUUID==null || "".equals(userUUID) || "null".equals(userUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from role_info ri where ri.roleUUID in(");
		sql.append("select roleUUID from role_user ru where 1 = 1");
		sql.append(" and ru.userUUID = ?");
		params.add(userUUID);
		sql.append(")");
		return (List<RoleInfo>)sqldao.findListBySql(sourceId, sql.toString(), RoleInfo.class, closeConn, params);
	}
    /**
     * 通过用户uuid查没有关联的角色信息
     * @param sourceId
     * @param closeConn
     * @param unitUUID
     * @param userUUID
     * @return
     */
	@Override
	public List<RoleInfo> findNotRoleByUserUUID(String sourceId,boolean closeConn, String userUUID) {
		if(userUUID==null || "".equals(userUUID) || "null".equals(userUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from role_info ri where ri.roleUUID not in(");
		sql.append("select roleUUID from role_user ru where 1 = 1");
		sql.append(" and ru.userUUID = ?");
		params.add(userUUID);
		sql.append(")");
		return (List<RoleInfo>)sqldao.findListBySql(sourceId, sql.toString(), RoleInfo.class, closeConn, params);
	}
	@Override
	public List<Map> findRoleToAssignRole(String sourceId, boolean closeConn,
			String userUUID, String unitUUID) {
		if (StringUtils.isNullOrEmpty(unitUUID)&&StringUtils.isNullOrEmpty(userUUID)) {
			return null;
		}
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT mri.roleUUID,mri.roleName,mr.roleUUID AS selected FROM (SELECT mi.roleUUID,mi.roleName FROM role_info mi WHERE mi.unitUUID = '"+unitUUID+"') mri LEFT JOIN ( SELECT roleUUID FROM role_user ai WHERE ai.userUUID = '"+userUUID+"' AND ai.unitUUID = '"+unitUUID+"' ) mr ON mri.roleUUID = mr.roleUUID ORDER BY roleName");		
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
	@Override
	public List<MenuInfo> findMenuForUser(String sourceId, boolean closeConn,
			String userUUID, String unitUUID) {
		if(userUUID==null || "".equals(userUUID) || "null".equals(userUUID)||unitUUID==null || "".equals(unitUUID) || "null".equals(unitUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from menu_info m where 1 = 1");
		sql.append(" and menuUUID in(");
			sql.append("select menuUUID from menu_role mu where 1 = 1");
			sql.append(" and mu.unitUUID = ? and mu.roleUUID in (");
				sql.append("select roleUUID from role_user ru where 1 = 1");
				sql.append(" and ru.unitUUID = ? and ru.userUUID = ? ");
			params.add(unitUUID);
				params.add(unitUUID);
				params.add(userUUID);
		sql.append("))");
		return sqldao.findListBySql(sourceId, sql.toString(), MenuInfo.class, closeConn, params);
	}

}
