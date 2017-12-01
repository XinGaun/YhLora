package com.entity;
/**
 * 测试功能实体类
 * @author vip
 *
 */
public class Firmware {
	private Integer _id;//主键
	private Integer hub_id;//所属集中器ID
	private String customer;//客户名称
	private String address;//地址
	private String model;//型号
	private String version;//版本号
	private Integer size;//大小
	private String path;//通道
	private String state;//配置
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
