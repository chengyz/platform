package com.test.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.platform.entity.VipInfo;
import com.test.entity.VipBalance;

import dbengine.util.Page;

/**
 * 会员余额操作的接口
 * @author chengyz
 *
 */
public interface VipBalanceService {
	/**
	 * 添加或修改会员的余额
	 * @param sourceId
	 * @param closeConn
	 * @param vipBlance
	 * @return
	 */
	public boolean saveOrUpVipBalance(String sourceId,boolean closeConn,VipBalance vipBlance);
	/**
	 * 查询会员的余额列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public List<VipBalance> findVipBalanceList(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
	/**
	 * 查询会员的余额
	 * @param sourceId
	 * @param closeConn
	 * @param vipUUID
	 * @return
	 */
	public VipBalance findVipBalance(String sourceId,boolean closeConn,VipInfo vipinfo);
	/**
	 * 通过会员的UUID查询会员的余额
	 * @param sourceId
	 * @param clsoeConn
	 * @param vipUUID
	 * @return
	 */
	public VipBalance findBalanceByVipUUID(String sourceId,boolean closeConn,String vipUUID);
	/**
	 * 更新会员的余额
	 * @param sourceId
	 * @param clsoeConn
	 * @param vipUUID
	 * @return
	 */
	public boolean updateVipBalance(String sourceId,boolean closeConn,String vipUUID,BigDecimal orderPrice);
}
