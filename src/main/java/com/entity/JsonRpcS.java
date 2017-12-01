package com.entity;

import java.util.ArrayList;

public class JsonRpcS {
	private int id = 65541315;
	private String jsonrpc="2.0";
	private String method;
	private ArrayList<Object> params;
	public JsonRpcS(String method, ArrayList<Object> ota_path) {
		super();
		this.method = method;
		this.params = ota_path;
	}
	public String getJsonrpc() {
		return jsonrpc;
	}
	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}


	public ArrayList<Object> getParams() {
		return params;
	}
	public void setParams(ArrayList<Object> params) {
		this.params = params;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	
}
