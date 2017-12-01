package com.entity;

import java.io.Serializable;

/**
 * 集中器实体类
 * @author vip
 *
 */
public class Hub implements Serializable{
	private static final long serialVersionUID = -5141784402935371524L;
	private static String id;//主键
	private static String addr;//集中器地址
	private static String peer_addr;//客户地址
	private static String firmware;//固件
	private static String voltage;//电压
	private static String signal;//信号
	private static String install_power;//供电方式,安装状态
	private static String plot;//小区信息
	private static String status;//集中器状态
	private static String host;//服务器地址
	private static String port;//服务器端口
	private static String kp_interval;//心跳间隔
	private static String reseta_time;//重置时间
	private static String login;//登录时间
	private static String keepalive;//持续心跳
	private static String logout;//退出时间
	private static String client;//客户
	private static String model;//集中器型号
	
	public Hub() {
	}
	public Hub(String id, String addr, String peer_addr, String firmware, String voltage, String signal,
			String install_power, String plot, String status, String host, String port, String kp_interval,
			String reseta_time, String login, String keepalive, String logout, String client, String model) {
		super();
		Hub.id = id;
		Hub.addr = addr;
		Hub.peer_addr = peer_addr;
		Hub.firmware = firmware;
		Hub.voltage = voltage;
		Hub.signal = signal;
		Hub.install_power = install_power;
		Hub.plot = plot;
		Hub.status = status;
		Hub.host = host;
		Hub.port = port;
		Hub.kp_interval = kp_interval;
		Hub.reseta_time = reseta_time;
		Hub.login = login;
		Hub.keepalive = keepalive;
		Hub.logout = logout;
		Hub.client = client;
		Hub.model = model;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		Hub.id = id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		Hub.addr = addr;
	}
	public String getPeer_addr() {
		return peer_addr;
	}
	public void setPeer_addr(String peer_addr) {
		Hub.peer_addr = peer_addr;
	}
	public String getFirmware() {
		return firmware;
	}
	public void setFirmware(String firmware) {
		Hub.firmware = firmware;
	}
	public String getVoltage() {
		return voltage;
	}
	public void setVoltage(String voltage) {
		Hub.voltage = voltage;
	}
	public String getSignal() {
		return signal;
	}
	public void setSignal(String signal) {
		Hub.signal = signal;
	}
	public String getInstall_power() {
		return install_power;
	}
	public void setInstall_power(String install_power) {
		Hub.install_power = install_power;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		Hub.plot = plot;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		Hub.status = status;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		Hub.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		Hub.port = port;
	}
	public String getKp_interval() {
		return kp_interval;
	}
	public void setKp_interval(String kp_interval) {
		Hub.kp_interval = kp_interval;
	}
	public String getReseta_time() {
		return reseta_time;
	}
	public void setReseta_time(String reseta_time) {
		Hub.reseta_time = reseta_time;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		Hub.login = login;
	}
	public String getKeepalive() {
		return keepalive;
	}
	public void setKeepalive(String keepalive) {
		Hub.keepalive = keepalive;
	}
	public String getLogout() {
		return logout;
	}
	public void setLogout(String logout) {
		Hub.logout = logout;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		Hub.client = client;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		Hub.model = model;
	}
	public long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
