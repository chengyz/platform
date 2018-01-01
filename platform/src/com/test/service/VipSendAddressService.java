package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.VipSendAddress;

import dbengine.util.Page;

/**
 * 会员自己添加的收货地址
 * @author chengyz
 *
 */
public interface VipSendAddressService {
	/**
	 * 添加或修改会员的收货地址
	 * @param sourceId
	 * @param closeConn
	 * @param vipSendAddress
	 * @return
	 */
	public boolean saveAddress(String sourceId,boolean closeConn,VipSendAddress vipSendAddress);
	/**
	 * 查询地址
	 * @param sourceId
	 * @param closeConn
	 * @param addressUUID
	 * @return
	 */
	public VipSendAddress findAddress(String sourceId, boolean closeConn, String addressUUID);
	/**
	 * 删除收货地址
	 * @param sourceId
	 * @param closeConn
	 * @param addressUUID
	 * @return
	 */
	public boolean deleteAddress(String sourceId, boolean closeConn, String addressUUID);
	/**
	 * 查询收货地址列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public List<VipSendAddress> findAddressList(String sourceId, boolean closeConn, Page page, Map<String, String> findMap);
	/**
	 * 会员修改默认收货地址
	 * @param sourceId
	 * @param closeConn
	 * @param addressUUID
	 * @param vipUUID
	 * @return
	 */
	public boolean updataDefaultAddress(String sourceId, boolean closeConn, VipSendAddress vipSendAddress);
	/**
	 * 会员取消默认收货地址
	 * @param sourceId
	 * @param closeConn
	 * @param addressUUID
	 * @param vipUUID
	 * @return
	 */
	public boolean cancelDefaultAddress(String sourceId, boolean closeConn, String addressUUID, String vipUUID);
	/**
	 * 查询默认收货地址
	 * @param sourceId
	 * @param closeConn
	 * @param vipUUID
	 * @return
	 */
	public VipSendAddress findDefaultAddress(String sourceId, boolean closeConn, String vipUUID);
}
