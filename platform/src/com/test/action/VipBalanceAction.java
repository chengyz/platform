package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.VipBalanceMng;
/**
 * 会员余额的action
 * @author chengyz
 *
 */
public class VipBalanceAction implements ISparkApplication {
	@Auto(name=VipBalanceMng.class)
	private VipBalanceMng vipBalanceMng;
	@Override
	public void run() {
		/**
		 * 查询会员余额列表
		 */
		Spark.post(new Route("/hkdapp/vipBalance/list",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response)throws Exception{
				return vipBalanceMng.findVipBalanceList("jdbcread", false,request.raw(), response.raw());
			}
		});

		/**
		 * 查询会员个人余额
		 */
		Spark.post(new Route("/hkdapp/vipBalance/myBalance",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response)throws Exception{
				return vipBalanceMng.findVipBalance("jdbcread", false,request.raw(), response.raw());
			}
		});
	}

}
