package com.platform.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.mysql.jdbc.StringUtils;
import com.platform.entity.RoleInfo;
import com.platform.entity.RoleUser;
import com.platform.entity.UserInfo;
import com.platform.service.IRoleUserService;
import com.platform.service.impl.RoleUserServiceImpl;
import com.util.JsonUtil;

public class RoleUserMng {

	@Auto(name=RoleUserServiceImpl.class)
	private IRoleUserService roleUserService;
	
	public String saveRoleUser(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String unitUUID = request.getParameter("unitUUID");
		String userUUID = request.getParameter("userUUID");
		String roleUUIDS = request.getParameter("roleUUIDS");//选择的菜单参数
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(unitUUID)&&!StringUtils.isNullOrEmpty(userUUID)&&!StringUtils.isNullOrEmpty(roleUUIDS)){
			roleUserService.deleteRoleUser(sourceId, closeConn, null, userUUID);
			String[] roleUUIDArray = roleUUIDS.split(",");
			List<RoleUser> roleUserList =  new ArrayList<RoleUser>();
			for (String roleUUID : roleUUIDArray){
				RoleUser roleUser = new RoleUser();
				roleUser.setRuUUID(UUID.randomUUID().toString());
				roleUser.setRoleUUID(roleUUID);
				roleUser.setUnitUUID(unitUUID);
				roleUser.setUserUUID(userUUID);
				roleUserList.add(roleUser);
			}
			if (roleUserService.saveRoleUser(sourceId, closeConn, roleUserList)){
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
	
	public String delRoleUser(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String userUUID = request.getParameter("userUUID");
		String roleUUID = request.getParameter("roleUUID");
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(userUUID)||!StringUtils.isNullOrEmpty(roleUUID)){
			if (roleUserService.deleteRoleUser(sourceId, closeConn, roleUUID, userUUID)){
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
	
	public String findUserList(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String roleUUID = request.getParameter("roleUUID");
		if (!StringUtils.isNullOrEmpty(roleUUID)){
			List<UserInfo> list = roleUserService.findUserByRoleUUID(sourceId, closeConn, roleUUID);
			
			if (list.size()>0){
				return JsonUtil.ObjToJson(list);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
	
	public String findNotUserList(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String roleUUID = request.getParameter("roleUUID");
		if (!StringUtils.isNullOrEmpty(roleUUID)){
			List<UserInfo> list = roleUserService.findNotUserByRoleUUID(sourceId, closeConn, roleUUID);
			
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
		String userUUID = request.getParameter("userUUID");
		if (!StringUtils.isNullOrEmpty(userUUID)){
			List<RoleInfo> list = roleUserService.findRoleByUserUUID(sourceId, closeConn, userUUID);
			
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
		String userUUID = request.getParameter("userUUID");
		if (!StringUtils.isNullOrEmpty(userUUID)){
			List<RoleInfo> list = roleUserService.findNotRoleByUserUUID(sourceId, closeConn, userUUID);
			
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
		String userUUID = request.getParameter("userUUID");
		if (!StringUtils.isNullOrEmpty(unitUUID)&&!StringUtils.isNullOrEmpty(userUUID)){
			@SuppressWarnings("rawtypes")
			List<Map> listMap = roleUserService.findRoleToAssignRole(sourceId, closeConn, userUUID,unitUUID);
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
