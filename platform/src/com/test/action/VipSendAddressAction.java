package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.VipSendAddressMng;
/**
 * 会员收货地址的action
 * @author chengyz
 *
 */
public class VipSendAddressAction implements ISparkApplication {
	@Auto(name=VipSendAddressMng.class)
	private VipSendAddressMng vipSendAddressMng;
	@Override
	public void run() {
		/**
		 * 查询地址
		 */
		Spark.post(new Route("/hkdapp/vipSendAddress/findAddress",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return vipSendAddressMng.findAddress("jdbcread",false,request.raw(),response.raw());
			}
		});
		/**
		 * 查询地址列表
		 */
		Spark.post(new Route("/hkdapp/vipSendAddress/findAddressList",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return vipSendAddressMng.findAddressList("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		/**
		 * 会员删除地址
		 */
		Spark.post(new Route("/hkdapp/vipSendAddress/deleteAddress",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return vipSendAddressMng.deleteAddress("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 保存默认地址
		 */
		Spark.post(new Route("/hkdapp/vipSendAddress/saveOrUpAddress",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return vipSendAddressMng.saveAddress("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 修改默认  收货地址
		 */
		Spark.post(new Route("/hkdapp/vipSendAddress/updataDefaultAddress",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return vipSendAddressMng.updataDefaultAddress("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 会员取消或设置为默认地址
		 */
		Spark.post(new Route("/hkdapp/vipSendAddress/cancelDefaultAddress",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return vipSendAddressMng.cancelDefaultAddress("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 查询默认收货地址
		 */
		Spark.post(new Route("/hkdapp/vipSendAddress/findDefaultAddress",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return vipSendAddressMng.findDefaultAddress("jdbcread",false,request.raw(),response.raw());
			}
		});
	}

}
