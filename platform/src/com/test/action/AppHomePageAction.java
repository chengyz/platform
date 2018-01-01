package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.AppHomePageMng;
import com.util.ReadProperties;
import com.util.Uploader;
/**
 * 好快当APP首页图片的管理接口
 * @author chengyz
 *
 */
public class AppHomePageAction implements ISparkApplication {
	@Auto(name=AppHomePageMng.class)
	private AppHomePageMng appHomePageMng;
	/**
	 * 好快当APP首页轮播图片的上传
	 */
	@Override
	public void run() {
		/**
		 * 上传首页轮播图片
		 */
		Spark.post(new Route("/hkdapp/appHomePage/uploadImages",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return appHomePageMng.uploadImage(request.raw(), response.raw());
			}
		});
		/**
		 * 删除首页轮播图片
		 */
		Spark.post(new Route("/hkdapp/appHomePage/deleteImages",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return appHomePageMng.deleteImage("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 手机app查询首页轮播图片列表
		 */
		Spark.post(new Route("/hkdapp/appHomePage/imagesListM",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return appHomePageMng.findImageListM("jdbcread", false, request.raw(), response.raw());
			}
		});
		/**
		 * 后台查询首页轮播图片列表
		 */
		Spark.post(new Route("/hkdapp/appHomePage/imagesList",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return appHomePageMng.findImageList("jdbcread", false, request.raw(), response.raw());
			}
		});
		/**
		 * 添加或修改首页轮播图片
		 */
		Spark.post(new Route("/hkdapp/appHomePage/updateImages",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return appHomePageMng.saveOrUpImage("jdbcwrite", false, request.raw(), response.raw());
			}
		});
	}
}
