package com.web;



import java.io.IOException;
import java.util.HashMap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rpc.JSONRPC;
import com.service.HubService;
import com.util.HttpReq;
/**
 * 集中器Controller层
 * @author vip
 *
 */
@Controller
@RequestMapping("/Hub")
@JsonIgnoreProperties(ignoreUnknown = true)
public class HubController {
	@Autowired
	private HubService hubService;//调用集中器Service层接口
	/**
	 * 查询所有集中器信息
	 * @return
	 * @throws Throwable 
	 * @throws IOException 
	 */
	@RequestMapping(value="/selectHub",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String selectHub(HttpServletRequest req,HttpServletResponse res,@RequestBody String data) throws Throwable{
/*		JSONRPC rpc = new JSONRPC();
		System.out.println(rpc.pickup_meter_freezing_data("0403020108111774"));*/
		return hubService.selectHub(req,res,data);
	}
	/**
	 * 添加集中器信息
	 * @param hub
	 * @return 返回集中器ID
	 */
	@RequestMapping(value="/insertHub",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String insertHub(HttpServletResponse res,HttpServletRequest req,@RequestBody String data){
		return hubService.insertHub(req,res,data);
	}
	/**
	 * 删除集中器信息
	 * @param data
	 * @param req
	 * @param res
	 * @return 返回是否成功
	 */
	@RequestMapping(value="/deleteHub",produces="application/json; charset=utf-8")
	@ResponseBody
	public String deleteHub(@RequestBody String data,HttpServletRequest req,HttpServletResponse res){
		return hubService.deleteHub(req, res, data);
	}
	/**
	 * 更新集中器信息
	 * @param data
	 * @param req
	 * @param res
	 * @return 返回更新后的集中器信息
	 */
	@RequestMapping(value="/updateHub",produces="application/json; charset=utf-8")
	@ResponseBody
	public String updateHub(@RequestBody String data,HttpServletRequest req,HttpServletResponse res){
		return hubService.updateHub(req, res, data);
	}
	/**
	 * 通过ID查询集中器信息
	 * @param json
	 * @param req
	 * @param res
	 * @return
	 */
	@RequestMapping(value="/queryHub",produces="application/json; charset=utf-8")
	@ResponseBody
	public String queryHub(@RequestBody String json,HttpServletRequest req,HttpServletResponse res){
		//System.out.println(json+"222222");
		return hubService.queryHub(req, res, json);
	}
	/**
	 * 查询所有客户名称
	 * @return
	 */
	@RequestMapping(value="/queryclient",produces="application/json; charset=utf-8")
	@ResponseBody
	public String queryHub(){ 
		return hubService.queryclient();
	}
	/**
	 * 查询所有客户信息
	 * @return
	 */
	@RequestMapping(value="/selectclient",produces="application/json; charset=utf-8")
	@ResponseBody
	public String selectclient(@RequestBody String data){ 

		return hubService.selectclient(data);
	}
	/**
	 * 添加客户信息
	 * @return
	 */
	@RequestMapping(value="/insertclient",produces="application/json; charset=utf-8")
	@ResponseBody
	public String insertclient(@RequestBody String data){ 
		return hubService.insertclient(data);
	}
	/**
	 * 定位小区信息,返回JSON数据
	 * @return
	 */
	@RequestMapping(value="/selectPlot",produces="application/json; charset=utf-8")
	@ResponseBody
	public String selectPlot(@RequestBody String data){
		@SuppressWarnings("unchecked")
		HashMap<String,Object> hashMap= JSON.parseObject(data,HashMap.class);	
		String json= HttpReq.httpRequest("http://api.cellocation.com:81/cell/?mcc="+hashMap.get("mcc")+"&mnc="+hashMap.get("mnc")+"&lac="+hashMap.get("lac")+"&ci="+hashMap.get("ci")+"&output=json","GET",null);
		return JSON.toJSONString(json);
	}
}
