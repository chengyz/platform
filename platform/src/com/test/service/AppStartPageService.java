package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.AppStartPage;

import dbengine.util.Page;

/**
 * App启动页service接口
 * @author chengyz
 *
 */
public interface AppStartPageService {
	/**
	 * 保存或修改App启动页图片
	 * @param sourceId
	 * @param closeConn
	 * @param appHomePage
	 * @return
	 */
	public boolean saveOrUpImage(String sourceId ,boolean closeConn,AppStartPage appStartPage);
	/**
	 * 查询App启动页图片
	 * @param sourceId
	 * @param closeConn
	 * @param pageUUID
	 * @return
	 */
	public AppStartPage findImage(String sourceId,boolean closeConn,String pageUUID);
	/**
	 * 手机app查询启动页图片列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public List<AppStartPage> findImageListM(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
	/**
	 * 后台查询App启动页图片列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public List<AppStartPage> findImageList(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
	/**
	 * 删除App启动页图片
	 * @param sourceId
	 * @param closeConn
	 * @param pageUUID
	 * @return
	 */
	public boolean deleteImage(String sourceId,boolean closeConn,String pageUUID);
}
