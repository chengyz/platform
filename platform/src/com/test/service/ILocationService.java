package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.OrderInfo;

import dbengine.util.Page;

/**
 * 
 * 会员定位相关service接口
 * @author hshzh
 * @date 2017-3-13 上午10:31:58
 */
public interface ILocationService {
	/**
	 * 查未接单的订单
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @return
	 */
	public List<Map> findUntreatedOrders(String sourceId,boolean closeConn,Page page);
	
}
