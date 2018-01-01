package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.AddressInfo;

import dbengine.util.Page;

/**
 * 收货地址和购买地址的service接口
 * @author chengyz
 *
 */
public interface AddressInfoService {
	/**
	 * 查询地址
	 * @param sourceId
	 * @param closeConn
	 * @param addressUUID
	 * @return
	 */
	public AddressInfo findAddress(String sourceId,boolean closeConn,String addressUUID);
	/**
	 * 删除地址
	 * @param sourceId
	 * @param closeConn
	 * @param addressUUID
	 * @return
	 */
	public boolean deleteAddress(String sourceId,boolean closeConn,String addressUUID,String vipUUID);
	/**
	 * 添加地址点
	 * @param sourceId
	 * @param closeConn
	 * @param addressInfo
	 * @return
	 */
	public String saveOrUpAddress(String sourceId,boolean closeConn,AddressInfo addressInfo,Map<String,String> map);
	/**
	 * 查询地址列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public List<Map> findAddressList(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
	/**
	 * 后台直接删除地址
	 * @param sourceId
	 * @param closeConn
	 * @param addressUUID
	 * @return
	 */
	public boolean delAddress(String sourceId, boolean closeConn, String addressUUID);
	
}
