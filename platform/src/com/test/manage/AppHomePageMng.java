package com.test.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.test.entity.AppHomePage;
import com.test.service.AppHomePageService;
import com.test.service.impl.AppHomePageServiceImpl;
import com.util.JsonUtil;
import com.util.ReadProperties;
import com.util.ReqToEntityUtil;
import com.util.ReqToMapUtil;
import com.util.Uploader;

import dbengine.util.Page;

/**
 * 好快当APP首页图片的管理
 * @author chengyz
 *
 */
public class AppHomePageMng {
	@Auto(name=AppHomePageServiceImpl.class)
	private AppHomePageService appHomePageService;
	/**
	 * 上传好快当APP首页显示的图片
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String uploadImage(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String basePath = ReadProperties.getValue("imgUploadPath");//得到config配置文件的主路径
		Uploader up = new Uploader(request);
		up.setSavePath(basePath);
		String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
		up.setAllowFiles(fileType);
		up.setMaxSize(10000); //单位KB
		up.upload();
		String url = up.getUrl();//文件访问路径
		return url;
	}
	/**
	 * 查询首页图片
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findImage(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String pageUUID = request.getParameter("pageUUID");
		if(pageUUID != null && !"".equals(pageUUID)){
			AppHomePage home = appHomePageService.findImage(sourceId, closeConn, pageUUID);
			if(home == null){
				return "[]";
			}else{
				return JsonUtil.ObjToJson(home);
			}
		}else{
			return "[]";
		}
	}
	/**
	 * 手机app查询首页显示图片列表
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findImageListM(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String belongApp = request.getParameter("belongApp");
		String belong = "";
		if(belongApp != null && !"".equals(belongApp)){
			belong = belongApp;
		}
		List<AppHomePage> list = appHomePageService.findImageListM(sourceId, closeConn, belong);
		if(list == null || list.size() < 1 ){
			return "[]";
		}
		return JsonUtil.ObjToJson(list);
	}
	/**
	 * 查询首页显示图片列表
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findImageList(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Page page = (Page)ReqToEntityUtil.reqToEntity(request, Page.class);
		List<AppHomePage> list = appHomePageService.findImageList(sourceId, closeConn, page, null);
		if(list == null || list.size() < 1 ){
			return "[]";
		}
		if(page == null){
			return JsonUtil.ObjToJson(list);
		}else{
			return JsonUtil.ObjToJson(page);
		}
	}
	/**
	 * 删除首页图片
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String deleteImage(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String pageUUID = request.getParameter("pageUUID");
		Map<String,String> map = new HashMap<String,String>();
		if(pageUUID != null && !"".equals(pageUUID)){
			if(appHomePageService.deleteImage(sourceId, closeConn, pageUUID)){
				map.put("status", "2");
				map.put("msg", "成功");
				return JsonUtil.ObjToJson(map);
			}else{
				map.put("status", "1");
				map.put("msg", "失败");
				return JsonUtil.ObjToJson(map);
			}
		}else{
			map.put("status", "-1");
			map.put("msg", "未获取到信息");
			return JsonUtil.ObjToJson(map);
		}
	}
	/**
	 * 保存或修改首页图片
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String saveOrUpImage(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		AppHomePage home = (AppHomePage)ReqToEntityUtil.reqToEntity(request, AppHomePage.class);
		Map<String,String> map = new HashMap<String,String>();
		if(home != null){
			if(appHomePageService.saveOrUpImage(sourceId, closeConn, home)){
				map.put("status", "2");
				map.put("msg", "成功");
				return JsonUtil.ObjToJson(map);
			}else{
				map.put("status", "1");
				map.put("msg", "失败");
				return JsonUtil.ObjToJson(map);
			}
		}else{
			map.put("status", "-1");
			map.put("msg", "未获取到信息");
			return JsonUtil.ObjToJson(map);
		}
	}
}
