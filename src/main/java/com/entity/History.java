package com.entity;
/**
 * 历史记录实体类
 * @author vip
 *
 */
public class History {
	private Integer _id;//主键
	private Integer meter_id;//所属表具ID
	private String readout;//读出器
	private String report_date;//登记日期
	private String value;//阀
	private Integer battery;//电池
	private Integer rssi;//接收信号
	public Integer get_id() {
		return _id;
	}
	public void set_id(Integer _id) {
		this._id = _id;
	}
	public Integer getMeter_id() {
		return meter_id;
	}
	public void setMeter_id(Integer meter_id) {
		this.meter_id = meter_id;
	}
	public String getReadout() {
		return readout;
	}
	public void setReadout(String readout) {
		this.readout = readout;
	}
	public String getReport_date() {
		return report_date;
	}
	public void setReport_date(String report_date) {
		this.report_date = report_date;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getBattery() {
		return battery;
	}
	public void setBattery(Integer battery) {
		this.battery = battery;
	}
	public Integer getRssi() {
		return rssi;
	}
	public void setRssi(Integer rssi) {
		this.rssi = rssi;
	}
	
	
	
}
