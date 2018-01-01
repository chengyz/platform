package com.test.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import spark.annotation.Auto;

import com.test.entity.EvaluateInfo;
import com.test.service.EvaluateInfoService;
import com.util.DateUtil;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import dbengine.util.Page;
/**
 * 评价的service实现类
 * @author chengyz
 *
 */
public class EvaluateInfoServiceImpl implements EvaluateInfoService {
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	@Auto(name=EntityDao.class)
	private EntityDao entityDao;
	/**
	 * 保存或修改评价
	 */
	@Override
	public boolean saveOrUpEvaluate(String sourceId, boolean closeConn, EvaluateInfo evaluateInfo) {
		if(evaluateInfo == null){
			return false;
		}
		if(evaluateInfo.getId() == null){
			evaluateInfo.setEvaluateUUID(UUID.randomUUID().toString());
			evaluateInfo.setEvaluateTime(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
			return entityDao.saveEntity(sourceId, evaluateInfo, closeConn);
		}else{
			return entityDao.updateEntity(sourceId, evaluateInfo, closeConn);
		}
	}
	/**
	 * 查询评价
	 */
	@Override
	public EvaluateInfo findEvaluate(String sourceId, boolean closeConn, String evaluateUUID) {
		if(evaluateUUID != null && !"".equals(evaluateUUID)){
			StringBuilder sql = new StringBuilder();
			sql.append("select * from evaluate_info where evaluateUUID = '").append(evaluateUUID).append("'");
			return (EvaluateInfo)sqldao.findEntityBySql(sourceId, sql.toString(), EvaluateInfo.class, closeConn, null);
		}else{
			return null;
		}
	}
	/**
	 * 查询评价列表
	 */
	@Override
	public List<Map> findEvaluateList(String sourceId, boolean closeConn, Page page, Map<String, String> findMap) {
		StringBuilder sql = new StringBuilder();
		if("1".equals(findMap.get("flag"))){
			sql.append("select e.*,v.vipName from evaluate_info e join vip_info v ");
			sql.append(" on e.getUUID = v.vipUUID ");
			
		}else if("2".equals(findMap.get("flag"))){
			sql.append("select e.*,v.vipName from evaluate_info e join vip_info v ");
			sql.append(" on e.vipUUID = v.vipUUID ");
		}
		sql.append(" where 1 = 1 ");
		if(findMap != null){
			if(!"".equals(findMap.get("vipUUID")) && findMap.get("vipUUID") != null ){
				if("1".equals(findMap.get("flag"))){
					sql.append(" and e.vipUUID = '").append(findMap.get("vipUUID")).append("'");
				}
				if("2".equals(findMap.get("flag"))){
					sql.append(" and e.getUUID = '").append(findMap.get("vipUUID")).append("'");
				}
			}
		}
		if(page == null){
			return sqldao.findMapListBysql(sourceId, sql.toString(), closeConn, null);
		}else{
			return sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, null, page, null);
		}
	}
	/**
	 * 查询评价列表(后台)
	 */
	@Override
	public List<EvaluateInfo> findEvaluateLists(String sourceId, boolean closeConn, Page page, Map<String, String> findMap) {
		StringBuilder sql = new StringBuilder();
		List<String> params = new ArrayList<String>();
		sql.append("select * from evaluate_info where 1 = 1 ");
		if(findMap != null){
			if(findMap.get("startTime") != null && !"".equals(findMap.get("startTime"))){
				sql.append("and evaluateTime  >= ? ");
				params.add(findMap.get("startTime"));
			}
			if(findMap.get("endTime") != null && !"".equals(findMap.get("endTime"))){
				sql.append("and evaluateTime <= ? ");
				params.add(findMap.get("endTime"));
			}
		}
		if(page == null){
			return sqldao.findListBySql(sourceId, sql.toString(), EvaluateInfo.class, closeConn, params);
		}else{
			return sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, EvaluateInfo.class, page, params);
		}
	}
	/**
	 * 删除评价
	 */
	@Override
	public boolean deleteEvaluate(String sourceId, boolean closeConn, String evaluateUUID) {
		if(evaluateUUID == null || "".equals(evaluateUUID)){
			return false;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("delete from evaluate_info where evaluateUUID = '").append(evaluateUUID).append("'");
		return sqldao.executeSql(sourceId, sql.toString(), closeConn, null);
	}
}
