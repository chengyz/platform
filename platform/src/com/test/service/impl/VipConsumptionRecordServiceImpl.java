package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spark.annotation.Auto;

import com.test.entity.VipConsumptionRecord;
import com.test.service.IVipConsumptionRecordService;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import dbengine.util.Page;

/**
 * 会员消费记录service
 * @author chengyz
 *
 */
public class VipConsumptionRecordServiceImpl implements
		IVipConsumptionRecordService {
	//注入EntityDao
	@Auto(name=EntityDao.class)
	private EntityDao entitydao;
	
	//注入SqlDao
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	/**
	 * 保存会员消费记录
	 */
	@Override
	public boolean saveOrUpdate(String sourceId,boolean closeConn,VipConsumptionRecord t) {
		if(t.getId() == null) {
			return entitydao.saveEntity(sourceId, t, closeConn);
		} else {
			return entitydao.updateEntity(sourceId, t, closeConn);
		}
	}
	/**
	 * 通过支付宝交易流水号查询交易记录
	 */
	@Override
	public VipConsumptionRecord findVipConsumptionRecord(String sourceId, boolean closeConn, String tradeNo) {
		if(tradeNo == null || "".equals(tradeNo)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select * from vip_consumption_record where tradeNo = '").append(tradeNo).append("'");
		VipConsumptionRecord v = (VipConsumptionRecord)sqldao.findEntityBySql(sourceId, sql.toString(), VipConsumptionRecord.class, closeConn, null);
		if(v == null){
			return null;
		}
		return v;
	}
	/**
	 * 查询会员消费记录列表
	 */
	@Override
	public List<VipConsumptionRecord> findVipConsumptionRecordList(String sourceId, boolean closeConn,Page page, Map<String,String> findMap) {
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from vip_consumption_record where 1 = 1 ");
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
			 sql.append("order by consumptionTime desc ");
			 params.add(findMap.get("vipUUID"));
		}
		if(page == null){
			return (List<VipConsumptionRecord>)sqldao.findListBySql(sourceId, sql.toString(),VipConsumptionRecord.class, closeConn, params);
		}else{
			return (List<VipConsumptionRecord>)sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, VipConsumptionRecord.class, page, params);
		}
	}
	

}







