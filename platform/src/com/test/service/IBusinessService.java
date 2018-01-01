package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.BusinessInfo;

import dbengine.util.Page;

public interface IBusinessService {
	/**
	 * 保存或修改商家信息
	 * @param busnInfo
	 * @return
	 */
	public boolean saveOrUpBusiness(String sourceId,boolean closeConn,BusinessInfo busnInfo) throws Exception ;
	
	/**
	 * 通过uuid查询商家信息
	 * @param businessUUID
	 * @return
	 */
	public BusinessInfo findBusinessInfo(String sourceId,boolean closeConn,String businessUUID);
	
	/**
	 * 查商家信息列表
	 * @param sourceId
	 * @param closeConn
	 * @param findMap
	 * @return
	 */
	public List<BusinessInfo> findBussinessList(String sourceId,boolean closeConn,Page page,Map findMap);
	
	/**
	 * 删除商家信息
	 * @param sourceId
	 * @param closeConn
	 * @param businessUUID
	 * @return
	 */
	public boolean delBusinessInfo(String sourceId,boolean closeConn,String businessUUID);
	/**
	 * 查询商家列表的类型和区域
	 * @param sourceId
	 * @param closeConn
	 * @return
	 */
	public Map findTypeAreaList(String sourceId,boolean closeConn);
}
