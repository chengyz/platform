package com.test.service.impl;

import java.util.List;
import java.util.Map;

import spark.annotation.Auto;

import com.test.entity.OrderPeople;
import com.test.service.OrderPeopleService;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import dbengine.util.Page;
/**
 * 抢单的service实现
 * @author chengyz
 *
 */
public class OrderPeopleServiceImpl implements OrderPeopleService {
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	@Auto(name=EntityDao.class)
	private EntityDao entityDao;
	/**
	 * 保存抢单记录
	 */
	@Override
	public boolean saveOrderPeople(String sourceId, boolean closeConn, OrderPeople orderPeople) {
		if(orderPeople == null){
			return false;
		}
		return entityDao.saveEntity(sourceId, orderPeople, closeConn);
	}
	/**
	 * 查询抢单记录列表
	 */
	@Override
	public List<Map<String, String>> findOrderPeopleList(String sourceId, boolean closeConn, Page page, Map<String, String> findMap) {
		return null;
	}
	/**
	 * 查询跑客的UUID
	 */
	@Override
	public String findGetUUID(String sourceId, boolean closeConn, String orderUUID) {
		if(orderUUID == null || "".equals(orderUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select getUUID as getUUID from order_people where orderUUID = '").append(orderUUID).append("'");
		Map map = sqldao.findMapBysql(sourceId, sql.toString(), closeConn, null);
		if(map.get("getUUID") != null && !"".equals(map.get("getUUID"))){
			return map.get("getUUID").toString();
		}else{
			return null;
		}
	}
	
	/**
	 * 查询当前订单是否被别人抢
	 */
	
	@Override
	public OrderPeople findOrderPeople(String sourceId, boolean closeConn, String orderUUID) {
		if(orderUUID != null && !"".equals(orderUUID)){
			StringBuilder sql = new StringBuilder();
			sql.append("select * from order_people where orderUUID = '").append(orderUUID).append("'");
			OrderPeople orderPeople = (OrderPeople)sqldao.findEntityBySql(sourceId, sql.toString(), OrderPeople.class, closeConn, null);
			if(orderPeople != null){
				return orderPeople;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

}
