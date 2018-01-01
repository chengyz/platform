package com.platform.action;

import java.util.HashMap;
import java.util.Map;

import com.platform.manage.MenuInfoMng;
import com.util.CacheUtil;
import com.util.JsonUtil;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

public class MenuAction implements ISparkApplication {

	@Auto(name=MenuInfoMng.class)
	private MenuInfoMng menuMng;
	
	@Override
	public void run() {
		Spark.post(new Route("/system/menu/saveMenu",true,"jdbcwrite"){

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
					resulrMap.put("status", "-10");
					resulrMap.put("msg", "未获取令牌信息对象！");
					return JsonUtil.ObjToJson(resulrMap);
				}else{
					return menuMng.saveMenu("jdbcwrite", false, request.raw(), response.raw());
				}
			}
			
		});
		Spark.post(new Route("/system/menu/delMenu",true,"jdbcwrite"){

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
					resulrMap.put("status", "-10");
					resulrMap.put("msg", "未获取令牌信息对象！");
					return JsonUtil.ObjToJson(resulrMap);
				}else{
					return menuMng.delMenu("jdbcwrite", false, request.raw(), response.raw());
				}
			}
			
		});
		Spark.post(new Route("/system/menu/findMenu",true,"jdbcread"){

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
					resulrMap.put("status", "-10");
					resulrMap.put("msg", "未获取令牌信息对象！");
					return JsonUtil.ObjToJson(resulrMap);
				}else{
					return menuMng.findMenu("jdbcread", false, request.raw(), response.raw());
				}
			}
			
		});
		Spark.post(new Route("/system/menu/findMenuList",true,"jdbcread"){

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
					resulrMap.put("status", "-10");
					resulrMap.put("msg", "未获取令牌信息对象！");
					return JsonUtil.ObjToJson(resulrMap);
				}else{
					return menuMng.findMenuList("jdbcread", false, request.raw(), response.raw());
				}
			}
			
		});
		Spark.post(new Route("/system/menu/findMenuUser",true,"jdbcread"){

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
					resulrMap.put("status", "-10");
					resulrMap.put("msg", "未获取令牌信息对象！");
					return JsonUtil.ObjToJson(resulrMap);
				}else{
					return menuMng.findMenuUser("jdbcread", false, request.raw(), response.raw());
				}
			}
			
		});
		Spark.post(new Route("/system/menu/findMenuTree",true,"jdbcread"){

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
					resulrMap.put("status", "-10");
					resulrMap.put("msg", "未获取令牌信息对象！");
					return JsonUtil.ObjToJson(resulrMap);
				}else{
					return menuMng.findMenuTree("jdbcread", false, request.raw(), response.raw());
				}
			}
			
		});
		Spark.post(new Route("/system/menu/findMenuForRole",true,"jdbcread"){

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
					resulrMap.put("status", "-10");
					resulrMap.put("msg", "未获取令牌信息对象！");
					return JsonUtil.ObjToJson(resulrMap);
				}else{
					return menuMng.findNotMenuByRoleUUID("jdbcread", false, request.raw(), response.raw());
				}
			}
			
		});
		Spark.post(new Route("/system/menu/",true,""){

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
					resulrMap.put("status", "-10");
					resulrMap.put("msg", "未获取令牌信息对象！");
					return JsonUtil.ObjToJson(resulrMap);
				}else{
					
				}
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		
	}

}
