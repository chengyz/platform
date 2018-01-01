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
import com.test.entity.VipSendAddress;
import com.test.service.CollectBusinessService;
import com.test.service.impl.CollectBusinessServiceImpl;
import com.util.DateTimeUtil;
import com.util.JsonUtil;
import com.util.ReqToEntityUtil;
import com.util.ReqToMapUtil;

import dbengine.util.Page;

/**
 * 会员收藏商家的管理
 * @author chengyz
 *
 */
public class CollectBusinessMng {
	@Auto(name=CollectBusinessServiceImpl.class)
	private CollectBusinessService collectBusinessService;
	
	/**
	 * 查询收藏商家
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findBusiness(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String businessUUID = request.getParameter("businessUUID");
		if(businessUUID != null && !"".equals(businessUUID)){
			BusinessInfo business = collectBusinessService.findBusiness(sourceId, closeConn, businessUUID);
			if(business != null){
				return JsonUtil.ObjToJson(business);
			}else{
				return "[]";
			}
		}else{
			return "[]";
		}
		
	}
	/**
	 * 取消收藏商家
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String cancelCollectBusiness(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String vipUUID = request.getParameter("vipUUID");
		String businessUUID = request.getParameter("businessUUID");
		Map<String, String> map =  new HashMap<String, String>();
		if(vipUUID == null || "".equals(vipUUID) || "null".equals(vipUUID) || businessUUID == null || "".equals(businessUUID) || "null".equals(businessUUID)){
			map.put("status", "-1");
			map.put("msg", "未获取到任何信息");
			return JsonUtil.ObjToJson(map);
		}
		if(collectBusinessService.cancelCollectBusiness(sourceId, closeConn, vipUUID,businessUUID)){
			map.put("status", "2");
			map.put("msg", "成功");
			return JsonUtil.ObjToJson(map);
		}else{
			map.put("status", "1");
			map.put("msg", "失败");
			return JsonUtil.ObjToJson(map);
		}
	}
	/**
	 * 会员收藏商家
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String saveBusiness(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Map<String,String> map = new HashMap<String,String>();
		String num = request.getParameter("vipPhoneNumber");
		String vip = request.getParameter("vipUUID");
		String bus = request.getParameter("businessUUID");
		if(num != null && !"".equals(num) && vip != null && !"".equals(vip) && bus != null && !"".equals(bus)){
			//先查询是否已经收藏该商家
			CollectBusiness collectBusiness = collectBusinessService.findCollectBusiness(sourceId, closeConn, vip, bus);
			if(collectBusiness != null){
				map.put("status", "-2");
				map.put("msg", "已经收藏该商家");
				return JsonUtil.ObjToJson(map);
			}
			collectBusiness = new CollectBusiness();
			collectBusiness.setBusinessUUID(bus);
			collectBusiness.setVipUUID(vip);
			collectBusiness.setCollectUUID(UUID.randomUUID().toString());
			collectBusiness.setVipPhoneNumber(num);
			collectBusiness.setCollectTime(DateTimeUtil.formatDate((new Date()), "yyyy-MM-dd HH:mm:ss"));
			if(collectBusinessService.saveCollectBusiness(sourceId, closeConn, collectBusiness)){
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
	 * 查询会员收藏的商家列表
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findBusinessList(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Map<String,String> findMap = ReqToMapUtil.reqToMap(request,CollectBusiness.class);
		String businessFullName = request.getParameter("businessName");//商家名称 
		if(findMap == null){
			return "[]";
		}
		findMap.put("businessFullName", businessFullName);
		Page page = (Page)ReqToEntityUtil.reqToEntity(request, Page.class); 
		List<Map<String,String>> list = (List<Map<String,String>>)collectBusinessService.findBusinessList(sourceId, closeConn,page,findMap);
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






















