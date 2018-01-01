package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.ChangeTime;

import dbengine.util.Page;

/**
 * 订单支付和扫描的时间 接口
 * @author chengyz
 *
 */
public interface ChangeTimeService {
	/**
	 * 添加或修改各种时间
	 * @param sourceId
	 * @param closeConn
	 * @param changeTime
	 * @return
	 */
	public boolean saveOrUpChangeTime(String sourceId,boolean closeConn,ChangeTime changeTime);
	/**
	 * 查询各种时间
	 * @param sourceId
	 * @param closeConn
	 * @param timeUUID
	 * @return
	 */
	public ChangeTime findChangeTime(String sourceId,boolean closeConn,String timeUUID);
	/**
	 * 通过所属平台查询各种时间
	 * @param sourceId
	 * @param closeConn
	 * @param timeUUID
	 * @return
	 */
	public ChangeTime findTimeByBelong(String sourceId,boolean closeConn,String belongPlatform);
	/**
	 * 删除各种时间
	 * @param sourceId
	 * @param closeConn
	 * @param timeUUID
	 * @return
	 */
	public boolean deleteChangeTime(String sourceId,boolean closeConn,String timeUUID);
	/**
	 * 查询各种时间列表
	 * @param sourceId
	 * @param closeConn
	 * @param findMap
	 * @return
	 */
	public List<ChangeTime> findTimeList(String sourceId,boolean closeConn,Page page);
	
	
}
