package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.FeedBackInfo;

import dbengine.util.Page;

/**
 * 反馈信息的service接口
 * @author chengyz
 *
 */
public interface FeedBackInfoService {
	/**
	 * 保存或修改反馈信息
	 * @param sourceId
	 * @param closeConn
	 * @param order
	 * @return
	 */
	boolean saveOrUpdateFeedBackInfo(String sourceId, boolean closeConn, FeedBackInfo feedBackInfo);
	/**
	 * 删除反馈信息
	 * @param sourceId
	 * @param closeConn
	 * @param uuid
	 * @return
	 */
	boolean deleteFeedBackInfo(String sourceId, boolean closeConn, String uuid);
	/**
	 * 查询反馈信息
	 * @param sourceId
	 * @param closeConn
	 * @param uuid
	 * @return
	 */
	FeedBackInfo findFeedBackInfo(String sourceId, boolean closeConn, String uuid);
	/**
	 * 查询反馈信息列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	List<FeedBackInfo> findFeedBackInfoList(String sourceId, boolean closeConn, Page page, Map findMap);
	
	
	
	
}
