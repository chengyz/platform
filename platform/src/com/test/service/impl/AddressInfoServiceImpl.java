package com.test.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import spark.annotation.Auto;

import com.test.entity.AddressInfo;
import com.test.entity.CollectAddress;
import com.test.service.AddressInfoService;
import com.util.DateUtil;

import dbengine.dao.EntityDao;
import dbengine.dao.SqlDao;
import dbengine.util.Page;
/**
 * 地址的service实现
 * @author chengyz
 *
 */
public class AddressInfoServiceImpl implements AddressInfoService {
	@Auto(name=SqlDao.class)
	private SqlDao sqldao;
	
	@Auto(name=EntityDao.class)
	private EntityDao entityDao;
	/**
	 * 查询地址
	 */
	@Override
	public AddressInfo findAddress(String sourceId, boolean closeConn, String addressUUID) {
		if(addressUUID == null && "".equals(addressUUID)){
			return null;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("select * from address_info where addressUUID = '").append(addressUUID.replace("'", "")).append("'");
		return (AddressInfo)sqldao.findEntityBySql(sourceId, sql.toString(), AddressInfo.class, closeConn, null);
	}
	
	/**
	 * 删除地址即是取消收藏
	 */
	@Override
	public boolean deleteAddress(String sourceId, boolean closeConn, String addressUUID,String vipUUID) {
		if(addressUUID == null || "".equals(addressUUID) || vipUUID == null || "".equals(vipUUID)){
			return false;
		}
		StringBuilder sql2 = new StringBuilder();
		List<String> params = new ArrayList<String>();
		sql2.append("delete from collect_address where addressUUID = ?");//先删除收藏地址表中的记录
		params.add(addressUUID);
		sql2.append(" and vipUUID = ?");
		params.add(vipUUID);
		sqldao.executeSql(sourceId, sql2.toString(), closeConn, params);
		
		StringBuilder sql3 = new StringBuilder();
		sql3.append("select * from collect_address where addressUUID = '").append(addressUUID).append("'");//如果其他会员也收藏了该地址则在地址表中不删除，否则删除
		CollectAddress coll = (CollectAddress)sqldao.findEntityBySql(sourceId, sql3.toString(), CollectAddress.class, closeConn, null);
		if(coll == null){
			StringBuilder sql1 = new StringBuilder();
			sql1.append("delete from address_info where addressUUID = '").append(addressUUID.replace("'", "")).append("'");//再删除地址表中的地址点
			sqldao.executeSql(sourceId, sql1.toString(), closeConn, null);
		}
		return true;
	}
	/**
	 * 直接删除地址
	 */
	@Override
	public boolean delAddress(String sourceId, boolean closeConn, String addressUUID) {
		if(addressUUID == null || "".equals(addressUUID)){
			return false;
		}
		StringBuilder sql = new StringBuilder();
		sql.append("delete from address_info where addressUUID = '").append(addressUUID.replace("'", "")).append("'");//再删除地址表中的地址点
		return sqldao.executeSql(sourceId, sql.toString(), closeConn, null);
	}
	/**
	 * 保存地址点（即是会员将该地址收藏或在好快当app的‘我的’中点击收货地址进行新增）
	 */
	@Override
	public String saveOrUpAddress(String sourceId, boolean closeConn, AddressInfo addressInfo,Map<String,String> map) {
		if(addressInfo == null){
			return "";
		}
		StringBuilder sql = new StringBuilder();
		if(map.get("vipUUID") != null && !"".equals(map.get("vipUUID"))){
			sql.append("select * from collect_address where vipUUID = '").append(map.get("vipUUID")).append("'");
		}
		if(addressInfo.getLatitude() != null && !"".equals(addressInfo.getLatitude())){
			sql.append(" and latitude = '").append(addressInfo.getLatitude()).append("'");
		}
		if(addressInfo.getLongitude() != null && !"".equals(addressInfo.getLongitude())){
			sql.append(" and longitude = '").append(addressInfo.getLongitude()).append("'");
		}
		CollectAddress c = (CollectAddress)sqldao.findEntityBySql(sourceId, sql.toString(), CollectAddress.class, closeConn, null);
		if(c == null){
			String addressUUID = UUID.randomUUID().toString();
			addressInfo.setAddressUUID(addressUUID);
			c = new CollectAddress();
			c.setCollectUUID(UUID.randomUUID().toString());
			c.setAddressUUID(addressUUID);
			c.setVipUUID(map.get("vipUUID"));
			c.setVipPhoneNumber(map.get("vipPhoneNumber"));
			c.setLatitude(addressInfo.getLatitude());
			c.setLongitude(addressInfo.getLongitude());
			c.setCollectTime(DateUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			entityDao.saveEntity(sourceId, c, closeConn);//添加地址点和会员UUID到收藏表中
			entityDao.saveEntity(sourceId, addressInfo, closeConn);//添加地址到地址信息表中
			return addressUUID;
		}else{
			return "-2";
		}
		
	}
	
	/**
	 * 查询地址列表
	 */
	@Override
	public List<Map> findAddressList(String sourceId, boolean closeConn, Page page, Map<String, String> findMap) {
		StringBuilder sql = new StringBuilder();
		sql.append("select a.*,c.vipPhoneNumber,c.collectTime from address_info a join collect_address c on a.addressUUID = c.addressUUID where 1 = 1 ");
		if(findMap != null){
			if(findMap.get("vipPhoneNumber") != null && !"".equals(findMap.get("vipPhoneNumber"))){
				sql.append(" and c.vipPhoneNumber = '").append(findMap.get("vipPhoneNumber").replace("'", "")).append("'");
			}
			if(findMap.get("vipUUID") != null && !"".equals(findMap.get("vipUUID"))){
				sql.append(" and c.vipUUID = '").append(findMap.get("vipUUID").replace("'", "")).append("'");
			}
			if(findMap.get("address") != null && !"".equals(findMap.get("address"))){
				sql.append(" and a.address like '%").append(findMap.get("address").replace("'", "")).append("%'");
			}
		}
		if(page == null){
			return sqldao.findMapListBysql(sourceId, sql.toString(), closeConn, null);
		}else{
			return sqldao.findPageByMysql(sourceId, sql.toString(), closeConn, null, page, null);
		}
	}

}
