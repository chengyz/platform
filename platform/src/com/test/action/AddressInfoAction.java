package com.test.action;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import spark.annotation.Auto;
import spark.servlet.ISparkApplication;

import com.test.manage.AddressInfoMng;
/**
 * 收货地址和购买地址的action
 * @author chengyz
 *
 */
public class AddressInfoAction implements ISparkApplication {
	@Auto(name=AddressInfoMng.class)
	private AddressInfoMng addressInfoMng;
	@Override
	public void run() {
		/**
		 * 查询地址
		 */
		Spark.post(new Route("/hkdapp/addressInfo/findAddress",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return addressInfoMng.findAddress("jdbcread",false,request.raw(),response.raw());
			}
		});
		/**
		 * 查询地址列表
		 */
		Spark.post(new Route("/hkdapp/addressInfo/findAddressList",true,"jdbcread"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return addressInfoMng.findAddressList("jdbcread", false, request.raw(), response.raw());
			}
			
		});
		/**
		 * 会员删除地址
		 */
		Spark.post(new Route("/hkdapp/addressInfo/deleteAddress",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return addressInfoMng.deleteAddress("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 管理平台直接删除地址
		 */
		Spark.post(new Route("/hkdapp/addressInfo/delAddress",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return addressInfoMng.delAddress("jdbcwrite", false, request.raw(), response.raw());
			}
		});
		/**
		 * 保存或修改地址
		 */
		Spark.post(new Route("/hkdapp/addressInfo/saveOrUpAddress",true,"jdbcwrite"){
			@Override
			public Object handle(Request request,Response response) throws Exception{
				return addressInfoMng.saveOrUpAddress("jdbcwrite", false, request.raw(), response.raw());
			}
		});

	}

}
