package com.platform.manage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.mysql.jdbc.StringUtils;
import com.platform.entity.TradeType;
import com.platform.service.ITradeTypeService;
import com.platform.service.impl.TradeTypeServiceImpl;
import com.util.DateUtil;
import com.util.JsonUtil;
import com.util.ReqToEntityUtil;
import com.util.ReqToMapUtil;

import dbengine.util.Page;

public class TradeTypeMng {

	@Auto(name=TradeTypeServiceImpl.class)
	private ITradeTypeService tradeService;
	
	public String saveTradeType(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		TradeType trade = (TradeType) ReqToEntityUtil.reqToEntity(request, TradeType.class);
		Map<String, String> map = new HashMap<String, String>();
		if (trade==null){
			map.put("status", "2");
			map.put("msg", "未输入任何行业信息");
			return JsonUtil.ObjToJson(map);
		}
		if (trade.getId()==null){
			trade.setTypeUUID(UUID.randomUUID().toString());
			trade.setTypeCode(tradeService.getNextTradeCode(sourceId, closeConn, trade.getTypeParentCode()));
			trade.setTypeCreateTime(DateUtil.formatDateTime(new Date()));
			trade.setTypeCreateUserUUID("321");
			trade.setTypeCreateUserName("321");
		}else{
			trade.setTypeUpTime(DateUtil.formatDateTime(new Date()));
			trade.setTypeUpUserUUID("123");
			trade.setTypeUpUserName("31");
		}
		if (tradeService.saveOrUpTradeType(sourceId, closeConn, trade)){
			map.put("status", "1");
			map.put("msg", "成功");
			return JsonUtil.ObjToJson(map);
		}else{
			map.put("status", "0");
			map.put("msg", "失败");
			return JsonUtil.ObjToJson(map);
		}
	}
	public String delTradeType(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String ids = request.getParameter("ids");
		String uuids = request.getParameter("uuids");
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(ids)){
			String[] idArr = ids.split("_");
			for (String id : idArr) {
				tradeService.delTradeTypeById(sourceId, closeConn, id);
			}
			map.put("status", "1");
			map.put("msg", "行业信息删除成功");
			return JsonUtil.ObjToJson(map);
		}else if (!StringUtils.isNullOrEmpty(uuids)){
			String[] uuidArr = uuids.split("_");
			for (String uuid : uuidArr) {
				tradeService.delTradeTypeByUUID(sourceId, closeConn, uuid);
			}
			map.put("status", "1");
			map.put("msg", "行业信息删除成功");
			return JsonUtil.ObjToJson(map);
		}else{
			map.put("status", "0");
			map.put("msg", "行业信息删除失败");
			return JsonUtil.ObjToJson(map);
		}
	}
	public String findTradeType(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String uuid = request.getParameter("uuid");
		if (!StringUtils.isNullOrEmpty(id)){
			TradeType trade = tradeService.findTradeTypeById(sourceId, closeConn, id);
			if (trade!=null){
				return JsonUtil.ObjToJson(trade);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else if (!StringUtils.isNullOrEmpty(uuid)){
			TradeType trade = tradeService.findTradeTypeByUUID(sourceId, closeConn, uuid);
			if (trade!=null){
				return JsonUtil.ObjToJson(trade);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
	public String findTradeTypeListMap(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		Page page = (Page)ReqToEntityUtil.reqToEntity(request, Page.class);
		Map<String,String> findMap =  ReqToMapUtil.reqToMap(request, TradeType.class);
		@SuppressWarnings("rawtypes")
		List<Map> list = tradeService.findTradeTypeListMap(sourceId, closeConn, page, findMap);
		if (page!=null){
			return JsonUtil.ObjToJson(page);
		}else if (list!=null){
			return JsonUtil.ObjToJson(list);
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
	
	public String findTradeTree(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		Map<String,String> findMap = new HashMap<String, String>();
		findMap.put("menuName",request.getParameter("userQuery"));
		findMap.put("menuUrl",request.getParameter("userQuery"));
		List<TradeType> tradeList = (List<TradeType>)tradeService.findTradeTypeList(sourceId, closeConn, findMap);
		if(tradeList==null){
			return "[]";
		}else{
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			for(TradeType trade :tradeList){
				Map<String,Object> attributes = new HashMap<String,Object>();
				attributes.put("id", trade.getTypeCode());
				attributes.put("name", trade.getTypeName());
				attributes.put("pId", trade.getTypeParentCode());
				attributes.put("open", "true");// 默认打开树
				attributes.put("nocheck", true);//是否没有选择框
				attributes.put("checked", false);//是否选中
				attributes.put("typeUUID", trade.getTypeUUID());//菜单UUID
				attributes.put("typeCode", trade.getTypeCode());//
				attributes.put("typeName", trade.getTypeName());//
				attributes.put("typeParentCode", trade.getTypeParentCode());//
				attributes.put("typePermission", trade.getTypeName());//菜单权限名称
				attributes.put("typeUrl", trade.getTypeUrl());//菜单地址
				attributes.put("typeType", trade.getTypeType());//菜单类型
				attributes.put("typeHaveLowerNode", trade.getTypeHaveLowerNode());//是否有下级节点
				attributes.put("ecUUID", null);//ecUUID
				mapList.add(attributes);
			}
			return JsonUtil.ObjToJson(mapList);
		}
	}
	
	
	public String findTypeParentCodeList(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		List<String> list = tradeService.getParentTradeCode(sourceId, closeConn);
		if (list.size()>0){
			return JsonUtil.ObjToJson(list);
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
	
	public String findTypeNameToAutoComplete(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String typeName = request.getParameter("query");
		if(typeName==null || "".equals(typeName)){
			return "[]";
		}
		List<Map<String, String>> list = tradeService.findTypeNameToAutocompleter("jdbcread", false, typeName);
		if(list == null) {
			return "[]";
		}
		return JsonUtil.ObjToJson(list);
	}
}
