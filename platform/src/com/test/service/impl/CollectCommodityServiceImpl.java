package com.test.service.impl;

import java.util.List;
import java.util.Map;

import spark.annotation.Auto;

import com.test.entity.CollectBusiness;
import com.test.entity.CollectCommodity;
import com.test.entity.CommodityInfo;
import com.test.service.CollectCommodityService;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import dbengine.util.Page;
/**
 * 会员收藏商品接口实现
 * @author chengyz
 *
 */
public class CollectCommodityServiceImpl implements CollectCommodityService {
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	
	@Auto(name=EntityDao.class)
	private EntityDao entityDao;
	/**
	 * 会员收藏商品
	 */
	@Override
	public boolean saveCollectCommodity(String sourceId, boolean closeConn,CollectCommodity collectCommodity) {
		if(collectCommodity == null){
			return false;
		}
		return entityDao.saveEntity(sourceId, collectCommodity, closeConn);
	}
	/**
	 * 会员取消商品的收藏
	 */
	@Override
	public boolean cancelCollectCommodity(String sourceId, boolean closeConn, String vipUUID,String commodityUUID) {
		StringBuilder sql = new StringBuilder();
		if(vipUUID != null && !"".equals(vipUUID) && commodityUUID != null && !"".equals(commodityUUID)){
			sql.append("delete from collect_commodity where vipUUID = '").append(vipUUID).append("'");
			sql.append(" and commodityUUID ='").append(commodityUUID).append("'");
			return sqldao.executeSql(sourceId, sql.toString(), closeConn,null);
		}else{
			return false;
		}
	}
	/**
	 * 查询会员收藏商品列表
	 */
	@Override
	public List<Map<String,String>> findCommodityList(String sourceId, boolean closeConn, Page page, Map<String,String> findMap) {
		StringBuilder sql = new StringBuilder();
		sql.append("select b.*,c.* from commodity_info b join collect_commodity c on b.cmdtUUID = c.commodityUUID ");
		if(findMap.get("vipPhoneNumber") != null && !"".equals(findMap.get("vipPhoneNumber"))){
			sql.append(" and vipPhoneNumber = '").append(findMap.get("vipPhoneNumber").replace("'", "")).append("'");
		}
		if(findMap.get("vipUUID") != null && !"".equals(findMap.get("vipUUID"))){
			sql.append(" and vipUUID = '").append(findMap.get("vipUUID").replace("'", "")).append("'");
		}
		if(page == null){
			return sqldao.findMapListBysql(sourceId, sql.toString(), closeConn, null);
		}else{
			return sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, null, page, null);
		}
	}
	/**
	 * 查询商品
	 */
	@Override
	public CommodityInfo findCommodity(String sourceId, boolean closeConn, String commodityUUID) {
		if(commodityUUID != null && !"".equals(commodityUUID)){
			StringBuilder sql = new StringBuilder();
			sql.append("select * from commodity_info where commodityUUID = '").append(commodityUUID).append("'");
			return (CommodityInfo)sqldao.findEntityBySql(sourceId, sql.toString(), CommodityInfo.class, closeConn, null);
		}else{
			return null;
		}
	}
	/**
	 * 查询会员是否已经收藏该商家
	 * @param sourceId
	 * @param closeConn
	 * @param vipUUID
	 * @param commodityUUID
	 * @return
	 */
	@Override
	public CollectCommodity findCollectCommodity(String sourceId, boolean closeConn, String vipUUID, String commodityUUID) {
		if(vipUUID != null && !"".equals(vipUUID) && commodityUUID != null && !"".equals(commodityUUID)){
			StringBuilder sql = new StringBuilder();
			sql.append("select * from collect_commodity where commodityUUID = '").append(commodityUUID).append("'");
			sql.append(" and vipUUID = '").append(vipUUID).append("'");
			return (CollectCommodity)sqldao.findEntityBySql(sourceId, sql.toString(), CollectCommodity.class, closeConn, null);
		}else{
			return null;
		}
	}

}
