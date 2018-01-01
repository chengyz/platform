package com.platform.service;

import java.util.List;

import com.platform.entity.AppInfo;

import dbengine.util.Page;

/**
 * app信息的接口
 * @author chengyz
 *
 */
public interface AppInfoService {
	/**
	 * 查询APP信息列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @return
	 */
	public List<AppInfo> findAppInfoList(String sourceId,boolean closeConn,Page page);
	/**
	 * 添加或修改app版本信息
	 * @param sourceId
	 * @param closeConn
	 * @param appInfo
	 * @return
	 */
	public String saveOrUpAppInfo(String sourceId,boolean closeConn,AppInfo appInfo);
	/**
	 * 通过appname查询最新版本的APP
	 * @param sourceId
	 * @param closeConn
	 * @param appName
	 * @return
	 */
	public AppInfo findAppInfo(String sourceId, boolean closeConn, String appName,String appType);
	/**
	 * 删除APP信息
	 * @param sourceId
	 * @param closeConn
	 * @param appUUID
	 * @return
	 */
	public boolean deleteAppInf(String sourceId,boolean closeConn,String appUUID);
}
