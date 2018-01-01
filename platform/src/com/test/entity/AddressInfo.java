package com.test.entity;

import dbengine.annotation.Table;
import dbengine.annotation.TableField;

/**
 * 地址信息
 * @author chengyz
 *
 */
@Table(tableName="address_info")
public class AddressInfo {
	
	@TableField(isPKey=true,isNotNull=true,isAutoIncrement=true,comment="主键Id,自动增长")
	private Long id;
	
	@TableField(fieldSize=36,isNotNull=true,comment="地址uuid,全球唯一标识")
	private String addressUUID;

	@TableField(fieldSize=100,isNotNull=true,comment="文字地址")
	private String address;
	
	@TableField(fieldSize=100,isNotNull=true,comment="地址经度")
	private String longitude;
	
	@TableField(fieldSize=100,isNotNull=true,comment="地址玮度")
	private String latitude;
	
	@TableField(fieldSize=1,isNotNull=true,comment="购买地址为1   收货地址为2   发货地址为3   取货地址为4 ")
	private String flag;
	
	@TableField(comment="门牌号")
	private String houseNumber;
	
	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public Long getId() {
		return id;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
