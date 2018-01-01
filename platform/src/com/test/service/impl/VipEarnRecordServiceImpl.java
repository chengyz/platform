package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spark.annotation.Auto;

import com.test.entity.VipEarnRecord;
import com.test.service.VipEarnRecordService;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import dbengine.util.Page;

/**
 * 会员收入记录service
 * @author chengyz
 *
 */
public class VipEarnRecordServiceImpl implements
		VipEarnRecordService {
	@Auto(name=EntityDao.class)
	private EntityDao entityDao;
	
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	/**
	 * 保存会员收入记录
	 */
	@Override
	public boolean saveOrUpdate(String sourceId,boolean closeConn,VipEarnRecord v) {
		if(v == null){
			return false;
		}
		if(v.getId() == null) {
			return entityDao.saveEntity(sourceId, v, closeConn);
		} else {
			return entityDao.updateEntity(sourceId, v, closeConn);
		}
	}
	/**
	 * 查询会员收入记录列表
	 */
	@Override
	public List<VipEarnRecord> findVipEarnRecordList(String sourceId, boolean closeConn,Page page, Map<String,String> findMap) {
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from vip_earn_record where 1 = 1 ");
		if(findMap.get("vipName") != null && !"".equals(findMap.get("vipName"))){
			sql.append(" and vipName = ?");
			params.add(findMap.get("vipName"));
		}
		if(findMap.get("vipMobilePhone") != null && !"".equals(findMap.get("vipMobilePhone"))){
			sql.append(" and vipMobilePhone = ?");
			params.add(findMap.get("vipMobilePhone"));
		}
		if(findMap.get("startTime") != null && !"".equals(findMap.get("startTime"))){
			sql.append(" and consumptionTime > ?");
			params.add(findMap.get("startTime"));
		}
		if(findMap.get("endTime") != null && !"".equals(findMap.get("endTime"))){
			sql.append(" and consumptionTime < ?");
			params.add(findMap.get("endTime"));
		}
		if(findMap.get("vipUUID") != null && !"".equals(findMap.get("vipUUID"))){
			 sql.append("and vipUUID = ? ");
			 sql.append("order by earnTime desc ");
			 params.add(findMap.get("vipUUID"));
		}
		if(page == null){
			return (List<VipEarnRecord>)sqldao.findListBySql(sourceId, sql.toString(),VipEarnRecord.class, closeConn, params);
		}else{
			return (List<VipEarnRecord>)sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, VipEarnRecord.class, page, params);
		}
	}
	

}







