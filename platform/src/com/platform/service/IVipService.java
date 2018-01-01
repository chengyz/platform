package com.platform.service;

import java.util.List;
import java.util.Map;

import com.platform.entity.MenuInfo;
import com.platform.entity.VipInfo;

import dbengine.util.Page;

public interface IVipService {
	/**
	 * 保存或修改会员信息
	 * @param Vip
	 * @return
	 */
	public boolean saveOrUpVip(String sourceId,boolean closeConn,VipInfo Vip);
	/**
	 * 查会员信息列表(可分页)
	 * @param unitUUID
	 * @param findMap(查询条件)
	 * @return
	 */
	public List<VipInfo> findVipInfoList(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
	/**
	 * 修改会员密码
	 * @param VipUUID
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	public boolean upVipPwd(String sourceId,boolean closeConn,String vipUUID,String oldPwd,String newPwd);
	
	/**
	 * 查询会员手机号码是否存在
	 * @param VipMobile
	 * @return
	 */
	boolean findVipMobileExists(String sourceId,boolean closeConn,String vipMobile);
	
	/**
	 * 删除会员
	 * @param VipUUID
	 * @return
	 */
	public boolean deleteVip(String sourceId,boolean closeConn,String vipUUID);
	
	/**
	 * 根据UUID查询会员信息
	 * @param VipUUID
	 * @return
	 */
	public VipInfo findVipInfoByUUID(String sourceId,boolean closeConn,String vipUUID);
	
	/**
	 * 查会员信息(通过uuid、账号、密码等进行查询，主要验证其是否存在)
	 * @param sourceId
	 * @param closeConn
	 * @param findMap
	 * @return
	 */
	public VipInfo findVipInfo(String sourceId,boolean closeConn,Map<String,String> findMap);
	/**
	 * 修改会员状态
	 * @param vipUUID
	 * @param status
	 * @return
	 */
	public boolean updateVipStatus(String sourceId,boolean closeConn,String vipUUID,String status);
    /**
     * 通过vipUUID查关联的菜信息
     * @param vipUUID
     * @param menuParentCode
     * @return
     */
	public List<MenuInfo> findMenuByVipUUID(String sourceId,boolean closeConn,String vipUUID,String menuParentCode);
	
	/**
	 * 查询会员总数
	 * @return
	 */
	public int findVipCount(String sourceId,boolean closeConn);
	
	/**
	 * 查登陆账号(手机)是否存在
	 * @param sourceId
	 * @param closeConn
	 * @param loginName
	 * @return true 存在，false 不存在
	 */
	public boolean findLoginNameExist(String sourceId,boolean closeConn,String loginName);
	/**
	 * 修改密码？手机号
	 */
	public boolean findPwd(String sourceId,boolean closeConn,String vipPwd,String loginName);
	
	public boolean updateVipInfo(String sourceId,boolean closeConn,String fields, List<Object> values, String id, String vipUUID);
	/**
	 * 通过订单UUID查询跑客的信息
	 * @param sourceId
	 * @param closeConn
	 * @param orderUUID
	 * @return
	 */
	public VipInfo findVipInfoByOrderUUID(String sourceId, boolean closeConn, String orderUUID);
	/**
	 * 统计会员信用分
	 * @param sourceId
	 * @param closeConn
	 * @param vipUUID
	 * @return
	 */
	public String vipCredit(String sourceId,boolean closeConn,String vipUUID);
}
