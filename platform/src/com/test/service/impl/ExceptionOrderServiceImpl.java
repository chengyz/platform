package com.test.service.impl;

import java.util.List;
import java.util.Map;

import spark.annotation.Auto;

import com.test.entity.ExceptionOrder;
import com.test.service.ExceptionOrderService;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import dbengine.util.Page;
/**
 * 异常订单处理列表的service实现
 * @author chengyz
 *
 */

public class ExceptionOrderServiceImpl implements ExceptionOrderService {
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	@Auto(name=EntityDao.class)
	private EntityDao entityDao;
	/**
	 * 保存或修改异常订单处理信息
	 */
	@Override
	public boolean saveOrUpdateExceptionOrder(String sourceId, boolean closeConn, ExceptionOrder order) {
		if(order == null) {
			return false;
		}
		if(order.getId() == null) {
			return entityDao.saveEntity(sourceId, order, closeConn);
		} else {
			return entityDao.updateEntity(sourceId, order, closeConn);
		}
	}
	/**
	 * 删除异常订单处理信息
	 */
	@Override
	public boolean deleteExceptionOrder(String sourceId, boolean closeConn, String uuid) {
		if(uuid == null || "".equals(uuid) || "null".equals(uuid)) {
			return false;
		}
		String sql = "delete from exception_order where uuid = '"+uuid+"'";
		return sqldao.executeSql(sourceId, sql, closeConn, null);
	}
	/**
	 * 查询异常订单处理信息
	 */
	@Override
	public ExceptionOrder findExceptionOrder(String sourceId, boolean closeConn, String uuid) {
		if(uuid == null || "".equals(uuid) || "null".equals(uuid)) {
			return null;
		}
		String sql = "select * from exception_order where uuid = '"+uuid+"'";
		return (ExceptionOrder)sqldao.findEntityBySql(sourceId, sql, ExceptionOrder.class, closeConn, null);
	}
	/**
	 * 查询异常订单处理列表
	 */
	@Override
	public List<ExceptionOrder> findExceptionOrderList(String sourceId, boolean closeConn, Page page, Map findMap) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from exception_order where 1 = 1 ");
		if(findMap != null) {
			if(findMap.get("handleStatus") != null && !"".equals(findMap.get("handleStatus")) && !"".equals(findMap.get("handleStatus"))) {
				sql.append(" and handleStatus = '").append(findMap.get("handleStatus")).append("'");
			}
			if(findMap.get("orderNumber") != null && !"".equals(findMap.get("orderNumber")) && !"".equals(findMap.get("orderNumber"))) {
				sql.append(" and orderNumber = '").append(findMap.get("orderNumber")).append("'");
			}
			if(findMap.get("orderType") != null && !"".equals(findMap.get("orderType")) && !"".equals(findMap.get("orderType"))) {
				sql.append(" and orderType = '").append(findMap.get("orderType")).append("'");
			}
			if(findMap.get("vipUUID") != null && !"".equals(findMap.get("vipUUID")) && !"".equals(findMap.get("vipUUID"))) {
				sql.append(" and vipUUID = '").append(findMap.get("vipUUID")).append("'");
			}
			if(findMap.get("getVipUUID") != null && !"".equals(findMap.get("getVipUUID")) && !"".equals(findMap.get("getVipUUID"))) {
				sql.append(" and getVipUUID = '").append(findMap.get("getVipUUID")).append("'");
			}
		}
		if(page == null) {
			return sqldao.findListBySql(sourceId, sql.toString(), ExceptionOrder.class, closeConn, null);
		}else{
			return sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, ExceptionOrder.class, page, null);
		}
	}

	

}