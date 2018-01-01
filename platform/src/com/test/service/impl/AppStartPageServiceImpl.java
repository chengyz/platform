package com.test.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import spark.annotation.Auto;

import com.test.entity.AppHomePage;
import com.test.entity.AppStartPage;
import com.test.service.AppStartPageService;
import com.util.DateTimeUtil;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import dbengine.util.Page;
/**
 * App启动页service接口
 * @author chengyz
 *
 */
public class AppStartPageServiceImpl implements AppStartPageService {
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	
	@Auto(name=EntityDao.class)
	private EntityDao entityDao;
	/**
	 * 保存或修改App启动页图片
	 */
	@Override
	public boolean saveOrUpImage(String sourceId, boolean closeConn, AppStartPage appStartPage) {
		if(appStartPage == null){
			return false;
		}
		if(appStartPage.getId() == null){
			appStartPage.setPageUUID(UUID.randomUUID().toString());
			appStartPage.setCreateTime(DateTimeUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			return entityDao.saveEntity(sourceId, appStartPage, closeConn);
		}else{
			return entityDao.updateEntity(sourceId, appStartPage, closeConn);
		}
	}
	/**
	 * 查询App启动页图片
	 */
	@Override
	public AppStartPage findImage(String sourceId, boolean closeConn, String pageUUID) {
		if(pageUUID != null && !"".equals(pageUUID)){
			StringBuilder sql = new StringBuilder();
			sql.append("select * from app_start_page where pageUUID = '").append(pageUUID).append("'");
			return (AppStartPage)sqldao.findEntityBySql(sourceId, sql.toString(), AppStartPage.class, closeConn, null);
		}else{
			return null;
		}
	}
	/**
	 * 手机app查询启动页图片列表
	 */
	@Override
	public List<AppStartPage> findImageListM(String sourceId, boolean closeConn, Page page, Map<String, String> findMap) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("select * from app_start_page where disable = '2'");
		if(findMap.get("belongApp") != null && !"".equals(findMap.get("belongApp"))) {
			sql.append(" and belongApp = '").append(findMap.get("belongApp")).append("'");
		}
		sql.append(" order by displayOrder");
		if(page == null){
			return sqldao.findListBySql(sourceId, sql.toString(), AppStartPage.class, closeConn, null);
		}else{
			return sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, AppStartPage.class, page, null);
		}
	}
	/**
	 * 后台查询App启动页图片列表
	 */
	@Override
	public List<AppStartPage> findImageList(String sourceId, boolean closeConn, Page page, Map<String, String> findMap) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from app_start_page order by displayOrder");
		if(page == null){
			return sqldao.findListBySql(sourceId, sql.toString(), AppHomePage.class, closeConn, null);
		}else{
			return sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, AppHomePage.class, page, null);
		}
	}
	/**
	 * 删除App启动页图片
	 */
	@Override
	public boolean deleteImage(String sourceId, boolean closeConn, String pageUUID) {
		if(pageUUID == null){
			return false;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("delete from app_start_page where pageUUID = '").append(pageUUID).append("'");
		return sqldao.executeSql(sourceId, sql.toString(), closeConn, null);
	}

}
