package com.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.annotation.Auto;

import com.test.entity.SystemMessage;
import com.test.service.SystemMessageService;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import dbengine.util.Page;
/**
 * 系统消息的service接口实现
 * @author chengyz
 *
 */
public class SystemMessageServiceImpl implements SystemMessageService {
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	@Auto(name=EntityDao.class)
	private EntityDao entityDao;
	/**
	 * 查询系统消息
	 */
	@Override
	public SystemMessage findSystemMessage(String sourceId, boolean closeConn, String uuid) {
		if(uuid == null || "".equals(uuid) || "null".equals(uuid)) {
			return null;
		}
		String sql = "select * from system_message where uuid = '"+uuid+"'";
		return (SystemMessage)sqldao.findEntityBySql(sourceId, sql, SystemMessage.class, closeConn, null);
	}
	/**
	 * 删除系统消息
	 */
	@Override
	public boolean deleteSystemMessage(String sourceId, boolean closeConn, String uuid) {
		if(uuid == null || "".equals(uuid) || "null".equals(uuid)) {
			return false;
		}
		String sql = "delete from system_message where uuid = '"+uuid+"'";
		return sqldao.executeSql(sourceId, sql, closeConn, null);
	}
	/**
	 * 保存或修改系统消息
	 */
	@Override
	public boolean saveOrUpSystemMessage(String sourceId, boolean closeConn, SystemMessage systemMessage) {
		if(systemMessage == null) {
			return false;
		}
		if(systemMessage.getId() == null) {
			return entityDao.saveEntity(sourceId, systemMessage, closeConn);
		} else {
			return entityDao.updateEntity(sourceId, systemMessage, closeConn);
		}
	}
	/**
	 * 查询系统消息列表
	 */
	@Override
	public List<SystemMessage> findSystemMessageList(String sourceId, boolean closeConn, Page page, Map<String, String> findMap) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from system_message where 1 = 1 ");
		if(findMap != null) {
			if(findMap.get("belongApp") != null && !"".equals(findMap.get("belongApp")) && !"null".equals(findMap.get("belongApp"))) {
				sql.append(" and belongApp = '").append(findMap.get("belongApp").replaceAll("'", "")).append("'");
			}
		}
		if(page == null) {
			return sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, SystemMessage.class, page, null);
		} else {
			return sqldao.findListBySql(sourceId, sql.toString(), SystemMessage.class, closeConn, null);
		}
	}
	/**
	 * 查询所属app列表
	 */
	@Override
	public Map findAppList(String sourceId, boolean closeConn) {
		StringBuilder sql = new StringBuilder();
		sql.append("select distinct(belongApp) as belongApp from system_message");
		List<Map> apps = sqldao.findMapListBysql(sourceId, sql.toString(), closeConn, null);
		Map map = new HashMap();
		if(apps.size() > 0 && apps != null) {
			map.put("apps", apps);
			return map;
		} else {
			return null;
		}
		
	}


}
