package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.SystemMessageMng;
/**
 * 系统消息的接口
 * @author chengyz
 *
 */
public class SystemMessageAction implements ISparkApplication {
	@Auto(name=SystemMessageMng.class)
	private SystemMessageMng systemMessageMng;
	@Override
	public void run() {
		/**
		 * 添加或修改系统消息
		 */
		Spark.post(new Route("/hkdapp/systemMessage/saveOrUpdate",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return systemMessageMng.saveOrUpSystemMessage("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 删除系统消息
		 */
		Spark.post(new Route("/hkdapp/systemMessage/delete",true,"jdbcwrite") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return systemMessageMng.deleteSystemMessage("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 查询系统消息列表
		 */
		Spark.post(new Route("/hkdapp/systemMessage/list",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return systemMessageMng.findSystemMessageList("jdbcread", false, request.raw(), response.raw());
			}
		});
		/**
		 * 查询系统消息
		 */
		Spark.post(new Route("/hkdapp/systemMessage/systemMessage",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return systemMessageMng.findSystemMessage("jdbcread", false, request.raw(), response.raw());
			}
		});
		/**
		 * 查询系统消息所属的app列表
		 */
		Spark.post(new Route("/hkdapp/systemMessage/appList",true,"jdbcread") {		
			@Override
			public Object handle(Request request, Response response) throws Exception {
				return systemMessageMng.findAppList("jdbcread", false, request.raw(), response.raw());
			}
		});
	}
}
