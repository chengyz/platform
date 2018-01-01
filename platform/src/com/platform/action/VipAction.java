package com.platform.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.platform.manage.VipMng;
import com.util.ReadProperties;
import com.util.Uploader;

public class VipAction implements ISparkApplication {

	@Auto(name=VipMng.class)
	private VipMng vipMng;
	@Override
	public void run() {
		Spark.post(new Route("/system/vip/savaVip",true,"jdbcwrite"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.saveVip("jdbcwrite", false, request.raw(), response.raw());
			}
			
		});
		Spark.post(new Route("/system/vip/updateVipInfo",true,"jdbcwrite"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.updateVipInfo("jdbcwrite", false, request.raw(), response.raw());
			}
			
		});
		Spark.post(new Route("/system/vip/findVipByUUID",true,"jdbcread"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.findVipByUUID("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		Spark.post(new Route("/system/vip/findVipByOrderUUID",true,"jdbcread"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.findVipByOrderUUID("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		Spark.post(new Route("/system/vip/findVipByMap",true,"jdbcread"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.findVipByMap("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		Spark.post(new Route("/system/vip/findVipList",true,"jdbcread"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.findVipList("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		/**
		 * 会员登陆
		 */
		Spark.post(new Route("/system/vip/VipLogin", true, "jdbcwrite") {
			@Override
			public Object handle(Request request, Response response) {
				return vipMng.VipLogin("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		Spark.post(new Route("/system/vip/upVipPwd",true,"jdbcwrite"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.upVipPwd("jdbcwrite", false, request.raw(), response.raw());
			}
			
		});
		Spark.post(new Route("/system/vip/checkVipMobileExit",true,"jdbcread"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.checkVipMobileExit("jdbcwrite", false, request.raw(), response.raw());
			}
			
		});
		Spark.post(new Route("/system/vip/delVip",true,"jdbcwrite"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.delVip("jdbcwrite", false, request.raw(), response.raw());
			}
			
		});
		Spark.post(new Route("/system/vip/upVipStatus",true,"jdbcwrite"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.upVipStatus("jdbcwrite", false, request.raw(), response.raw());
			}
			
		});
		Spark.post(new Route("/system/vip/upVipPic",true,"jdbcwrite"){
			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				String basePath = ReadProperties.getValue("imgUploadPath");//得到config配置文件的主路径
				Uploader up = new Uploader(request.raw());
				up.setSavePath(basePath);
				String[] fileType = {".jpg" , ".jpeg" , ".png" , ".gif"};
				up.setAllowFiles(fileType);
				up.setMaxSize(10000); //单位KB
				up.upload();
				String url = up.getUrl();//文件访问路径
				return url;
			}
		});
		
		Spark.post(new Route("/system/vip/findVipMenuByVipUUID",true,"jdbcread"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.findVipMenuByVipUUID("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		Spark.post(new Route("/system/vip/findVipCount",true,"jdbcread"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.findVipCount("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		Spark.post(new Route("/system/vip/findVipLoginNameExit",true,"jdbcread"){

			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.findVipLoginNameExit("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		/**
		 * 通过验证码修改密码
		 */
		Spark.post(new Route("/system/vip/upVipPwdByPassCode",true,"jdbcwrite"){
			@Override
			public Object handle(Request request, Response response)
					throws Exception {
				return vipMng.upVipPwdByPassCode("jdbcwrite", false, request.raw(), response.raw());
			}
			
		});
		
	}

}
