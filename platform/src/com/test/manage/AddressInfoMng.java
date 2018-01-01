package com.test.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.test.entity.AddressInfo;
import com.test.service.AddressInfoService;
import com.test.service.impl.AddressInfoServiceImpl;
import com.util.JsonUtil;
import com.util.MD5;
import com.util.ReqToEntityUtil;
import com.util.ReqToMapUtil;

import dbengine.util.Page;

/**
 * 地址信息的manage
 * @author chengyz
 *
 */
public class AddressInfoMng {
	
	@Auto(name=AddressInfoServiceImpl.class)
	private AddressInfoService addressInfoService;
	/**
	 * 查询地址
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findAddress(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String addressUUID = request.getParameter("addressUUID");
		if(addressUUID != null && !"".equals(addressUUID) || !"null".equals(addressUUID)){
			AddressInfo address = addressInfoService.findAddress(sourceId, closeConn, addressUUID);
			if(address != null){
				return JsonUtil.ObjToJson(address);
			}else{
				return "[]";
			}
		}else{
			return "[]";
		}
		
	}
	
	/**
	 * 删除地址
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String deleteAddress(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String addressUUID = request.getParameter("addressUUID");
		String vipUUID = request.getParameter("vipUUID");
		Map<String, String> map =  new HashMap<String, String>();
		if(addressUUID != null && !"".equals(addressUUID) && !"null".equals(addressUUID)){
			if(addressInfoService.deleteAddress(sourceId, closeConn, addressUUID, vipUUID)){
				map.put("status", "1");
				map.put("msg", "成功");
				return JsonUtil.ObjToJson(map);
			}else{
				map.put("status", "0");
				map.put("msg", "失败");
				return JsonUtil.ObjToJson(map);
			}
		}else{
			map.put("status", "0");
			map.put("msg", "未获取到任何信息");
			return JsonUtil.ObjToJson(map);
		}
	}
	/**
	 * 管理后台直接删除地址
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String delAddress(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String addressUUID = request.getParameter("uuids");
		Map<String, String> map =  new HashMap<String, String>();
		if(addressUUID != null && !"".equals(addressUUID)){
			if(addressInfoService.delAddress(sourceId, closeConn, addressUUID)){
				map.put("status", "1");
				map.put("msg", "成功");
				return JsonUtil.ObjToJson(map);
			}else{
				map.put("status", "0");
				map.put("msg", "失败");
				return JsonUtil.ObjToJson(map);
			}
		}else{
			map.put("status", "0");
			map.put("msg", "未获取到任何信息");
			return JsonUtil.ObjToJson(map);
		}
	}
	/**
	 * 保存或修改地址
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String saveOrUpAddress(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		AddressInfo address = (AddressInfo)ReqToEntityUtil.reqToEntity(request, AddressInfo.class);
		String  vipUUID = request.getParameter("vipUUID");
		String vipPhoneNumber = request.getParameter("vipPhoneNumber");
		String contactPhoneNumber = request.getParameter("contactPhoneNumber");
		String houseNumber = request.getParameter("houseNumber");
		Map<String,String> map = new HashMap<String,String>();
		if(address == null || vipUUID == null || "".equals(vipUUID)){
			map.put("status", "-1");
			map.put("msg", "未获取到信息");
			return JsonUtil.ObjToJson(map);
		}
		
		Map<String,String> maps = new HashMap<String,String>();
		maps.put("vipUUID", vipUUID);
		maps.put("vipPhoneNumber", vipPhoneNumber);
		maps.put("contactPhoneNumber", contactPhoneNumber);
		maps.put("houseNumber", houseNumber);
		
		String addressUUID = addressInfoService.saveOrUpAddress(sourceId, closeConn, address,maps);
		if("-2".equals(addressUUID)){
			map.put("status", "-2");
			map.put("msg", "已经收藏该地址");
			return JsonUtil.ObjToJson(map);
		}else{
			map.put("addressUUID", addressUUID);
			map.put("status", "1");
			map.put("msg", "收藏成功");
			return JsonUtil.ObjToJson(map);
		}
	}
	/**
	 * 查询地址列表
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findAddressList(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Map<String,String> findMap  = ReqToMapUtil.reqToMap(request, AddressInfo.class);
		String vipPhoneNumber = request.getParameter("vipPhoneNumber");
		String vipUUID = request.getParameter("vipUUID");
		findMap.put("vipPhoneNumber", vipPhoneNumber);
		findMap.put("vipUUID", vipUUID);
		Page page = (Page)ReqToEntityUtil.reqToEntity(request, Page.class);
		List<Map> addresslist = (List<Map>)addressInfoService.findAddressList(sourceId, closeConn, page, findMap);
		if(addresslist == null || addresslist.size() < 1){
			return "[]";
		}
		if(page == null){
			return JsonUtil.ObjToJson(addresslist);
		}else{
			return JsonUtil.ObjToJson(page);
		}
	}
}
