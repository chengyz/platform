package com.test.manage;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.test.entity.VipConsumptionRecord;
import com.test.service.IVipConsumptionRecordService;
import com.test.service.impl.VipConsumptionRecordServiceImpl;
import com.util.JsonUtil;
import com.util.ReqToEntityUtil;
import com.util.ReqToMapUtil;

import dbengine.util.Page;

/**
 * 会员消费记录的管理
 * @author chengyz
 *
 */
public class VipConsumptionRecordMng {
	
	@Auto(name=VipConsumptionRecordServiceImpl.class)
	private IVipConsumptionRecordService iVipConsumptionRecordService;
	/**
	 * 查询会员消费记录列表
	 * @param sourceId
	 * @param closeConn
	 * @param reqeust
	 * @param response
	 * @return
	 */
	public String findConsumptionRecordList(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Map<String,String> findMap = ReqToMapUtil.reqToMap(request, VipConsumptionRecord.class);
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		if(startTime != null && !"".equals(startTime)){
			startTime = startTime.replace("  ", " ");
		}
		if(endTime != null && !"".equals(endTime)){
			endTime = endTime.replace("  ", " ");
		}
		findMap.put("startTime", startTime);
		findMap.put("endTime", endTime);
		Page page = (Page)ReqToEntityUtil.reqToEntity(request, Page.class);
		List<VipConsumptionRecord> recordlist = iVipConsumptionRecordService.findVipConsumptionRecordList(sourceId, closeConn, page, findMap);
		if(recordlist == null || recordlist.size() < 1){
			return "[]";
		}
		if(page == null){
			return JsonUtil.ObjToJson(recordlist);
		}else{
			return JsonUtil.ObjToJson(page);
		}
	}
}
