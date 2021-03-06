package com.platform.manage;

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
import com.platform.entity.MenuUser;
import com.platform.entity.UnitInfo;
import com.platform.entity.UserInfo;
import com.platform.service.IMenuUserService;
import com.platform.service.IRoleUserService;
import com.platform.service.IUnitInfoService;
import com.platform.service.IUserService;
import com.platform.service.impl.MenuUserServiceImpl;
import com.platform.service.impl.RoleUserServiceImpl;
import com.platform.service.impl.UnitInfoServiceImpl;
import com.platform.service.impl.UserServiceImpl;
import com.util.CacheUtil;
import com.util.DateTimeUtil;
import com.util.JsonUtil;
import com.util.MD5;
import com.util.RSAUtil;
import com.util.ReqToEntityUtil;
import com.util.ReqToMapUtil;
import com.util.VCodeUtil;

import dbengine.util.Page;

public class UserMng {

	@Auto(name=UserServiceImpl.class)
	private IUserService userService;
	
	@Auto(name=MenuUserServiceImpl.class)
	private IMenuUserService menuUserService;
	
	@Auto(name=RoleUserServiceImpl.class)
	private IRoleUserService roleUserService;
	
	@Auto(name=UnitInfoServiceImpl.class)
	private IUnitInfoService unitService;
	
	public String saveUser(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		UserInfo user = (UserInfo) ReqToEntityUtil.reqToEntity(request, UserInfo.class);
		Map<String, String> map =  new HashMap<String, String>();
		if (user==null){
			map.put("status", "0");
			map.put("msg", "未获取到任何信息");
			return JsonUtil.ObjToJson(map);
		}
		if (user.getId()==null){
			user.setUserUUID(UUID.randomUUID().toString());
			user.setUserStatus("0");
			user.setCreateTime(DateTimeUtil.formatDate((new Date()), "yyyy-MM-dd HH:mm:ss"));
		}
		if (userService.saveOrUpUser(sourceId, closeConn, user)){
			map.put("status", "1");
			map.put("msg", "成功");
			return JsonUtil.ObjToJson(map);
		}else{
			map.put("status", "0");
			map.put("msg", "失败");
			return JsonUtil.ObjToJson(map);
		}
		
	}
	
	public String delUser(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String userUUID = request.getParameter("userUUID");
		Map<String, String> map =  new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(userUUID)){
			if (userService.deleteUser(sourceId, closeConn, userUUID)){
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
	public String findUser(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		Map<String, String> findMap = ReqToMapUtil.reqToMap(request, UserInfo.class);
		String unitUUID = request.getParameter("unitUUID");
		UserInfo user = userService.findUserInfo(sourceId, closeConn, unitUUID, findMap);
		if (user!=null){
			return JsonUtil.ObjToJson(user);
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
	public String findUserList(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response,UserInfo user){
		Map<String, String> findMap = ReqToMapUtil.reqToMap(request, UserInfo.class);
		String unitUUID = request.getParameter("unitUUID");
		Page page = (Page) ReqToEntityUtil.reqToEntity(request, Page.class);
		if (StringUtils.isNullOrEmpty(unitUUID)){
			return JsonUtil.ObjToJson("[]");
		}else{
			if (user.getUserType().equalsIgnoreCase("0")||user.getUserType().equalsIgnoreCase("1")){
				findMap.put("unitUUID", "");
			}else{
				findMap.put("unitUUID", unitUUID);
			}
		}
		List<UserInfo> list = userService.findUserInfoList(sourceId, closeConn, page, unitUUID, findMap);
		if (page!=null){
			return JsonUtil.ObjToJson(page);
		}else if (list!=null){
			return JsonUtil.ObjToJson(list);
		}else {
			return JsonUtil.ObjToJson("[]");
		}
		
	}
	public String findUserByUUID(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String userUUID = request.getParameter("userUUID");
		if (!StringUtils.isNullOrEmpty(userUUID)){
			UserInfo user = userService.findUserInfoByUUID(sourceId, closeConn, userUUID);
			if (user!=null){
				return JsonUtil.ObjToJson(user);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else{
			return JsonUtil.ObjToJson("[]");
		}	
		
	}
	public String upUserPwd(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String userUUID = request.getParameter("userUUID");
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(userUUID)&&!StringUtils.isNullOrEmpty(oldPwd)&&!StringUtils.isNullOrEmpty(newPwd)){
			if (userService.upUserPwd(sourceId, closeConn, userUUID, oldPwd, newPwd)){
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
	public String upUserStatus(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String userUUID = request.getParameter("userUUID");
		String unitUUID = request.getParameter("unitUUID");
		String status = request.getParameter("status");
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(userUUID)&&!StringUtils.isNullOrEmpty(unitUUID)&&!StringUtils.isNullOrEmpty(status)){
			if (userService.updateUserStatus(sourceId, closeConn, unitUUID, userUUID, status)){
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
	public String findUserMenuList(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String unitUUID = request.getParameter("unitUUID");
		String userUUID = request.getParameter("userUUID");
		String menuParentCode = request.getParameter("menuParentCode");
		if (!StringUtils.isNullOrEmpty(userUUID)&&!StringUtils.isNullOrEmpty(unitUUID)&&!StringUtils.isNullOrEmpty(menuParentCode)){
			List<MenuInfo> list = userService.findMenuByUserUUID(sourceId, closeConn, unitUUID, userUUID, menuParentCode);
			if (list.size()>0){
				return JsonUtil.ObjToJson(list);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else{
			return JsonUtil.ObjToJson("[]");
		}
		
	}
	public String findUserMenuByPermission(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String unitUUID = request.getParameter("unitUUID");
		String menuPermission = request.getParameter("menuPermission");
		if (!StringUtils.isNullOrEmpty(unitUUID)&&!StringUtils.isNullOrEmpty(menuPermission)){
			MenuInfo menu = userService.findMenuByPermission(sourceId, closeConn, unitUUID, menuPermission);
			if (menu!=null){
				return JsonUtil.ObjToJson(menu);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else{
			return JsonUtil.ObjToJson("[]");
		}
		
	}
	public String findMenuUserListByUserUUID(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String unitUUID = request.getParameter("unitUUID");
		String userUUID = request.getParameter("userUUID");
		if (!StringUtils.isNullOrEmpty(userUUID)&&!StringUtils.isNullOrEmpty(unitUUID)){
			List<MenuUser> list = userService.findMenuByUserUUID(sourceId, closeConn, unitUUID, userUUID);
			if (list.size()>0){
				return JsonUtil.ObjToJson(list);
			}else{
				return JsonUtil.ObjToJson("[]");
			}
		}else{
			return JsonUtil.ObjToJson("[]");
		}
	}
	public String isExitLoginName(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String loginName = request.getParameter("loginName");
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(loginName)){
			if (userService.findLoginNameExist(sourceId, closeConn, loginName)){
				map.put("status", "1");
				map.put("msg", "存在");
				return JsonUtil.ObjToJson(map);
			}else{
				map.put("status", "0");
				map.put("msg", "不存在");
				return JsonUtil.ObjToJson(map);
			}
		}else{
			map.put("status", "0");
			map.put("msg", "未获取到任何信息");
			return JsonUtil.ObjToJson(map);
		}
		
	}
	public String findPwd(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		String loginName = request.getParameter("loginName");
		String vipPwd = request.getParameter("vipPwd");
		Map<String, String> map = new HashMap<String, String>();
		if (!StringUtils.isNullOrEmpty(loginName)&&!StringUtils.isNullOrEmpty(vipPwd)){
			if (userService.findPwd(sourceId, closeConn,vipPwd , loginName)){
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
	
	public String findUserForLogin(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		
		String loginName = request.getParameter("loginName");
		String userPwd = request.getParameter("userPwd");
		String passcode = request.getParameter("passcode");
		Map<String, Object> map = new HashMap<String, Object>();
		if(!StringUtils.isNullOrEmpty(passcode)){
			passcode = passcode.toLowerCase();
		}
		if(null == request.getSession().getAttribute("passcode")){
			//前端注册用户，无需验证码
		}else if(passcode != null && !passcode.equals(request.getSession().getAttribute("passcode"))){
			map.put("status", "8");
			map.put("msg", "验证码错误！");
			return JsonUtil.ObjToJson(map);	
		}
		if(StringUtils.isNullOrEmpty(loginName)){
			map.put("status", "0");
			map.put("msg", "用户名未填写！");
			return JsonUtil.ObjToJson(map);
		}
		if(StringUtils.isNullOrEmpty(userPwd)){
			map.put("status", "0");
			map.put("msg", "用户密码为空未填写！");
			return JsonUtil.ObjToJson(map);
		}
		loginName = RSAUtil.decryptData(false, loginName, false);
		userPwd = RSAUtil.decryptData(false, userPwd, false);
		
		//查用户信息
		Map<String,String> findMap = new HashMap<String,String>();
		findMap.put("loginName", loginName);
		findMap.put("userPwd", (new MD5()).getMD5ofStr(userPwd));
		UserInfo user = userService.findUserInfo(sourceId, closeConn, null, findMap);
		if(user==null){
			map.put("status", "2");
			map.put("msg", "用户名或密码错误！");
			return JsonUtil.ObjToJson(map);
		}
		if("2".equals(user.getUserStatus())){
			map.put("status", "3");
			map.put("msg", "用户已注销！");
			return JsonUtil.ObjToJson(map);
		}
		if("3".equals(user.getUserStatus())){
			map.put("status", "4");
			map.put("msg", "用户已禁用！");
			return JsonUtil.ObjToJson(map);
		}
//		UnitInfo unit = unitService.findUnitByUUID(sourceId, closeConn, user.getUnitUUID());
//		if (unit!=null){
//			if (unit.getStatus().equalsIgnoreCase("1")){
//				map.put("unitinfo", unit);
//				request.getSession().setAttribute("unitinfo", unit);
//			}else{
//				map.put("status", "-10");
//				map.put("msg", "单位已禁用或注销！");
//				return JsonUtil.ObjToJson(map);
//			}
//		}else{
//			map.put("status", "-11");
//			map.put("msg", "未获取到单位信息！");
//			return JsonUtil.ObjToJson(map);
//		}
		//用户权限字符串
		//查登陆人所有的菜单权限
		List<MenuInfo> miList = menuUserService.findMenuByUserUUID("jdbcread", false, user.getUserUUID());
		List<MenuInfo> miListFromRole = roleUserService.findMenuForUser(sourceId, closeConn, user.getUserUUID(), user.getUnitUUID());
		String permissionStr = "";
		if(miList!=null){
			for(MenuInfo mi :miList){
				if(!"".equals(permissionStr)){
					permissionStr += ","+mi.getMenuPermission();
				}else{
					permissionStr += mi.getMenuPermission();
				}
			}
		}
		if(miListFromRole!=null){
			for(MenuInfo mi :miListFromRole){
				if(!"".equals(permissionStr)){
					permissionStr += ","+mi.getMenuPermission();
					System.out.println(mi.getMenuName());
				}else{
					permissionStr += mi.getMenuPermission();
				}
			}
		}
		//将信息放入缓存
		map.put("permissionStr", permissionStr);
		map.put("userinfo", user);
		map.put("userName", user.getUserName());
		map.put("useruuid", user.getUserUUID());
		map.put("unituuid", user.getUnitUUID());
		map.put("userType", user.getUserType());
		
		//将菜单权限信息存入session中
		request.getSession().setAttribute("permissionStr", permissionStr);	
		request.getSession().setAttribute("userinfo", user);
		request.getSession().setAttribute("userName", user.getUserName());
		request.getSession().setAttribute("useruuid", user.getUserUUID());
		request.getSession().setAttribute("unituuid", user.getUnitUUID());
		request.getSession().setAttribute("userType", user.getUserType());//用户类型
		//更新用户登录信息
		// 修改用户的登陆时间和次数
		user.setLoginTime(DateTimeUtil.formatDateTime(new Date(), "yyyy-MM-dd HH:MM:ss"));
		user.setLoginNum(user.getLoginNum() + 1);
		userService.saveOrUpUser(sourceId, closeConn, user);
		//生成令牌
		String token = UUID.randomUUID().toString();
		//缓存设置令牌生成时间
		CacheUtil.getInstance().setTokenTime(token, new Date());	
		//令牌信息存入session
		request.getSession().setAttribute("token", token);
		//令牌存入缓存
		map.put("token", token);
		map.put("status", "1");
		map.put("msg", "登陆成功！");
		//缓存中设置登陆信息对象
		CacheUtil.getInstance().setTokenObject(token, map);
		return JsonUtil.ObjToJson(map);
	}
	
	public String getVCode(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response){
		VCodeUtil vcu = new VCodeUtil();
		StringBuilder strB = new StringBuilder();
		String strBin = vcu.getVcode(strB);
		request.getSession().setAttribute("passcode", strBin.toLowerCase());
		return strB.toString();
	}
	
}
