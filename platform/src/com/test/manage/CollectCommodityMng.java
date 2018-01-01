package com.test.manage;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.test.entity.BusinessInfo;
import com.test.entity.CollectBusiness;
import com.test.entity.CollectCommodity;
import com.test.entity.CommodityInfo;
import com.test.service.CollectCommodityService;
import com.test.service.impl.CollectCommodityServiceImpl;
import com.util.DateTimeUtil;
import com.util.JsonUtil;
import com.util.ReqToEntityUtil;
import com.util.ReqToMapUtil;

import dbengine.util.Page;

/**
 * 会员收藏商品的管理
 * @author chengyz
 *
 */
public class CollectCommodityMng {
	@Auto(name=CollectCommodityServiceImpl.class)
	private CollectCommodityService collectCommodityService;
	
	/**
	 * 查询收藏商品
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findCommodity(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String commodityUUID = request.getParameter("commodityUUID");
		if(commodityUUID != null && !"".equals(commodityUUID)){
			CommodityInfo commodity = collectCommodityService.findCommodity(sourceId, closeConn, commodityUUID);
			if(commodity != null){
				return JsonUtil.ObjToJson(commodity);
			}else{
				return "[]";
			}
		}else{
			return "[]";
		}
		
	}
	/**
	 * 取消收藏商品
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String cancelCollectCommodity(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String vipUUID = request.getParameter("vipUUID");
		String commodityUUID = request.getParameter("commodityUUID");
		Map<String, String> map =  new HashMap<String, String>();
		if(vipUUID != null && !"".equals(vipUUID)){
			if(collectCommodityService.cancelCollectCommodity(sourceId, closeConn, vipUUID,commodityUUID)){
				map.put("status", "2");
				map.put("msg", "成功");
				return JsonUtil.ObjToJson(map);
			}else{
				map.put("status", "1");
				map.put("msg", "失败");
				return JsonUtil.ObjToJson(map);
			}
		}else{
			map.put("status", "-1");
			map.put("msg", "未获取到任何信息");
			return JsonUtil.ObjToJson(map);
		}
	}
	/**
	 * 会员收藏商品
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String saveCommodity(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Map<String,String> map = new HashMap<String,String>();
		String num = request.getParameter("vipPhoneNumber");
		String vip = request.getParameter("vipUUID");
		String com = request.getParameter("commodityUUID");
		if(num != null && !"".equals(num) && vip != null && !"".equals(vip) && com != null && !"".equals(com)){
			//先查询是否已经收藏该商品
			CollectCommodity collectCommodity = collectCommodityService.findCollectCommodity(sourceId, closeConn, vip, com);
			if(collectCommodity != null){
				map.put("status", "-2");
				map.put("msg", "已经收藏该商品");
				return JsonUtil.ObjToJson(map);
			}
			collectCommodity = new CollectCommodity();
			collectCommodity.setCommodityUUID(com);
			collectCommodity.setVipUUID(vip);
			collectCommodity.setCollectUUID(UUID.randomUUID().toString());
			collectCommodity.setVipPhoneNumber(num);
			collectCommodity.setCollectTime(DateTimeUtil.formatDate((new Date()), "yyyy-MM-dd HH:mm:ss"));
			if(collectCommodityService.saveCollectCommodity(sourceId, closeConn, collectCommodity)){
				map.put("status", "2");
				map.put("msg", "收藏成功");
				return JsonUtil.ObjToJson(map);
			}else{
				map.put("status", "1");
				map.put("msg", "收藏失败");
				return JsonUtil.ObjToJson(map);
			}
		}else{
			map.put("status", "-1");
			map.put("msg", "未获取到信息");
			return JsonUtil.ObjToJson(map);
		}
		
	}
	/**
	 * 查询会员收藏的商品列表
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findCommodityList(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Map<String,String> findMap = ReqToMapUtil.reqToMap(request,CollectCommodity.class);
		Page page = (Page)ReqToEntityUtil.reqToEntity(request, Page.class); 
		List<Map<String,String>> list = (List<Map<String,String>>)collectCommodityService.findCommodityList(sourceId, closeConn,page,findMap);
		if(list == null || list.size() < 1){
			return "[]";
		}
		if(page == null){
			return JsonUtil.ObjToJson(list);
		}else{
			return JsonUtil.ObjToJson(page);
		}
	}
}
