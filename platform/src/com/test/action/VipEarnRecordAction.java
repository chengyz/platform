package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.VipEarnRecordMng;
/**
 * 会员收入记录的action
 * @author chegnyz
 *
 */
public class VipEarnRecordAction implements ISparkApplication {
	@Auto(name=VipEarnRecordMng.class)
	private VipEarnRecordMng vipEarnRecordMng;
	@Override
	public void run() {
		/**
		 * 查询会员收入记录列表
		 */
		Spark.post(new Route("/hkdapp/vipEarnRecord/earnRecordlist",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response)throws Exception{
				return vipEarnRecordMng.findEarnRecordList("jdbcread", false,request.raw(), response.raw());
			}
		});
	}

}
