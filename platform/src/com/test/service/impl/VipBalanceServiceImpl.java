package com.test.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import spark.annotation.Auto;

import com.platform.entity.VipInfo;
import com.test.entity.VipBalance;
import com.test.entity.VipConsumptionRecord;
import com.test.service.VipBalanceService;
import com.util.DateUtil;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import dbengine.util.Page;
/**
 * 会员余额的接口实现
 * @author chengyz
 *
 */
public class VipBalanceServiceImpl implements VipBalanceService {
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	@Auto(name=EntityDao.class)
	private EntityDao entityDao;
	/**
	 * 修改会员的余额
	 */
	@Override
	public boolean saveOrUpVipBalance(String sourceId, boolean closeConn, VipBalance vipBalance) {
		if(vipBalance == null){
			return false;
		}
		if(vipBalance.getId() == null){
			return entityDao.saveEntity(sourceId, vipBalance, closeConn);
		}else{
			StringBuilder sql = new StringBuilder();
			sql.append("select * from vip_balance where vipUUID = '").append(vipBalance.getVipUUID()).append("'");
			VipBalance balance = (VipBalance)sqldao.findEntityBySql(sourceId, sql.toString(), VipBalance.class, closeConn, null);
			balance.setUpdateTime(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
			balance.setVipBalance(vipBalance.getVipBalance());
			balance.setVipPhoneNumber(vipBalance.getVipPhoneNumber());
			return entityDao.updateEntity(sourceId, balance, closeConn);
		}
	}
	/**
	 * 查询会员余额列表
	 */
	@Override
	public List<VipBalance> findVipBalanceList(String sourceId, boolean closeConn, Page page, Map<String, String> findMap) {
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from vip_balance where 1 = 1 ");
		if(findMap.get("vipPhoneNumber") != null && !"".equals(findMap.get("vipPhoneNumber"))){
			sql.append(" and vipPhoneNumber = ?");
			params.add(findMap.get("vipPhoneNumber"));
		}
		if(findMap.get("vipName") != null && !"".equals(findMap.get("vipName"))){
			sql.append(" and vipName = ?");
			params.add(findMap.get("vipName"));
		}
		if(page == null){
			return (List<VipBalance>)sqldao.findListBySql(sourceId, sql.toString(),VipBalance.class, closeConn, params);
		}else{
			return (List<VipBalance>)sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, VipBalance.class, page, params);
		}
	}
	/**
	 * 查询单个会员的余额
	 */
	@Override
	public VipBalance findVipBalance(String sourceId, boolean closeConn, VipInfo vipinfo) {
		if(vipinfo.getVipUUID() == null && "".equals(vipinfo.getVipUUID())){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select * from vip_balance where vipUUID = '").append(vipinfo.getVipUUID()).append("'");
		VipBalance balance = (VipBalance)sqldao.findEntityBySql(sourceId, sql.toString(), VipBalance.class, closeConn, null);
		if(balance == null){
			balance = new VipBalance();
			balance.setBalanceUUID(UUID.randomUUID().toString());
			balance.setCreateTime(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
			balance.setUpdateTime("");
			balance.setVipName(vipinfo.getVipName());
			balance.setVipPhoneNumber(vipinfo.getLoginName());
			BigDecimal money = new BigDecimal("0.00");
			money.setScale(2);
			balance.setVipBalance(money);
			balance.setVipUUID(vipinfo.getVipUUID());
			entityDao.saveEntity(sourceId, balance, closeConn);
		}
		return balance;
	}
	/**
	 * 查询会员的余额
	 */
	@Override
	public VipBalance findBalanceByVipUUID(String sourceId, boolean closeConn, String vipUUID) {
		if(vipUUID == null || "".equals(vipUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select * from vip_balance where vipUUID = '").append(vipUUID).append("'");
		VipBalance balance = (VipBalance)sqldao.findEntityBySql(sourceId, sql.toString(), VipBalance.class, closeConn, null);
		if(balance == null){
			return null;
		}
		return balance;
	}
	/**
	 * 更新会员的余额
	 */
	@Override
	public boolean updateVipBalance(String sourceId, boolean closeConn, String vipUUID, BigDecimal orderPrice) {
		if(vipUUID == null || "".equals(vipUUID) || (orderPrice == new BigDecimal(0))){
			return false;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select * from vip_balance where vipUUID = '").append(vipUUID).append("'");
		VipBalance balance = (VipBalance)sqldao.findEntityBySql(sourceId, sql.toString(), VipBalance.class, closeConn, null);
		StringBuilder sql1 = new StringBuilder();
		sql1.append("select * from vip_info where vipUUID = '").append(vipUUID).append("'");
		VipInfo vip = (VipInfo)sqldao.findEntityBySql(sourceId, sql1.toString(), VipInfo.class, closeConn, null);
		if(balance == null){
			balance = new VipBalance();
			balance.setBalanceUUID(UUID.randomUUID().toString());
			balance.setCreateTime(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
			balance.setUpdateTime("");
			balance.setVipName(vip.getLoginName());
			balance.setVipPhoneNumber(vip.getVipMobile());
			balance.setVipBalance(orderPrice);
			balance.setVipUUID(vip.getVipUUID());
			return entityDao.saveEntity(sourceId, balance, closeConn);
		}else{
			BigDecimal b = balance.getVipBalance();
			balance.setVipBalance(b.add(orderPrice));
			return entityDao.updateEntity(sourceId, balance, closeConn);
		}
	}
}
















