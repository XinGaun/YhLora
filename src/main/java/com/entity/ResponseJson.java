package com.entity;



import redis.clients.jedis.Builder;
import redis.clients.jedis.Response;
@SuppressWarnings("all")
public class ResponseJson{
	private int status;//返回状态
	private Object data;//返回参数
	private String message;//返回信息
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
