package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 会员产生的订单表，会员每下一次订单，就在此表生产一条记录，如果该订单在会员充值记录表中已经记录，就删除
 * 当会员扫码后没有立即支付或者支付后没有等到跳转页面就关闭网页，不能从支付宝获得返回信息，此时支付宝会
 * 主动向notify_url发送返回值，此时是得不到session值的
 * @author hshzh
 *
 */
@Table(tableName = "vip_ref_merchantsordernum")
public class VipRefMerchantsOrderNum {
	@TableField(isPKey=true,isAutoIncrement=true,comment="主键，自动增长")
	private Long id;
	@TableField(fieldSize=36,comment="会员uuid")
	private String vipUUID;
	@TableField(fieldSize=50,comment="交易订单号(商户订单号)")
	private String merchantsOrderNo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVipUUID() {
		return vipUUID;
	}
	public void setVipUUID(String vipUUID) {
		this.vipUUID = vipUUID;
	}
	public String getMerchantsOrderNo() {
		return merchantsOrderNo;
	}
	public void setMerchantsOrderNo(String merchantsOrderNo) {
		this.merchantsOrderNo = merchantsOrderNo;
	}
}
