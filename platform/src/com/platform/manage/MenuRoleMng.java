package com.platform.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.mysql.jdbc.StringUtils;
import com.platform.entity.MenuRole;
import com.platform.service.IMenuRoleService;
import com.platform.service.impl.MenuRoleServiceImpl;
import com.util.JsonUtil;

public class MenuRoleMng {
	
	@Auto(name=MenuRoleServiceImpl.class)
	private IMenuRoleService roleMenuService;
	
	public String addPermissionForRole(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String roleUUID = request.getParameter("roleUUID");
		String unitUUID = request.getParameter("unitUUID");
		String menuUUIDS = request.getParameter("menuUUIDS");//选择的菜单参数
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(roleUUID)&&!StringUtils.isNullOrEmpty(menuUUIDS)){
			roleMenuService.deleteMenuRole(sourceId, closeConn, roleUUID, null);
			String[] menusList = menuUUIDS.split(",");
			List<MenuRole> menuList = new ArrayList<MenuRole>();
			for (String menuUUID : menusList) {
				MenuRole menuRole = new MenuRole();
				menuRole.setRoleUUID(roleUUID);
				menuRole.setMenuUUID(menuUUID);
				menuRole.setUnitUUID(unitUUID);
				menuList.add(menuRole);
			}
			if (roleMenuService.saveMenuRole(sourceId, closeConn, menuList)){
				map.put("status", "1");
				map.put("msg", "权限分配成功");
				return JsonUtil.ObjToJson(map);
			}else{
				map.put("status", "0");
				map.put("msg", "权限分配失败");
				return JsonUtil.ObjToJson(map);
			}
		}else{
			map.put("status", "0");
			map.put("msg", "权限分配失败");
			return JsonUtil.ObjToJson(map);
		}
	}
	
	
	public String findAllMenuItemToAddPermission(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String unitUUID = request.getParameter("unitUUID");
		String roleUUID = request.getParameter("roleUUID");
		if (!StringUtils.isNullOrEmpty(unitUUID)&&!StringUtils.isNullOrEmpty(roleUUID)){
			@SuppressWarnings("rawtypes")
			List<Map> listMap = roleMenuService.findAllMenuItemForRole(sourceId, closeConn, roleUUID, unitUUID);
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
