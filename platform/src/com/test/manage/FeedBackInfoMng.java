package com.test.manage;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.test.entity.FeedBackInfo;
import com.test.service.FeedBackInfoService;
import com.test.service.impl.FeedBackInfoServiceImpl;
import com.util.DateTimeUtil;
import com.util.JsonUtil;
import com.util.ReadProperties;
import com.util.ReqToEntityUtil;
import com.util.ReqToMapUtil;
import com.util.UpdateDataUtil;
import com.util.Uploader;

import dbengine.util.Page;

/**
 * 反馈信息的manage
 * @author chengyz
 *
 */
public class FeedBackInfoMng {
	
	@Auto(name=FeedBackInfoServiceImpl.class)
	private FeedBackInfoService feedBackInfoServcie;
	/**
	 * 添加或修改反馈信息
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String saveOrUpdateFeedBackInfo(String sourceId, boolean closeConn, HttpServletRequest request, HttpServletResponse response) {
		FeedBackInfo info = (FeedBackInfo)ReqToEntityUtil.reqToEntity(request, FeedBackInfo.class);
		Map map = new HashMap();
		if(info == null) {
			map.put("status", "-1");
			map.put("msg", "未获取到任何信息");
			return JsonUtil.ObjToJson(map);
		}
		if(info.getId() == null) {
			info.setStatus("2");//1为已被查看、2为未被查看，初始为2
			info.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
			info.setCreateTime(DateTimeUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
		}
		if(feedBackInfoServcie.saveOrUpdateFeedBackInfo(sourceId, closeConn, info)) {
			map.put("status", "1");
			map.put("msg", "添加或修改成功");
			return JsonUtil.ObjToJson(map);
		}
		map.put("status", "-2");
		map.put("msg", "添加或修改失败");
		return JsonUtil.ObjToJson(map);
	}
	/**
	 * 查询反馈信息
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findFeedBackInfo(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String uuid = request.getParameter("uuid");
		if(uuid != null && !"".equals(uuid)){
			FeedBackInfo feedBackInfo = feedBackInfoServcie.findFeedBackInfo(sourceId, closeConn, uuid);
			if(feedBackInfo == null){
				return "";
			}else{
				return JsonUtil.ObjToJson(feedBackInfo);
			}
		}else{
			return "";
		}
	}
	/**
	 * 删除反馈信息
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String deleteFeedBackInfo(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String uuid = request.getParameter("uuid");
		Map<String,String> map = new HashMap<String,String>();
		if(uuid != null && !"".equals(uuid)){
			if(feedBackInfoServcie.deleteFeedBackInfo(sourceId, closeConn, uuid)){
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
	 * 查询反馈信息列表
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findFeedBackInfoList(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Page page = (Page)ReqToEntityUtil.reqToEntity(request, Page.class);
		Map<String,String> findMap = ReqToMapUtil.reqToMap(request, FeedBackInfo.class);
		List<FeedBackInfo> list = feedBackInfoServcie.findFeedBackInfoList(sourceId, closeConn, page, findMap);
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
	 * 改变反馈信息状态
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String changeStatus(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		Map map  = new HashMap();
		if(id == null || "".equals(id) || "null".equals(id)) {
			map.put("status", "-1");
			map.put("msg", "未获取到任何信息");
			return JsonUtil.ObjToJson(map);
		}
		Map dataMap = new HashMap();
		dataMap.put("status", "1");
		UpdateDataUtil.updateData(sourceId, "feed_back_info", dataMap, "id", id);
		map.put("status", "1");
		map.put("msg", "修改成功");
		return JsonUtil.ObjToJson(map);
	}
	/**
	 * 上传会员反馈的图片
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return synchronized
	 */
	public String uploadPicture(HttpServletRequest request,HttpServletResponse response) throws Exception{
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
}
