package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.SystemMessage;

import dbengine.util.Page;

/**
 * 系统消息service接口
 * @author chengyz
 *
 */
public interface SystemMessageService {
	/**
	 * 查询系统消息
	 * @param sourceId
	 * @param closeConn
	 * @param uuid
	 * @return
	 */
	public SystemMessage findSystemMessage(String sourceId, boolean closeConn, String uuid);
	/**
	 * 删除系统消息
	 * @param sourceId
	 * @param closeConn
	 * @param addressUUID
	 * @return
	 */
	public boolean deleteSystemMessage(String sourceId, boolean closeConn, String uuid);
	/**
	 * 添加或修改系统消息
	 * @param sourceId
	 * @param closeConn
	 * @param addressInfo
	 * @return
	 */
	public boolean saveOrUpSystemMessage(String sourceId, boolean closeConn, SystemMessage systemMessage);
	/**
	 * 查询系统消息列表
	 * @param sourceId
	 * @param closeConn
	 * @param page
	 * @param findMap
	 * @return
	 */
	public List<SystemMessage> findSystemMessageList(String sourceId, boolean closeConn, Page page, Map<String,String> findMap);
	
	/**
	 * 查询系统消息所属app列表
	 * @param sourceId
	 * @param closeConn
	 * @return
	 */
	public Map findAppList(String sourceId, boolean closeConn);
	
}
