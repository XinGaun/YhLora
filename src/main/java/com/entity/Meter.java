package com.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * 表具实体类
 * @author vip
 *
 */
public class Meter {
	private Integer _id;//主键
	private Integer hub_id;//所属集中器ID(外键)
	private String customer;//客户名称
	private String address;//表具地址
	private String model;//表具型号
	private String firmware;//表具固件版本号
	private JSONObject state;//运行状态,表具配置,表具上报历史详情
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	public Integer getHub_id() {
		return hub_id;
	}
	public void setHub_id(Integer hub_id) {
		this.hub_id = hub_id;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFirmware() {
		return firmware;
	}
	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}
	public JSONObject getState() {
		return state;
	}
	public void setState(JSONObject state) {
		this.state = state;
	}
	
	
	
	
}
