package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.FeedBackInfoMng;
/**
 * 反馈信息的接口
 * @author chengyz
 *
 */
public class FeedBackInfoAction implements ISparkApplication {
	@Auto(name=FeedBackInfoMng.class)
	private FeedBackInfoMng feedBackInfoMng;
	@Override
	public void run() {
		/**
		 * 添加或修改反馈信息
		 */
		Spark.post(new Route("/hkdapp/feedBackInfo/saveOrUpdate",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return feedBackInfoMng.saveOrUpdateFeedBackInfo("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 删除反馈信息
		 */
		Spark.post(new Route("/hkdapp/feedBackInfo/delete",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return feedBackInfoMng.deleteFeedBackInfo("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 查询反馈信息列表
		 */
		Spark.post(new Route("/hkdapp/feedBackInfo/list",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return feedBackInfoMng.findFeedBackInfoList("jdbcread", false, request.raw(), response.raw());
			}
		});
		/**
		 * 查询反馈信息
		 */
		Spark.post(new Route("/hkdapp/feedBackInfo/feedBackInfo",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return feedBackInfoMng.findFeedBackInfo("jdbcread", false, request.raw(), response.raw());
			}
		});
		/**
		 * 修改反馈信息状态
		 */
		Spark.post(new Route("/hkdapp/feedBackInfo/changeStatus",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return feedBackInfoMng.changeStatus("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 上传反馈的图片
		 */
		Spark.post(new Route("/hkdapp/feedBackInfo/uploadPicture",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return feedBackInfoMng.uploadPicture(request.raw(), response.raw());
			}
		});
	}
}
