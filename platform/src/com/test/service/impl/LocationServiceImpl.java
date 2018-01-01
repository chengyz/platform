package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spark.annotation.Auto;

import com.test.entity.OrderInfo;
import com.test.service.ILocationService;

import dbengine.dao.SqlDao;
import dbengine.util.Page;

/**
 * 会员定位相关service实现
 * 
 * @author hshzh
 * @date 2017-3-13 下午3:05:44
 */
public class LocationServiceImpl implements ILocationService {

	@Auto(name = SqlDao.class)
	private SqlDao sqldao;

	@Override
	public List<Map> findUntreatedOrders(String sourceId, boolean closeConn, Page page) {
		String sql1 = "select orderUUID,orderType,payTime,vipUUID,vipPhoneNumber,orderPrice,beginLongitude as sendLo,beginLatitude as sendLa,beginAddress,sendLongitude as recLo,sendLatitude as recLa,buyOption,buyType,createTime,beginPhoneNumber,sendAddress from order_info where status='3'";//orderType: 1帮我买、2帮我送、3帮我取		
		if(page != null){
			return sqldao.findPageByMysql(sourceId, sql1, closeConn, null, page, null);
		}else{
			return sqldao.findMapListBysql(sourceId, sql1, closeConn, null);
		}
	}
}