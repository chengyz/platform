package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.EvaluateInfoMng;
/**
 * 好快当评价的接口
 * @author chengyz
 *
 */
public class EvaluateInfoAction implements ISparkApplication {
	@Auto(name=EvaluateInfoMng.class)
	private EvaluateInfoMng evaluateInfoMng;
	/**
	 * 好快当评价图片的上传
	 */
	@Override
	public void run() {
		/**
		 * 上传评价的图片
		 */
		Spark.post(new Route("/hkdapp/evaluateInfo/uploadImages",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return evaluateInfoMng.uploadEvaluate(request.raw(), response.raw());
			}
		});
		/**
		 * 删除评价
		 */
		Spark.post(new Route("/hkdapp/evaluateInfo/deleteEvaluate",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return evaluateInfoMng.deleteEvaluate("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 查询评价列表（我的评价）
		 */
		Spark.post(new Route("/hkdapp/evaluateInfo/evaluatesList",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return evaluateInfoMng.findEvaluateList("jdbcread", false, request.raw(), response.raw());
			}
		});
		/**
		 * 查询评价列表（后台查询）
		 */
		Spark.post(new Route("/hkdapp/evaluateInfo/evaluatesLists",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return evaluateInfoMng.findEvaluateLists("jdbcread", false, request.raw(), response.raw());
			}
		});
		/**
		 * 添加或修改评价
		 */
		Spark.post(new Route("/hkdapp/evaluateInfo/saveOrUpEvaluate",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return evaluateInfoMng.saveOrUpEvaluate("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 查询跑客的UUID
		 */
		Spark.post(new Route("/hkdapp/evaluateInfo/findGetVipInfo",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return evaluateInfoMng.findGetVipInfo("jdbcread", false, request.raw(), response.raw());
			}
		});
	}
}
