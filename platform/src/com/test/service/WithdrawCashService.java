package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.WithdrawCash;

import dbengine.util.Page;

/**
 * 会员提现service接口
 * @author chengyz
 *
 */
public interface WithdrawCashService {
	/**
	 * 保存或修改提现记录
	 * @param sourceId
	 * @param closeConn
	 * @param withdrawCash
	 * @return
	 */
	public boolean saveOrUpWithdrawCash(String sourceId,boolean closeConn,WithdrawCash withdrawCash);
	
	/**
	 * 查询提现记录列表（要显示会员的余额）
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public List<WithdrawCash> findWithdrawCashList(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
	/**
	 * 查询会员的提现记录
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param vipUUID
	 * @return
	 */
	public List<WithdrawCash> findMyWithdrawCashList(String sourceId,boolean closeConn,Page page,String vipUUID);
	/**
	 * 查询单条提现记录(更新提现状态时使用)
	 * @param sourceId
	 * @param closeConn
	 * @param cashUUID
	 * @return
	 */
	public WithdrawCash findWithdrawCash(String sourceId, boolean closeConn, String cashUUID);
	
}