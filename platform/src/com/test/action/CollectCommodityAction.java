package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.CollectCommodityMng;
/**
 * 会员收藏商品的action
 * @author chengyz
 *
 */
public class CollectCommodityAction implements ISparkApplication {
	@Auto(name=CollectCommodityMng.class)
	private CollectCommodityMng collectCommodityMng;
	@Override
	public void run() {
		/**
		 * 查询商品
		 */
		Spark.post(new Route("/hkdapp/collectCommodity/findCommodity",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return collectCommodityMng.findCommodity("jdbcread",false,request.raw(),response.raw());
			}
		});
		/**
		 * 查询商品列表
		 */
		Spark.post(new Route("/hkdapp/collectCommodity/findCommodityList",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return collectCommodityMng.findCommodityList("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		/**
		 * 会员取消收藏商品
		 */
		Spark.post(new Route("/hkdapp/collectCommodity/cancelCollectCommodity",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return collectCommodityMng.cancelCollectCommodity("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 会员收藏商品（添加）
		 */
		Spark.post(new Route("/hkdapp/collectCommodity/saveCommodity",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return collectCommodityMng.saveCommodity("jdbcwrite", false, request.raw(), response.raw());
			}
		});

	}

}
