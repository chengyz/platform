package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.CertificateInfoMng;
/**
 * 会员实名认证的action
 * @author chengyz
 *
 */
public class CertificateInfoAction implements ISparkApplication {
	
	@Auto(name=CertificateInfoMng.class)
	private CertificateInfoMng certificateInfoMng;
	
	@Override
	public void run() {
		/**
		 * 查询单个会员的认证信息
		 */
		Spark.post(new Route("/hkdapp/certificate/findCertificate",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return certificateInfoMng.findCertificate("jdbcread",false,request.raw(),response.raw());
			}
		});
		/**
		 * 查询实名认证信息列表
		 */
		Spark.post(new Route("/hkdapp/certificate/findCertificateList",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return certificateInfoMng.findCertificateList("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		/**
		 * 删除实名认证信息
		 */
		Spark.post(new Route("/hkdapp/certificate/deleteCertificate",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return certificateInfoMng.deleteCertificate("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 保存或修改实名认证信息（会员）
		 */
		Spark.post(new Route("/hkdapp/certificate/saveCertificate",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return certificateInfoMng.saveOrUpCertificate("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 保存或修改实名认证信息（后台审核）
		 */
		Spark.post(new Route("/hkdapp/certificate/updateCertificate",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return certificateInfoMng.updateCertificate("jdbcwrite", false, request.raw(), response.raw());
			}
		});
	}

}
