package com.test.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.test.entity.AppStartPage;
import com.test.service.AppStartPageService;
import com.test.service.impl.AppStartPageServiceImpl;
import com.util.JsonUtil;
import com.util.ReadProperties;
import com.util.ReqToEntityUtil;
import com.util.Uploader;

import dbengine.util.Page;

/**
 * 好快当APP启动页图片的管理
 * @author chengyz
 *
 */
public class AppStartPageMng {
	@Auto(name=AppStartPageServiceImpl.class)
	private AppStartPageService appStartPageService;
	/**
	 * 上传好快当APP启动页显示的图片
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
	 * 查询App启动页图片
	 * @param sourceId
	 * @param closeConn
	 * @param pageUUID
	 * @return
	 */
	public String findImage(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String pageUUID = request.getParameter("pageUUID");
		if(pageUUID != null && !"".equals(pageUUID)){
			AppStartPage startPage = appStartPageService.findImage(sourceId, closeConn, pageUUID);
			if(startPage == null){
				return "[]";
			}else{
				return JsonUtil.ObjToJson(startPage);
			}
		}else{
			return "[]";
		}
	}
	/**
	 * 手机app查询启动页图片列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public String findImageListM(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String belongApp = request.getParameter("belongApp");
		if(belongApp == null || "".equals(belongApp)){
			return "";
		}
		Map findMap = new HashMap();
		findMap.put("belongApp", belongApp);
		List<AppStartPage> list = appStartPageService.findImageListM(sourceId, closeConn, null, null);
		if(list == null || list.size() < 1 ){
			return "[]";
		}
		return JsonUtil.ObjToJson(list);
	}
	/**
	 * 后台查询App启动页图片列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public String findImageList(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Page page = (Page)ReqToEntityUtil.reqToEntity(request, Page.class);
		List<AppStartPage> list = appStartPageService.findImageList(sourceId, closeConn, page, null);
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
	 * 删除App启动页图片
	 * @param sourceId
	 * @param closeConn
	 * @param pageUUID
	 * @return
	 */
	public String deleteImage(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String pageUUID = request.getParameter("pageUUID");
		Map<String,String> map = new HashMap<String,String>();
		if(pageUUID != null && !"".equals(pageUUID)){
			if(appStartPageService.deleteImage(sourceId, closeConn, pageUUID)){
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
	 * 保存或修改App启动页图片
	 * @param sourceId
	 * @param closeConn
	 * @param appHomePage
	 * @return
	 */
	public String saveOrUpImage(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		AppStartPage startPage = (AppStartPage)ReqToEntityUtil.reqToEntity(request, AppStartPage.class);
		Map<String,String> map = new HashMap<String,String>();
		if(startPage != null){
			if(appStartPageService.saveOrUpImage(sourceId, closeConn, startPage)){
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
