package com.test.service;

import com.test.entity.VipRefMerchantsOrderNum;
/**
 * 商户订单号记录service接口
 * @author chengyz
 *
 */
public interface IVipRefMerchantsOrderNumService {
	/**
	 * 查订单号记录
	 */
	public VipRefMerchantsOrderNum findByMerchantsOrderNum(String sourceId,boolean closeConn,String merchantsOrderNum);
	/**
	 * 保存或修改订单号记录
	 */
	public boolean saveOrUpdate(String sourceId,boolean closeConn,VipRefMerchantsOrderNum t);
	/**
	 * 删除订单号记录
	 */
	public boolean delete(String sourceId,boolean closeConn,String vipUUID, String merchantsOrderNum);
}
