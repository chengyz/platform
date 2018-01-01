package com.test.manage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spark.annotation.Auto;

import com.platform.entity.VipInfo;
import com.test.entity.VipBalance;
import com.test.service.VipBalanceService;
import com.test.service.impl.VipBalanceServiceImpl;
import com.util.JsonUtil;
import com.util.ReqToEntityUtil;
import com.util.ReqToMapUtil;

import dbengine.util.Page;

/**
 * 会员的余额管理
 * @author chengyz
 *
 */
public class VipBalanceMng {
	@Auto(name=VipBalanceServiceImpl.class)
	private VipBalanceService vipBalanceService;
	/**
	 * 保存或修改会员的余额
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String saveOrUpVipBalance(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		VipBalance balance = (VipBalance)ReqToEntityUtil.reqToEntity(request, VipBalance.class);
		Map<String,String> map = new HashMap<String,String>();
		if(balance == null){
			return "";
		}
		if(vipBalanceService.saveOrUpVipBalance(sourceId, closeConn, balance)){
			map.put("status","2");
			map.put("msg", "成功");
			return JsonUtil.ObjToJson(map);
		}else{
			map.put("status","1");
			map.put("msg", "失败");
			return JsonUtil.ObjToJson(map);
		}
	}
	/**
	 * 查询会员的余额列表（后台）
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findVipBalanceList(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		Map<String,String> findMap = ReqToMapUtil.reqToMap(request, VipBalance.class);
		if(findMap != null){
			Page page = (Page)ReqToEntityUtil.reqToEntity(request, Page.class);
			List<VipBalance> balanceList = vipBalanceService.findVipBalanceList(sourceId, closeConn, page, findMap);
			if(page == null){
				return JsonUtil.ObjToJson(balanceList);
			}else{
				return JsonUtil.ObjToJson(page);
			}
		}else{
			return "[]";
		}
	}
	/**
	 * 查询会员的余额
	 * @param sourceId
	 * @param closeConn
	 * @param request
	 * @param response
	 * @return
	 */
	public String findVipBalance(String sourceId,boolean closeConn,HttpServletRequest request,HttpServletResponse response){
		VipInfo vipinfo = (VipInfo)ReqToEntityUtil.reqToEntity(request, VipInfo.class);
		if(vipinfo != null){
			VipBalance balance = vipBalanceService.findVipBalance(sourceId, closeConn, vipinfo);
			return JsonUtil.ObjToJson(balance);
		}else{
			return "";
		}
	}
}
