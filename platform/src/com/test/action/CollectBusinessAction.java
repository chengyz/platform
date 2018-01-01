package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.CollectBusinessMng;
/**
 * 会员收藏商家的action
 * @author chengyz
 *
 */
public class CollectBusinessAction implements ISparkApplication {
	@Auto(name=CollectBusinessMng.class)
	private CollectBusinessMng collectBusinessMng;
	@Override
	public void run() {
		/**
		 * 查询商家
		 */
		Spark.post(new Route("/hkdapp/collectBusiness/findAddress",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return collectBusinessMng.findBusiness("jdbcread",false,request.raw(),response.raw());
			}
		});
		/**
		 * 查询商家列表
		 */
		Spark.post(new Route("/hkdapp/collectBusiness/findBusinessList",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return collectBusinessMng.findBusinessList("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		/**
		 * 会员取消收藏
		 */
		Spark.post(new Route("/hkdapp/collectBusiness/cancelCollectBusiness",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return collectBusinessMng.cancelCollectBusiness("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 会员收藏商家（添加）
		 */
		Spark.post(new Route("/hkdapp/collectBusiness/saveBusiness",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return collectBusinessMng.saveBusiness("jdbcwrite", false, request.raw(), response.raw());
			}
		});

	}

}
