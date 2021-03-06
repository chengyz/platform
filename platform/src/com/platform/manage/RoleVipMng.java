package com.platform.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.mysql.jdbc.StringUtils;
import com.platform.entity.RoleInfo;
import com.platform.entity.RoleVip;
import com.platform.entity.VipInfo;
import com.platform.service.IRoleVipService;
import com.platform.service.impl.RoleVipServiceImpl;
import com.util.JsonUtil;

public class RoleVipMng {

	@Auto(name=RoleVipServiceImpl.class)
	private IRoleVipService roleVipService;
	
	public String saveRoleVip(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String unitUUID = request.getParameter("unitUUID");
		String vipUUID = request.getParameter("vipUUID");
		String roleUUIDS = request.getParameter("roleUUIDS");//选择的菜单参数
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(unitUUID)&&!StringUtils.isNullOrEmpty(vipUUID)&&!StringUtils.isNullOrEmpty(roleUUIDS)){
			roleVipService.deleteRoleVip(sourceId, closeConn, null, vipUUID);
			String[] roleUUIDArray = roleUUIDS.split(",");
			List<RoleVip> roleVipList =  new ArrayList<RoleVip>();
			for (String roleUUID : roleUUIDArray){
				RoleVip roleVip = new RoleVip();
				roleVip.setRoleUUID(roleUUID);
				roleVip.setUnitUUID(unitUUID);
				roleVip.setVipUUID(vipUUID);
				roleVipList.add(roleVip);
			}
			if (roleVipService.saveRoleVip(sourceId, closeConn, roleVipList)){
				map.put("status", "1");
				map.put("msg", "角色分配成功");
				return JsonUtil.ObjToJson(map);
			}else{
				map.put("status", "0");
				map.put("msg", "角色分配失败");
				return JsonUtil.ObjToJson(map);
			}
		}else{
			map.put("status", "0");
			map.put("msg", "角色分配失败");
			return JsonUtil.ObjToJson(map);
		}
	}
	
	public String delRoleVip(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String vipUUID = request.getParameter("vipUUID");
		String roleUUID = request.getParameter("roleUUID");
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(vipUUID)||!StringUtils.isNullOrEmpty(roleUUID)){
			if (roleVipService.deleteRoleVip(sourceId, closeConn, roleUUID, vipUUID)){
				map.put("status", "1");
				map.put("msg", "成功！");
				return JsonUtil.ObjToJson(map);
			}else{
				map.put("status", "0");
				map.put("msg", "失败！");
				return JsonUtil.ObjToJson(map);
			}
		}else{
			map.put("status", "0");
			map.put("msg", "失败！");
			return JsonUtil.ObjToJson(map);
		}
	}
	
	public String findVipList(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String roleUUID = request.getParameter("roleUUID");
		if (!StringUtils.isNullOrEmpty(roleUUID)){
			List<VipInfo> list = roleVipService.findVipByRoleUUID(sourceId, closeConn, roleUUID);
			
			if (list.size()>0){
				return JsonUtil.ObjToJson(list);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
	
	public String findNotVipList(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String roleUUID = request.getParameter("roleUUID");
		if (!StringUtils.isNullOrEmpty(roleUUID)){
			List<VipInfo> list = roleVipService.findNotVipByRoleUUID(sourceId, closeConn, roleUUID);
			
			if (list.size()>0){
				return JsonUtil.ObjToJson(list);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
	
	public String findRoleList(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String vipUUID = request.getParameter("vipUUID");
		if (!StringUtils.isNullOrEmpty(vipUUID)){
			List<RoleInfo> list = roleVipService.findRoleByVipUUID(sourceId, closeConn, vipUUID);
			
			if (list.size()>0){
				return JsonUtil.ObjToJson(list);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
	
	public String findNotRoleList(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String vipUUID = request.getParameter("vipUUID");
		if (!StringUtils.isNullOrEmpty(vipUUID)){
			List<RoleInfo> list = roleVipService.findNotRoleByVipUUID(sourceId, closeConn, vipUUID);
			
			if (list.size()>0){
				return JsonUtil.ObjToJson(list);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
	
	public String findRoleToAssignRole(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String unitUUID = request.getParameter("unitUUID");
		String vipUUID = request.getParameter("vipUUID");
		if (!StringUtils.isNullOrEmpty(unitUUID)&&!StringUtils.isNullOrEmpty(vipUUID)){
			@SuppressWarnings("rawtypes")
			List<Map> listMap = roleVipService.findRoleToAssignRole(sourceId, closeConn, vipUUID,unitUUID);
			if (listMap!=null){
				return JsonUtil.ObjToJson(listMap);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
}
