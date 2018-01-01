package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.ExceptionOrder;

import dbengine.util.Page;

/**
 * 异常订单处理的service接口
 * @author chengyz
 *
 */
public interface ExceptionOrderService {
	/**
	 * 保存或修改异常订单
	 * @param sourceId
	 * @param closeConn
	 * @param order
	 * @return
	 */
	boolean saveOrUpdateExceptionOrder(String sourceId, boolean closeConn, ExceptionOrder order);
	/**
	 * 删除异常订单
	 * @param sourceId
	 * @param closeConn
	 * @param uuid
	 * @return
	 */
	boolean deleteExceptionOrder(String sourceId, boolean closeConn, String uuid);
	/**
	 * 查询异常订单
	 * @param sourceId
	 * @param closeConn
	 * @param uuid
	 * @return
	 */
	ExceptionOrder findExceptionOrder(String sourceId, boolean closeConn, String uuid);
	/**
	 * 查询异常订单列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	List<ExceptionOrder> findExceptionOrderList(String sourceId, boolean closeConn, Page page, Map findMap);
	
	
	
	
}
