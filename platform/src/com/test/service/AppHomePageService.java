package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.AppHomePage;

import dbengine.util.Page;

/**
 * App首页图片service接口
 * @author chengyz
 *
 */
public interface AppHomePageService {
	/**
	 * 保存或修改首页图片
	 * @param sourceId
	 * @param closeConn
	 * @param appHomePage
	 * @return
	 */
	public boolean saveOrUpImage(String sourceId ,boolean closeConn,AppHomePage appHomePage);
	/**
	 * 查询首页图片
	 * @param sourceId
	 * @param closeConn
	 * @param pageUUID
	 * @return
	 */
	public AppHomePage findImage(String sourceId,boolean closeConn,String pageUUID);
	/**
	 * 手机app查询首页图片列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public List<AppHomePage> findImageListM(String sourceId, boolean closeConn, String belong);
	/**
	 * 后台查询首页图片列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public List<AppHomePage> findImageList(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
	/**
	 * 删除首页图片
	 * @param sourceId
	 * @param closeConn
	 * @param pageUUID
	 * @return
	 */
	public boolean deleteImage(String sourceId,boolean closeConn,String pageUUID);
}
