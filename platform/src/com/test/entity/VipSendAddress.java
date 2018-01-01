package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 会员自动添加的收货地址
 * @author chengyz
 *
 */
@Table(tableName="vip_send_address")
public class VipSendAddress {
	
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36,isNotNull=true,comment="地址uuid,全球唯一标识")
	private String addressUUID;

	@TableField(fieldSize=36,isNotNull=true,comment="会员uuid,全球唯一标识")
	private String vipUUID;
	
	@TableField(fieldSize=11,comment="会员手机号")
	private String vipPhoneNumber;
	
	@TableField(fieldSize=100,isNotNull=true,comment="文字地址")
	private String address;
	
	@TableField(fieldSize=50,comment="联系人")
	private String contactPeople;
	
	@TableField(fieldSize=6,comment="邮编")
	private String code;
	
	@TableField(fieldSize=11,comment="联系电话")
	private String contactPhoneNumber;
	
	@TableField(fieldSize=1,comment="是否为默认地址   为2表示是默认地址点，为1表示非默认点")
	private String flag;
	
	@TableField(fieldSize=100,isNotNull=true,comment="地址经度")
	private String longitude;
	
	@TableField(fieldSize=100,isNotNull=true,comment="地址玮度")
	private String latitude;
	
	@TableField(comment="门牌号")
	private String houseNumber;
	
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getVipPhoneNumber() {
		return vipPhoneNumber;
	}
	public void setVipPhoneNumber(String vipPhoneNumber) {
		this.vipPhoneNumber = vipPhoneNumber;
	}
	public Long getId() {
		return id;
	}
	public String getVipUUID() {
		return vipUUID;
	}

	public void setVipUUID(String vipUUID) {
		this.vipUUID = vipUUID;
	}
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	public String getContactPeople() {
		return contactPeople;
	}
	public void setContactPeople(String contactPeople) {
		this.contactPeople = contactPeople;
	}
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressUUID() {
		return addressUUID;
	}

	public void setAddressUUID(String addressUUID) {
		this.addressUUID = addressUUID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


    
	
	
}
