package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.OrderPeople;

import dbengine.util.Page;

/**
 * 订单和抢单者关联的service接口
 * @author Administrator
 *
 */
public interface OrderPeopleService {
	/**
	 * 跑客抢到一个订单则添加一条记录
	 * @param sourceId
	 * @param closeConn
	 * @param orderPeople
	 * @return
	 */
	public boolean saveOrderPeople(String sourceId,boolean closeConn,OrderPeople orderPeople);
	/**
	 * 查询跑客的订单列表信息
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public List<Map<String,String>> findOrderPeopleList(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
	/**
	 * 查询跑客的vipUUID
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public String findGetUUID(String sourceId,boolean closeConn,String orderUUID);
	/**
	 * 查询当前订单是否已经被别人抢
	 * @param sourceId
	 * @param closeConn
	 * @param orderUUID
	 * @return
	 */
	public OrderPeople findOrderPeople(String sourceId,boolean closeConn,String orderUUID);
	
}




