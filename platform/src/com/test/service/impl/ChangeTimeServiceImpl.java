package com.test.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import spark.annotation.Auto;

import com.test.entity.ChangeTime;
import com.test.service.ChangeTimeService;
import com.util.DateUtil;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import dbengine.util.Page;
/**
 * 各种时间的service接口实现
 * @author chengyz
 *
 */
public class ChangeTimeServiceImpl implements ChangeTimeService {
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	
	@Auto(name=EntityDao.class)
	private EntityDao entityDao;
	/**
	 * 添加或修改
	 */
	@Override
	public boolean saveOrUpChangeTime(String sourceId, boolean closeConn, ChangeTime changeTime) {
		if(changeTime == null){
			return false;
		}
		if(changeTime.getId() == null){
			changeTime.setCreateTime(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
			changeTime.setTimeUUID(UUID.randomUUID().toString());
			return entityDao.saveEntity(sourceId, changeTime, closeConn);
		}else{
			changeTime.setUpdateTime(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
			return entityDao.updateEntity(sourceId, changeTime, closeConn);
		}
	}
	/**
	 * 查询各种时间
	 */
	@Override
	public ChangeTime findChangeTime(String sourceId, boolean closeConn, String timeUUID) {
		if(timeUUID == null || "".equals(timeUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select * from change_time where timeUUID = '").append(timeUUID).append("'");
		ChangeTime times = (ChangeTime)sqldao.findEntityBySql(sourceId, sql.toString(), ChangeTime.class, closeConn, null);
		if(times == null){
			return null;
		}else{
			return times;
		}
	}
	/**
	 * 删除各种时间
	 */
	@Override
	public boolean deleteChangeTime(String sourceId, boolean closeConn, String timeUUID) {
		if(timeUUID == null || "".equals(timeUUID)){
			return false;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("delete from change_time where timeUUID = '").append(timeUUID).append("'");
		return sqldao.executeSql(sourceId, sql.toString(), closeConn, null);
	}
	/**
	 * 查询各种时间列表
	 */
	@Override
	public List<ChangeTime> findTimeList(String sourceId, boolean closeConn,Page page) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from change_time");
		if(page == null){
			return sqldao.findListBySql(sourceId, sql.toString(), ChangeTime.class, closeConn, null);
		}else{
			return sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, ChangeTime.class, page, null);
		}
	}
	/**
	 * 通过所属平台查询各种时间
	 */
	@Override
	public ChangeTime findTimeByBelong(String sourceId, boolean closeConn, String belongPlatform) {
		if(belongPlatform == null || "".equals(belongPlatform)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select * from change_time where belongPlatform = '").append(belongPlatform).append("'");
		@SuppressWarnings("unchecked")
		ChangeTime time = (ChangeTime)sqldao.findEntityBySql(sourceId, sql.toString(), ChangeTime.class, closeConn, null);
		if(time == null){
			return null;
		}
		return time;
		
	}
}
