package com.test.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.test.entity.VipSendAddress;
import com.test.service.VipSendAddressService;
import com.test.service.impl.VipSendAddressServiceImpl;
import com.util.JsonUtil;
import com.util.ReqToEntityUtil;
import com.util.ReqToMapUtil;

import dbengine.util.Page;

/**
 * 会员收货地址的管理
 * @author chengyz
 *
 */
public class VipSendAddressMng {
	@Auto(name=VipSendAddressServiceImpl.class)
	private VipSendAddressService vipSendAddressService;
	
	/**
	 * 查询收货地址
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findAddress(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String addressUUID = request.getParameter("addressUUID");
		if(addressUUID != null && !"".equals(addressUUID)){
			VipSendAddress address = vipSendAddressService.findAddress(sourceId, closeConn, addressUUID);
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
		Map<String, String> map =  new HashMap<String, String>();
		if(addressUUID != null && !"".equals(addressUUID)){
			if(vipSendAddressService.deleteAddress(sourceId, closeConn, addressUUID)){
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
	 * 保存地址
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String saveAddress(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		VipSendAddress address = (VipSendAddress)ReqToEntityUtil.reqToEntity(request, VipSendAddress.class);
		Map<String,String> map = new HashMap<String,String>();
		if(address == null){
			map.put("status", "-1");
			map.put("msg", "未获取到信息");
			return JsonUtil.ObjToJson(map);
		}
		if(vipSendAddressService.saveAddress(sourceId, closeConn, address)){
			map.put("status", "2");
			map.put("msg", "添加成功");
			return JsonUtil.ObjToJson(map);
		}else{
			map.put("status", "1");
			map.put("msg", "添加失败");
			return JsonUtil.ObjToJson(map);
		}
	}
	/**
	 * 查询收货地址列表
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findAddressList(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Map<String,String> findMap  = ReqToMapUtil.reqToMap(request, VipSendAddress.class);
		Page page = (Page)ReqToEntityUtil.reqToEntity(request, Page.class);
		List<VipSendAddress> addresslist = (List<VipSendAddress>)vipSendAddressService.findAddressList(sourceId, closeConn, page, findMap);
		if(addresslist == null || addresslist.size() < 1){
			return "[]";
		}
		if(page == null){
			return JsonUtil.ObjToJson(addresslist);
		}else{
			return JsonUtil.ObjToJson(page);
		}
	}
	/**
	 * 修改默认  收货地址
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String updataDefaultAddress(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Map<String,String> map = new HashMap<String,String>();
		VipSendAddress address = (VipSendAddress)ReqToEntityUtil.reqToEntity(request, VipSendAddress.class);
		if(address != null){
			if(vipSendAddressService.updataDefaultAddress(sourceId, closeConn,address)){
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
	 * 会员取消或设置为默认地址
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String cancelDefaultAddress(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Map<String,String> map = new HashMap<String,String>();
		String addressUUID = request.getParameter("addressUUID");
		String vipUUID = request.getParameter("vipUUID");
		if(addressUUID != null && !"".equals(addressUUID) && vipUUID != null && !"".equals(vipUUID)){
			if(vipSendAddressService.cancelDefaultAddress(sourceId, closeConn, addressUUID, vipUUID)){
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
	 * 查询默认收货地址
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findDefaultAddress(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String vipUUID = request.getParameter("vipUUID");
		if(vipUUID != null && !"".equals(vipUUID)){
			VipSendAddress address = vipSendAddressService.findDefaultAddress(sourceId, closeConn, vipUUID);
			if(address != null){
				return JsonUtil.ObjToJson(address);
			}else{
				return "[]";
			}
		}else{
			return "[]";
		}
	}
}






















