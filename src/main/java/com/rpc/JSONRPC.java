package com.rpc;
import java.util.ArrayList;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.entity.JsonRpcS;
import com.util.HttpReq;

/**
 * RPC http 调用类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
public class JSONRPC {
	public static HashMap<String,Object> map = new HashMap<String,Object>();
	private String url="http://192.168.8.2:3398";
	/**
	 * 获取ota固件保存路径
	 * @throws Throwable
	 */
	public void ota_path() throws Throwable{
		JsonRpcS jsonRpcS = new JsonRpcS("ota_path",new ArrayList<Object>());
		String json = JSON.toJSONString(jsonRpcS);
		System.out.println(json);
		String str = HttpReq.httpRequest(url,"POST",json);
		HashMap<String, Object> hashMap = JSON.parseObject(str,HashMap.class);
		map.put("ota_path",hashMap);
	}
	/**
	 * 新的固件升级通知
	 * @param hub_addr 集中器地址
	 * @param version 版本
	 * @param size 大小
	 */
	public void ota_notify(String hub_addr,String version,long size){
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(hub_addr);
		arrayList.add(version);
		arrayList.add(size);
		JsonRpcS jsonRpcS = new JsonRpcS("ota_notify",arrayList);
		String json = JSON.toJSONString(jsonRpcS);
		String str = HttpReq.httpRequest(url,"POST",json);
		HashMap<String, Object> hashMap = JSON.parseObject(str,HashMap.class);
		map.put("ota_notify",hashMap);
		//return hashMap.get("result").toString();		
	}
	/**
	 * 提取指定集中器的冻结量数据
	 * @param hub_addr 集中器地址
	 */
	public String pickup_meter_freezing_data(String hub_addr){
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(hub_addr);
		JsonRpcS jsonRpcS = new JsonRpcS("pickup_meter_freezing_data",arrayList);
		String json = JSON.toJSONString(jsonRpcS);
		String str = HttpReq.httpRequest(url,"POST",json);
		HashMap<String, Object> hashMap = JSON.parseObject(str,HashMap.class);
		map.put("pickup_meter_freezing_data",hashMap);
		return hashMap.get("result").toString();		
	}
	/**
	 * 设置集中器参数
	 * @param hub_addr
	 * @param config
	 * @return
	 */
	public String setup_hub_config(String hub_addr,ArrayList<Object> config){
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(hub_addr);
		arrayList.add(config);
		JsonRpcS jsonRpcS = new JsonRpcS("setup_hub_config",arrayList);
		String json = JSON.toJSONString(jsonRpcS);
		String str = HttpReq.httpRequest(url,"POST",json);
		HashMap<String, Object> hashMap = JSON.parseObject(str,HashMap.class);
		map.put("pickup_meter_freezing_data",hashMap);
		return hashMap.get("result").toString();
	}
	/**
	 * 提取集中器参数
	 * @param hub_addr
	 * @return
	 */
	public String pickup_hub_config(String hub_addr){
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add(hub_addr);
		JsonRpcS jsonRpcS = new JsonRpcS("setup_hub_config",arrayList);
		String json = JSON.toJSONString(jsonRpcS);
		String str = HttpReq.httpRequest(url,"POST",json);
		HashMap<String, Object> hashMap = JSON.parseObject(str,HashMap.class);
		map.put("pickup_meter_freezing_data",hashMap);
		return hashMap.get("result").toString();
	}
}
