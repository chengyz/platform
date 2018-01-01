package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.CertificateInfo;

import dbengine.util.Page;

/**
 * 会员实名认证的接口
 * @author chengyz
 *
 */
public interface CertificateInfoService {
	/**
	 * 查询会员实名认证信息
	 * @param sourceId
	 * @param closeConn
	 * @param certUUID
	 * @return
	 */
	public CertificateInfo findCertificate(String sourceId,boolean closeConn,String vipUUID);
	/**
	 * 删除会员实名认证信息
	 * @param sourceId
	 * @param closeConn
	 * @param certUUID
	 * @return
	 */
	public boolean deleteCertificate(String sourceId,boolean closeConn,String certUUID);
	/**
	 * 查询实名认证信息列表（后台）
	 * @param sourceId
	 * @param closeConn
	 * @param findMap
	 * @return
	 */
	public List<CertificateInfo> findCertificateList(String sourceId,boolean closeConn,Page page,Map<String,String> findMap);
	/**
	 * 保存或修改实名认证信息（）
	 * @param sourceId
	 * @param closeConn
	 * @param certificateInfo
	 * @return
	 */
	public boolean saveOrUpCertificate(String sourceId,boolean closeConn,CertificateInfo certificateInfo);
	/**
	 * 通过实名认证UUID查询实名认证信息
	 * @param sourceId
	 * @param closeConn
	 * @param certUUID
	 * @return
	 */
	public CertificateInfo findCertificateByUUID(String sourceId, boolean closeConn, String certUUID);
	
}
