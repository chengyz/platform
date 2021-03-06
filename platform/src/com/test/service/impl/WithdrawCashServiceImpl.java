package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spark.annotation.Auto;

import com.test.entity.VipBalance;
import com.test.entity.WithdrawCash;
import com.test.service.WithdrawCashService;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import dbengine.util.Page;
/**
 * 会员提现记录
 * @author chengyz
 *
 */
public class WithdrawCashServiceImpl implements WithdrawCashService {
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	@Auto(name=EntityDao.class)
	private EntityDao entityDao;
	/**
	 * 保存或修改提现记录
	 */
	@Override
	public boolean saveOrUpWithdrawCash(String sourceId, boolean closeConn, WithdrawCash withdrawCash) {
		if(withdrawCash == null){
			return false;
		}
		if(withdrawCash.getId() == null){
			return entityDao.saveEntity(sourceId, withdrawCash, closeConn);
		}else{
			return entityDao.updateEntity(sourceId, withdrawCash, closeConn);
		}
	}
	/**
	 * 后台查询提现记录列表
	 */
	@Override
	public List<WithdrawCash> findWithdrawCashList(String sourceId, boolean closeConn, Page page, Map<String, String> findMap) {
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from withdraw_cash where 1 = 1 ");
		if(findMap != null){
			if(findMap.get("vipName") != null && !"".equals(findMap.get("vipName"))){
				sql.append(" and vipName = ? ");
				params.add(findMap.get("vipName"));
			}
			if(findMap.get("vipPhoneNumber") != null && !"".equals(findMap.get("vipPhoneNumber"))){
				sql.append(" and vipPhoneNumber = ?");
				params.add(findMap.get("vipPhoneNumber"));
			}
			if(findMap.get("status") != null && !"".equals(findMap.get("status"))){
				sql.append(" and status = ? ");
				params.add(findMap.get("status"));
			}
			if(findMap.get("startTime") != null && !"".equals(findMap.get("startTime"))){
				sql.append(" and applyTime > ?");
				params.add(findMap.get("startTime"));
			}
			if(findMap.get("endTime") != null && !"".equals(findMap.get("endTime"))){
				sql.append(" and applyTime < ?");
				params.add(findMap.get("endTime"));
			}
			if(page == null){
				return (List<WithdrawCash>)sqldao.findListBySql(sourceId, sql.toString(),WithdrawCash.class, closeConn, params);
			}else{
				return (List<WithdrawCash>)sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, WithdrawCash.class, page, params);
			}
		}else{
			return null;
		}
	}
	/**
	 * 会员查询自己的提现记录列表
	 */
	@Override
	public List<WithdrawCash> findMyWithdrawCashList(String sourceId, boolean closeConn, Page page, String vipUUID) {
		if(vipUUID == null){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select * from withdraw_cash where vipUUID = '").append(vipUUID).append("'");
		if(page == null){
			return (List<WithdrawCash>)sqldao.findListBySql(sourceId, sql.toString(),WithdrawCash.class, closeConn, null);
		}else{
			return (List<WithdrawCash>)sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, WithdrawCash.class, page, null);
		}
	}
	/**
	 * 查询会员的单条提现记录，更新提现状态时使用
	 */
	@Override
	public WithdrawCash findWithdrawCash(String sourceId, boolean closeConn, String cashUUID) {
		if(cashUUID == null || "".equals(cashUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select * from withdraw_cash where cashUUID = '").append(cashUUID).append("'");
		WithdrawCash withdrawCash = (WithdrawCash)sqldao.findEntityBySql(sourceId, sql.toString(), WithdrawCash.class, closeConn, null);
		if(withdrawCash == null){
			return null;
		}else{
			return withdrawCash;
		}
	}

}
