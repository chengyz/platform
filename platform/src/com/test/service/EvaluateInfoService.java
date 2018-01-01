package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.AppHomePage;
import com.test.entity.EvaluateInfo;

import dbengine.util.Page;

/**
 * 好快当评价的接口
 * @author chengyz
 *
 */
public interface EvaluateInfoService {
	/**
	 * 保存或修改评价
	 * @param sourceId
	 * @param closeConn
	 * @param evaluateInfo
	 * @return
	 */
	public boolean saveOrUpEvaluate(String sourceId ,boolean closeConn,EvaluateInfo evaluateInfo);
	/**
	 * 查询评价
	 * @param sourceId
	 * @param closeConn
	 * @param evaluateUUID
	 * @return
	 */
	public EvaluateInfo findEvaluate(String sourceId,boolean closeConn,String evaluateUUID);
	/**
	 * 查询评价列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public List<Map> findEvaluateList(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
	/**
	 * 查询评价列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public List<EvaluateInfo> findEvaluateLists(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
	/**
	 * 删除评价
	 * @param sourceId
	 * @param closeConn
	 * @param evaluateUUID
	 * @return
	 */
	public boolean deleteEvaluate(String sourceId,boolean closeConn,String evaluateUUID);
}
