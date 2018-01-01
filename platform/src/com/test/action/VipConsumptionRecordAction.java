package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.VipConsumptionRecordMng;
/**
 * 会员消费记录的action
 * @author chegnyz
 *
 */
public class VipConsumptionRecordAction implements ISparkApplication {
	@Auto(name=VipConsumptionRecordMng.class)
	private VipConsumptionRecordMng vipConsumptionRecordMng;
	@Override
	public void run() {
		/**
		 * 查询会员消费记录列表
		 */
		Spark.post(new Route("/hkdapp/consumptionRecord/consumptionRecordList",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response)throws Exception{
				return vipConsumptionRecordMng.findConsumptionRecordList("jdbcread", false,request.raw(), response.raw());
			}
		});
	}

}
