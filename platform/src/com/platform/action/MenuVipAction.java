package com.platform.action;

import java.util.HashMap;
import java.util.Map;

import com.platform.manage.MenuVipMng;
import com.util.CacheUtil;
import com.util.JsonUtil;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

public class MenuVipAction implements ISparkApplication {

	@Auto(name=MenuVipMng.class)
	private MenuVipMng menuVipMng;
	
	@Override
	public void run() {
		Spark.post(new Route("/system/menuVip/saveMenuVip",true,"jdbcwrite"){

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
					return menuVipMng.addPermissionForVip("jdbcwrite", false, request.raw(), response.raw());
				}
			}
			
		});
		
		Spark.post(new Route("/system/menuVip/findMenuToAddPermission",true,"jdbcread"){

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
					return menuVipMng.findAllMenuItemToAddPermission("jdbcread", false, request.raw(), response.raw());
				}
			}
			
		});
		
		Spark.post(new Route("/system/menuVip/",true,""){

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
