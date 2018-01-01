package com.test.manage;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.test.entity.SystemMessage;
import com.test.service.SystemMessageService;
import com.test.service.impl.SystemMessageServiceImpl;
import com.util.DateTimeUtil;
import com.util.JsonUtil;
import com.util.ReqToEntityUtil;
import com.util.ReqToMapUtil;

import dbengine.util.Page;

/**
 * 系统消息的manage
 * @author chengyz
 *
 */
public class SystemMessageMng {
	
	@Auto(name=SystemMessageServiceImpl.class)
	private SystemMessageService systemMessageServcie;
	/**
	 * 添加或修改系统消息
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String saveOrUpSystemMessage(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response) {
		SystemMessage order = (SystemMessage)ReqToEntityUtil.reqToEntity(request, SystemMessage.class);
		Map map = new HashMap();
		if(order == null) {
			map.put("status", "-1");
			map.put("msg", "未获取到任何信息");
			return JsonUtil.ObjToJson(map);
		}
		if(order.getId() == null) {
			order.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			order.setCreateTime(DateTimeUtil.formatDate(new Date(),"yyyy-MM-dd HH-mm-ss"));
		}
		if(systemMessageServcie.saveOrUpSystemMessage(sourceId, closeConn, order)) {
			map.put("status", "1");
			map.put("msg", "添加或修改成功");
			return JsonUtil.ObjToJson(map);
		}
		map.put("status", "-2");
		map.put("msg", "添加或修改失败");
		return JsonUtil.ObjToJson(map);
	}
	/**
	 * 查询系统消息
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findSystemMessage(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String uuid = request.getParameter("uuid");
		if(uuid != null && !"".equals(uuid)){
			SystemMessage systemMessage = systemMessageServcie.findSystemMessage(sourceId, closeConn, uuid);
			if(systemMessage == null){
				return "";
			}else{
				return JsonUtil.ObjToJson(systemMessage);
			}
		}else{
			return "";
		}
	}
	/**
	 * 删除系统消息
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String deleteSystemMessage(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String uuid = request.getParameter("uuid");
		Map<String,String> map = new HashMap<String,String>();
		if(uuid != null && !"".equals(uuid)){
			if(systemMessageServcie.deleteSystemMessage(sourceId, closeConn, uuid)){
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
			map.put("msg", "未获取到信息");
			return JsonUtil.ObjToJson(map);
		}
	}
	/**
	 * 查询系统消息列表
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findSystemMessageList(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Page page = (Page)ReqToEntityUtil.reqToEntity(request, Page.class);
		Map<String,String> findMap = ReqToMapUtil.reqToMap(request, SystemMessage.class);
		List<SystemMessage> list = systemMessageServcie.findSystemMessageList(sourceId, closeConn, page, findMap);
		if(list == null || list.size() < 1 ){
			return "[]";
		}
		if(page == null){
			return JsonUtil.ObjToJson(list);
		}else{
			return JsonUtil.ObjToJson(page);
		}
	}
	
	/**
	 * 查询系统消息所属app列表
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findAppList(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Map map = systemMessageServcie.findAppList(sourceId, closeConn);
		if(map == null) {
			return "";
		}
		return JsonUtil.ObjToJson(map);
	}
}
