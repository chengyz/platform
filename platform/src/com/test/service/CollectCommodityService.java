package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.CollectCommodity;
import com.test.entity.CommodityInfo;

import dbengine.util.Page;

/**
 * 会员收藏商品的接口
 * @author chengyz
 *
 */
public interface CollectCommodityService {
	/**
	 * 会员收藏商品
	 * @param sourceId
	 * @param closeConn
	 * @param map
	 * @return
	 */
	public boolean saveCollectCommodity(String sourceId,boolean closeConn,CollectCommodity collectCommodity);
	/**
	 * 会员取消对商品的收藏
	 * @param sourceId
	 * @param closeConn
	 * @param vipUUID
	 * @return
	 */
	public boolean cancelCollectCommodity(String sourceId,boolean closeConn,String vipUUID,String commodityUUID);
	/**
	 * 查询会员收藏的商品列表
	 * @param sourceId
	 * @param closeConn
	 * @param vipUUID
	 * @return
	 */
	public List<Map<String,String>> findCommodityList(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
	/**
	 * 查询商品
	 * @param sourceId
	 * @param closeConn
	 * @param businessUUID
	 * @return
	 */
	public CommodityInfo findCommodity(String sourceId,boolean closeConn,String commodityUUID);
	/**
	 * 查询会员是否已经收藏该商品
	 * @param sourceId
	 * @param closeConn
	 * @return
	 */
	public CollectCommodity findCollectCommodity(String sourceId,boolean closeConn,String vipUUID,String commodityUUID);
}
