package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.ExceptionOrderMng;
/**
 * 异常订单处理的接口
 * @author chengyz
 *
 */
public class ExceptionOrderAction implements ISparkApplication {
	@Auto(name=ExceptionOrderMng.class)
	private ExceptionOrderMng exceptionOrderMng;
	@Override
	public void run() {
		/**
		 * 添加或修改异常订单处理信息
		 */
		Spark.post(new Route("/hkdapp/exceptionOrder/saveOrUpdate",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return exceptionOrderMng.saveOrUpdateExceptionOrder("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 删除异常订单处理信息
		 */
		Spark.post(new Route("/hkdapp/exceptionOrder/delete",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return exceptionOrderMng.deleteExceptionOrder("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 查询异常订单处理信息列表
		 */
		Spark.post(new Route("/hkdapp/exceptionOrder/list",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return exceptionOrderMng.findExceptionOrderList("jdbcread", false, request.raw(), response.raw());
			}
		});
		/**
		 * 查询异常订单处理信息
		 */
		Spark.post(new Route("/hkdapp/exceptionOrder/exceptionOrder",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return exceptionOrderMng.findExceptionOrder("jdbcread", false, request.raw(), response.raw());
			}
		});
	}
}
