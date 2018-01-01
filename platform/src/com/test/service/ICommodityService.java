package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.CommodityInfo;

import dbengine.util.Page;

/**
 * 商品service接口
 * @author hshzh
 *
 */
public interface ICommodityService {
	/**
	 * 保存或修改商品信息
	 * @param sourceId
	 * @param closeConn
	 * @param cmdtInfo
	 * @return
	 */
	public boolean saveOrUpCommodity(String sourceId,boolean closeConn,CommodityInfo cmdtInfo);
	
	/**
	 * 查商品信息
	 * @param sourceId
	 * @param closeConn
	 * @param cmdtUUID
	 * @return
	 */
	public CommodityInfo findCommodityInfo(String sourceId,boolean closeConn,String cmdtUUID);
		
	/**
	 * 查商品信息列表
	 * @param sourceId
	 * @param closeConn
	 * @param findMap
	 * @return
	 */
	public List<CommodityInfo> findCommodityList(String sourceId,boolean closeConn,Page page, Map findMap);
	
	/**
	 * 查热卖商品信息列表
	 * @param sourceId
	 * @param closeConn
	 * @param findMap
	 * @return
	 */
	public List<Map> findCommodityHotList(String sourceId,boolean closeConn,Page page, Map findMap);
	
	/**
	 * 删除商品信息列表
	 * @param sourceId
	 * @param closeConn
	 * @param cmdtUUID
	 * @return
	 */
	public boolean delCommodity(String sourceId,boolean closeConn,String cmdtUUID);
	
	/**
	 * 修改商品价格、状态、数量
	 * @param sourceId
	 * @param closeConn
	 * @param cmdtUUID
	 * @param upMap
	 * @return
	 */
	public boolean upPriceOrStateOrCount(String sourceId,boolean closeConn,String cmdtUUID,Map upMap);
	/**
	 * 后台修改或添加商品
	 * @param sourceId
	 * @param closeConn
	 * @param commodity
	 * @return
	 */
	public boolean saveOrUpdate(String sourceId, boolean closeConn, CommodityInfo commodity);
	/**
	 * 查商家商品信息列表
	 * @param sourceId
	 * @param closeConn
	 * @param findMap
	 * @return
	 */
	public List<CommodityInfo> findCommoditysList(String sourceId,boolean closeConn,Page page, String businessUUID);
}
