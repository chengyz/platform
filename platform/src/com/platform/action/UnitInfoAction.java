package com.platform.action;

import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.platform.entity.UserInfo;
import com.platform.manage.UnitInfoMng;
import com.util.CacheUtil;
import com.util.JsonUtil;

public class UnitInfoAction implements ISparkApplication {

	@Auto(name=UnitInfoMng.class)
	private UnitInfoMng unitMng;

	@Override
	public void run() {
		/**
		 * 保存单位（企业）数据
		 */
		Spark.post(new Route("/system/unit/saveOrUpUnit",true,"jdbcwrite"){

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
					return unitMng.saveOrUpUnit("jdbcwrite", false, request.raw(), response.raw());
				}
			}
			
		});
		/**
		 * 删除单位（企业）数据
		 */
		Spark.post(new Route("/system/unit/delUnit",true,"jdbcwrite"){

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
					return unitMng.delUnit("jdbcwrite", false, request.raw(), response.raw());
				}
			}
			
		});
		/**
		 * 改变单位（企业）数据状态
		 */
		Spark.post(new Route("/system/unit/changeUnitStatus",true,"jdbcwrite"){

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
					return unitMng.changeUnitStatus("jdbcwrite", false, request.raw(), response.raw());
				}
			}
			
		});
		/**
		 * 获取单位（企业）数据
		 */
		Spark.post(new Route("/system/unit/findUnit",false,"jdbcread"){

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
					return unitMng.findUnit("jdbcread", false, request.raw(), response.raw());
				}
			}
			
		});
		/**
		 * 获取单位（企业）数据List集
		 */
		Spark.post(new Route("/system/unit/findUnitList",false,"jdbcread"){

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
					return unitMng.findUnitList("jdbcread", false, request.raw(), response.raw(), (UserInfo) map.get("userinfo"));
				}
			}
			
		});
		
		Spark.get(new Route("/system/unit/findUnitNameToAutoComplete",false,"jdbcread"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return unitMng.findUnitNameToAutoComplete("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		
		Spark.post(new Route("",true,""){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
	}
	
}