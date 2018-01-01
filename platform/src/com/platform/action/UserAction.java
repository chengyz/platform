package com.platform.action;

import java.util.HashMap;
import java.util.Map;

import com.platform.entity.UserInfo;
import com.platform.manage.UserMng;
import com.util.CacheUtil;
import com.util.JsonUtil;
import com.util.RSAUtil;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

public class UserAction implements ISparkApplication {

	@Auto(name = UserMng.class)
	private UserMng userMng;
	
	@Override
	public void run() {
		Spark.post(new Route("/system/user/saveUser", true, "jdbcwrite") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				String token = request.raw().getSession().getAttribute("token").toString();
				Map<String, String> resulrMap = new HashMap<String, String>();
				if (token == null) {
					resulrMap.put("status", "-12");
					resulrMap.put("msg", "未获取令牌信息！");
					return JsonUtil.ObjToJson(resulrMap);
				}
				Map<String,Object> map = (Map<String,Object>) CacheUtil.getInstance().getTokenObject(token);
				if (map == null) {
					// 令牌取不到数据，说明没有登陆，或操作过期。
					return false;
				}
				return userMng.saveUser("jdbcwrite", false, request.raw(), response.raw());
			}

		});
		Spark.post(new Route("/system/user/delUser", true, "jdbcwrite") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				String token = request.raw().getSession().getAttribute("token").toString();
				Map<String, String> resulrMap = new HashMap<String, String>();
				if (token == null) {
					resulrMap.put("status", "-12");
					resulrMap.put("msg", "未获取令牌信息！");
					return JsonUtil.ObjToJson(resulrMap);
				}
				Map<String,Object> map = (Map<String,Object>) CacheUtil.getInstance().getTokenObject(token);
				if (map == null) {
					// 令牌取不到数据，说明没有登陆，或操作过期。
					return false;
				}
				return userMng.delUser("jdbcwrite", false, request.raw(), response.raw());
			}

		});
		Spark.post(new Route("/system/user/findUser", true, "jdbcread") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				String token = request.raw().getSession().getAttribute("token").toString();
				Map<String, String> resulrMap = new HashMap<String, String>();
				if (token == null) {
					resulrMap.put("status", "-12");
					resulrMap.put("msg", "未获取令牌信息！");
					return JsonUtil.ObjToJson(resulrMap);
				}
				Map<String,Object> map = (Map<String,Object>) CacheUtil.getInstance().getTokenObject(token);
				if (map == null) {
					// 令牌取不到数据，说明没有登陆，或操作过期。
					return false;
				}
				return userMng.findUser("jdbcread", false, request.raw(), response.raw());
			}

		});
		
		Spark.post(new Route("/system/user/getVCode", true, "jdbcread") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return userMng.getVCode("jdbcread", false, request.raw(), response.raw());
			}

		});
		
		Spark.post(new Route("/system/user/findUserList", true, "jdbcread") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				String token = request.raw().getSession().getAttribute("token").toString();
				Map<String, String> resulrMap = new HashMap<String, String>();
				if (token == null) {
					resulrMap.put("status", "-12");
					resulrMap.put("msg", "未获取令牌信息！");
					return JsonUtil.ObjToJson(resulrMap);
				}
				Map<String,Object> map = (Map<String,Object>) CacheUtil.getInstance().getTokenObject(token);
				if (map == null) {
					// 令牌取不到数据，说明没有登陆，或操作过期。
					return false;
				}
				return userMng.findUserList("jdbcread", false, request.raw(), response.raw(), (UserInfo) map.get("userinfo"));
			}

		});
		Spark.post(new Route("/system/user/findUserByUUID", true, "jdbcread") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				String token = request.raw().getSession().getAttribute("token").toString();
				Map<String, String> resulrMap = new HashMap<String, String>();
				if (token == null) {
					resulrMap.put("status", "-12");
					resulrMap.put("msg", "未获取令牌信息！");
					return JsonUtil.ObjToJson(resulrMap);
				}
				Map<String,Object> map = (Map<String,Object>) CacheUtil.getInstance().getTokenObject(token);
				if (map == null) {
					// 令牌取不到数据，说明没有登陆，或操作过期。
					return false;
				}
				return userMng.findUserByUUID("jdbcread", false, request.raw(), response.raw());
			}

		});
		Spark.post(new Route("/system/user/upUserPwd", true, "jdbcwrite") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				String token = request.raw().getSession().getAttribute("token").toString();
				Map<String, String> resulrMap = new HashMap<String, String>();
				if (token == null) {
					resulrMap.put("status", "-12");
					resulrMap.put("msg", "未获取令牌信息！");
					return JsonUtil.ObjToJson(resulrMap);
				}
				Map<String,Object> map = (Map<String,Object>) CacheUtil.getInstance().getTokenObject(token);
				if (map == null) {
					// 令牌取不到数据，说明没有登陆，或操作过期。
					return false;
				}
				return userMng.upUserPwd("jdbcwrite", false, request.raw(), response.raw());
			}

		});
		Spark.post(new Route("/system/user/upUserStatus", true, "jdbcwrite") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				String token = request.raw().getSession().getAttribute("token").toString();
				Map<String, String> resulrMap = new HashMap<String, String>();
				if (token == null) {
					resulrMap.put("status", "-12");
					resulrMap.put("msg", "未获取令牌信息！");
					return JsonUtil.ObjToJson(resulrMap);
				}
				Map<String,Object> map = (Map<String,Object>) CacheUtil.getInstance().getTokenObject(token);
				if (map == null) {
					// 令牌取不到数据，说明没有登陆，或操作过期。
					return false;
				}
				return userMng.upUserStatus("jdbcwrite", false, request.raw(), response.raw());
			}

		});
		Spark.post(new Route("/system/user/findUserMenuList", true, "jdbcread") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				String token = request.raw().getSession().getAttribute("token").toString();
				Map<String, String> resulrMap = new HashMap<String, String>();
				if (token == null) {
					resulrMap.put("status", "-12");
					resulrMap.put("msg", "未获取令牌信息！");
					return JsonUtil.ObjToJson(resulrMap);
				}
				Map<String,Object> map = (Map<String,Object>) CacheUtil.getInstance().getTokenObject(token);
				if (map == null) {
					// 令牌取不到数据，说明没有登陆，或操作过期。
					return false;
				}
				return userMng.findUserMenuList("jdbcread", false, request.raw(), response.raw());
			}

		});
		Spark.post(new Route("/system/user/findUserMenuByPermission", true,
				"jdbcread") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				String token = request.raw().getSession().getAttribute("token").toString();
				Map<String, String> resulrMap = new HashMap<String, String>();
				if (token == null) {
					resulrMap.put("status", "-12");
					resulrMap.put("msg", "未获取令牌信息！");
					return JsonUtil.ObjToJson(resulrMap);
				}
				Map<String,Object> map = (Map<String,Object>) CacheUtil.getInstance().getTokenObject(token);
				if (map == null) {
					// 令牌取不到数据，说明没有登陆，或操作过期。
					return false;
				}
				return userMng.findUserMenuByPermission("jdbcread", false, request.raw(), response.raw());
			}

		});
		Spark.post(new Route("/system/user/findMenuUserListByUserUUID", true,
				"jdbcread") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				String token = request.raw().getSession().getAttribute("token").toString();
				Map<String, String> resulrMap = new HashMap<String, String>();
				if (token == null) {
					resulrMap.put("status", "-12");
					resulrMap.put("msg", "未获取令牌信息！");
					return JsonUtil.ObjToJson(resulrMap);
				}
				Map<String,Object> map = (Map<String,Object>) CacheUtil.getInstance().getTokenObject(token);
				if (map == null) {
					// 令牌取不到数据，说明没有登陆，或操作过期。
					return false;
				}
				return userMng.findMenuUserListByUserUUID("jdbcread", false, request.raw(), response.raw());
			}

		});
		Spark.post(new Route("/system/user/isExitLoginName", true, "jdbcread") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return userMng.isExitLoginName("jdbcread", false, request.raw(), response.raw());
			}

		});
		Spark.post(new Route("/system/user/findPwd", true, "jdbcread") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return userMng.findPwd("jdbcread", false, request.raw(), response.raw());
			}

		});

		Spark.post(new Route("/system/user/findUserForLogin", true, "jdbcread") {

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return userMng.findUserForLogin("jdbcread", false, request.raw(), response.raw());
			}

		});

		/**
		 * 后台和APP获取RSA加密模的接口
		 */
		Spark.post(new Route("/system/user/modulus", true, "jdbcread") {

			@Override
			public Object handle(Request request, Response response) throws Exception {
				Map map = CacheUtil.getInstance().getTokenObject("modulus");
				if(map == null) {
					return RSAUtil.returnModulus(false);
				}
				return JsonUtil.ObjToJson((String)map.get("modulus"));
			}

		});

	}

}
