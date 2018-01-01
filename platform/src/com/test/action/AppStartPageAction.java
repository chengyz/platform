package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.AppStartPageMng;
/**
 * 好快当APP启动页图片的管理接口
 * @author chengyz
 *
 */
public class AppStartPageAction implements ISparkApplication {
	@Auto(name=AppStartPageMng.class)
	private AppStartPageMng appStartPageMng;
	/**
	 * 好快当APP启动页轮播图片的上传
	 */
	@Override
	public void run() {
		/**
		 * 上传启动页轮播图片
		 */
		Spark.post(new Route("/hkdapp/appStartPage/uploadImages",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return appStartPageMng.uploadImage(request.raw(), response.raw());
			}
		});
		/**
		 * 删除启动页轮播图片
		 */
		Spark.post(new Route("/hkdapp/appStartPage/deleteImages",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return appStartPageMng.deleteImage("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 手机app查询启动页轮播图片列表
		 */
		Spark.post(new Route("/hkdapp/appStartPage/imagesListM",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return appStartPageMng.findImageListM("jdbcread", false, request.raw(), response.raw());
			}
		});
		/**
		 * 后台查询启动页轮播图片列表
		 */
		Spark.post(new Route("/hkdapp/appStartPage/imagesList",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return appStartPageMng.findImageList("jdbcread", false, request.raw(), response.raw());
			}
		});
		/**
		 * 添加或修改启动页轮播图片
		 */
		Spark.post(new Route("/hkdapp/appStartPage/updateImages",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return appStartPageMng.saveOrUpImage("jdbcwrite", false, request.raw(), response.raw());
			}
		});
	}
}
