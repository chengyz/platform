/**
 * 
 */
package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.VipEarnRecord;

import dbengine.util.Page;

/**
 * 会员收入记录service接口
 * @author chengyz
 *
 */
public interface VipEarnRecordService {
	/**
	 * 保存或修改收入记录信息
	 * @param sourceId
	 * @param closeConn
	 * @param t
	 * @return
	 */
	public boolean saveOrUpdate(String sourceId,boolean closeConn,VipEarnRecord v);
	/**
	 * 查询会员收入记录列表
	 * @param sourceId
	 * @param closeConn
	 * @param vipConsumptionRecord
	 * @return
	 */
	public List<VipEarnRecord> findVipEarnRecordList(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
}
