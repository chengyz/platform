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
import com.platform.entity.MenuInfo;
import com.platform.entity.MenuRole;
import com.platform.entity.MenuUnit;
import com.platform.entity.RoleInfo;
import com.platform.entity.RoleUser;
import com.platform.entity.UnitInfo;
import com.platform.entity.UserInfo;
import com.platform.service.IMenuInfoService;
import com.platform.service.IMenuRoleService;
import com.platform.service.IMenuUnitService;
import com.platform.service.IRoleUserService;
import com.platform.service.IUnitInfoService;
import com.platform.service.IUserService;
import com.platform.service.impl.MenuInfoServiceImpl;
import com.platform.service.impl.MenuRoleServiceImpl;
import com.platform.service.impl.MenuUnitServiceImpl;
import com.platform.service.impl.RoleUserServiceImpl;
import com.platform.service.impl.UnitInfoServiceImpl;
import com.platform.service.impl.UserServiceImpl;
import com.util.DateTimeUtil;
import com.util.DateUtil;
import com.util.JsonUtil;
import com.util.MD5;
import com.util.ReadProperties;
import com.util.ReqToEntityUtil;
import com.util.ReqToMapUtil;

import dbengine.util.Page;

/**
 * 单位（企业）信息管理层
 * @author fengxuefeng
 *
 */
public class UnitInfoMng {

	@Auto(name=UnitInfoServiceImpl.class)
	private IUnitInfoService unitService;
	
	@Auto(name=UserServiceImpl.class)
	private IUserService userService;
	
	@Auto(name=MenuInfoServiceImpl.class)
	private IMenuInfoService menuService;
	
	@Auto(name=MenuUnitServiceImpl.class)
	private IMenuUnitService menuUnitService;
	
	@Auto(name=MenuRoleServiceImpl.class)
	private IMenuRoleService menuRoleService;
	
	@Auto(name=RoleUserServiceImpl.class)
	private IRoleUserService roleUserService;
	
	
	
	/**
	 * 保存或更新单位（企业）数据
	 */
	public String saveOrUpUnit(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		UnitInfo unitInfo = (UnitInfo)ReqToEntityUtil.reqToEntity(request, UnitInfo.class);
		UserInfo user = (UserInfo) ReqToEntityUtil.reqToEntity(request, UserInfo.class);
		String userId = request.getParameter("userId");
		String userUnitUUID = request.getParameter("userUnitUUID");
		String userCreateTime = request.getParameter("userCreateTime");
		String userUpdateTime = request.getParameter("userUpdateTime");
		Map<String, String> map = new HashMap<String, String>();
		if (unitInfo==null || user == null){
			map.put("status", "0");
			map.put("msg", "未输入任何单位（企业）信息");
			return JsonUtil.ObjToJson(map);
		}
		if (unitInfo!=null&&unitInfo.getId()!=null&&user!=null){
			user.setId(Long.valueOf(userId));
			user.setUnitUUID(userUnitUUID);
			user.setCreateTime(userCreateTime);
			user.setUpdateTime(userUpdateTime);
		}
		if (unitInfo.getId()==null && user.getId() ==null){
			if (!StringUtils.isNullOrEmpty(unitInfo.getUnitCode())){
				if (unitService.checkUnitExitByUCode(sourceId, closeConn, unitInfo.getUnitCode())){
					map.put("status", "3");
					map.put("msg", "单位（企业）信息已经收入");
					return JsonUtil.ObjToJson(map);
				}
			}
			unitInfo.setUnitUUID(UUID.randomUUID().toString());
			unitInfo.setCreateTime(DateTimeUtil.formatDate((new Date()), "yyyy-MM-dd HH:mm:ss"));
			unitInfo.setStatus("0");
			
			unitInfo.setTradeUUID("1");
			unitInfo.setCreateUserUUID("1");
			unitInfo.setCreateUserName("1");
			
			//单位创建一个单位管理员账号
			if (userService.findLoginNameExist(sourceId, closeConn, user.getLoginName())){
				map.put("status", "5");
				map.put("msg", "创建单位信息时创建管理员账户！该用户已存在！");
				return JsonUtil.ObjToJson(map);
			}
			user.setUserUUID(UUID.randomUUID().toString());
			user.setUnitUUID(unitInfo.getUnitUUID());
			//初始化默认角色
			RoleInfo role = new RoleInfo();
			role.setRoleUUID(UUID.randomUUID().toString());
			role.setRoleName("企业超级管理员");
			role.setRoleMark("企业超级管理员");
			role.setCreateTime(DateUtil.formatDateTime(new Date()));
			role.setCreateUserName(user.getUserName());
			role.setCreateUserUUID(user.getUserUUID());
			//初始化企业默认权限,通过权限标识取出权限UUID,权限标识通过读取配置文件中的defaultPermission键值
			String defaultPermission = ReadProperties.getValue("defaultPermission");
			String[] perArray = defaultPermission.split(",");
			for (String string : perArray) {
				MenuInfo menu = menuService.findMenuByMenuMark(sourceId, closeConn, string);
				if (menu!=null){
					//初始化企业默认权限
					MenuUnit menuUnit = new MenuUnit();
					menuUnit.setMenuUUID(menu.getMenuUUID());
					menuUnit.setUnitUUID(unitInfo.getUnitUUID());
					List<MenuUnit> muList =  new ArrayList<MenuUnit>();
					muList.add(menuUnit);
					menuUnitService.saveMenuUnit(sourceId, closeConn, muList);
					//初始化企业默认角色权限
					MenuRole menuRole = new MenuRole();
					menuRole.setMenuUUID(menu.getMenuUUID());
					menuRole.setRoleUUID(role.getRoleUUID());
					menuRole.setUnitUUID(unitInfo.getUnitUUID());
					List<MenuRole> mrList =  new ArrayList<MenuRole>();
					mrList.add(menuRole);
					menuRoleService.saveMenuRole(sourceId, closeConn, mrList);
				}
			}
			//为管理员初始化权限，通过赋予初始角色给用户
			RoleUser roleUser = new RoleUser();
			roleUser.setRuUUID(UUID.randomUUID().toString());
			roleUser.setRoleUUID(role.getRoleUUID());
			roleUser.setUserUUID(user.getUserUUID());
			roleUser.setUnitUUID(unitInfo.getUnitUUID());
			List<RoleUser> ruList =  new ArrayList<RoleUser>();
			ruList.add(roleUser);
			roleUserService.saveRoleUser(sourceId, closeConn, ruList);
		}else{
			unitInfo.setUpdateTime(DateTimeUtil.formatDate((new Date()), "yyyy-MM-dd HH:mm:ss"));
			unitInfo.setUpdateUserName("1");
			unitInfo.setUpdateUserUUID("1");
		}
		if (unitService.saveOrUpUnitInfo(sourceId, closeConn, unitInfo)&&userService.saveOrUpUser(sourceId, closeConn, user)){
			
			map.put("status", "1");
			map.put("msg", "单位（企业）信息提交成功");
			return JsonUtil.ObjToJson(map);
		}else{
			map.put("status", "2");
			map.put("msg", "单位（企业）信息提交失败");
			return JsonUtil.ObjToJson(map);
		}
	}
	
	/**
	 * 
	 */
	public String delUnit(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String ids = request.getParameter("ids");
		String uuids = request.getParameter("uuids");
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(ids)){
			String[] idArr = ids.split("_");
			for (String id : idArr) {
				unitService.delUnitById(sourceId, closeConn, id);
			}
			map.put("status", "1");
			map.put("msg", "单位（企业）信息删除成功");
			return JsonUtil.ObjToJson(map);
		}else if (!StringUtils.isNullOrEmpty(uuids)){
			String[] uuidArr = uuids.split("_");
			for (String uuid : uuidArr) {
				unitService.delUnitByUUID(sourceId, closeConn, uuid);
			}
			map.put("status", "1");
			map.put("msg", "单位（企业）信息删除成功");
			return JsonUtil.ObjToJson(map);
		}else{
			map.put("status", "0");
			map.put("msg", "单位（企业）信息删除失败");
			return JsonUtil.ObjToJson(map);
		}
	}
	
	public String changeUnitStatus(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String ids = request.getParameter("ids");
		String uuids = request.getParameter("uuids");
		String status = request.getParameter("status");
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(ids)){
			String[] idArr = ids.split("_");
			for (String id : idArr) {
				unitService.chandeUnitStatusById(sourceId, closeConn, id, status);
			}
			map.put("status", "1");
			map.put("msg", "改变单位（企业）信息状态成功");
			return JsonUtil.ObjToJson(map);
		}else if (!StringUtils.isNullOrEmpty(uuids)){
			String[] uuidArr = uuids.split("_");
			for (String uuid : uuidArr) {
				unitService.chandeUnitStatusByUUID(sourceId, closeConn, uuid, status);
			}
			map.put("status", "1");
			map.put("msg", "改变单位（企业）信息状态成功");
			return JsonUtil.ObjToJson(map);
		}else{
			map.put("status", "0");
			map.put("msg", "改变单位（企业）信息状态失败");
			return JsonUtil.ObjToJson(map);
		}
	}
	
	public String findUnit(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String uuid = request.getParameter("uuid");
		if (!StringUtils.isNullOrEmpty(id)){
			UnitInfo unitInfo = unitService.findUnitById(sourceId, closeConn, id);
			if (unitInfo!=null){
				return JsonUtil.ObjToJson(unitInfo);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else if (!StringUtils.isNullOrEmpty(uuid)){
			UnitInfo unitInfo = unitService.findUnitByUUID(sourceId, closeConn, uuid);
			if (unitInfo!=null){
				return JsonUtil.ObjToJson(unitInfo);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
	
	public String findUnitList(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response, UserInfo user){
		Page page = (Page)ReqToEntityUtil.reqToEntity(request, Page.class);
		Map<String,String> findMap =  ReqToMapUtil.reqToMap(request, UnitInfo.class);
		if (StringUtils.isNullOrEmpty(findMap.get("unitUUID"))){
			return JsonUtil.ObjToJson("[]");
		}else{
			if (user.getUserType().equalsIgnoreCase("0")||user.getUserType().equalsIgnoreCase("1")){
				findMap.put("unitUUID", "");
			}
		}
		
		@SuppressWarnings("rawtypes")
		List<Map> list = unitService.findUnitListMap(sourceId, closeConn, page, findMap);
		if (page!=null){
			return JsonUtil.ObjToJson(page);
		}else if (list!=null){
			return JsonUtil.ObjToJson(list);
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
	
	public String findUnitNameToAutoComplete(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String unitName = request.getParameter("query");
		if(unitName==null || "".equals(unitName)){
			return "[]";
		}
		List<Map<String, String>> list = unitService.findUnitNameToAutoComplete("jdbcread", false, unitName);
		if(list == null) {
			return "[]";
		}
		return JsonUtil.ObjToJson(list);
	}
}
