package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.MeterDao;
import com.service.MeterService;
import com.util.Count;
import com.util.Page;
import com.util.ReturnResponseJson;
import com.util.TimeStringHub;
/**
 * 表具管理Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class MeterServiceImpl implements MeterService {
	@Autowired
	private MeterDao meterDao;//调用表具Dao层接口
	ReturnResponseJson responseJson = new ReturnResponseJson();
	/**
	 * 查询所有表具信息
	 */
	@Override
	public String selectMeter(HttpServletRequest req,HttpServletResponse res,String data) {
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		if(hashMap!=null&&hashMap.get("sort")==null||hashMap.get("sort")==""){
			hashMap.put("sort",0);
		}
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = meterDao.selectMeter(hashMap);
		list= TimeStringHub.TimeStringMeter(list);
		list = TimeStringHub.BitLOW(list);
		int count = meterDao.countMeter(hashMap);
		int total = meterDao.totalMeter();
		hashMap.put("total", total);
		list = Count.count(list,count, hashMap);
		String json = JSON.toJSONString(list);
		//return responseJson.returnJson(200,"success",list);
	
		return JSON.toJSONString(json);	
	}
	/**
	 * 添加一个表具信息
	 */
	@Override
	public String insertMeter(HttpServletRequest req, HttpServletResponse res,
			String json) {
		String callbackFunName =req.getParameter("callbackparam");//得到js函数名称
		HashMap<String,Object> hashmap = JSON.parseObject(json,HashMap.class);
		if(!hashmap.isEmpty()&&hashmap.get("sn")!=null&&!hashmap.get("sn").equals("")){
			hashmap.put("id",0);
			int temp = meterDao.insertMeter(hashmap);
			if(temp>0){
				//return responseJson.returnJson(200,"success",hashmap);
				return JSON.toJSONString(hashmap);
			}else{
				//return responseJson.returnJson(403,"error","Not InsertMeter!");
				String str = callbackFunName + "(Not InsertMeter!)";
				return JSON.toJSONString(str);
			}
		}else{
			//return responseJson.returnJson(400,"error","Not InsertMeter!");
			String str = callbackFunName + "(Not InsertMeter!)";
			return JSON.toJSONString(str);
		}
	}
	/**
	 * 根据表具ID删除表具信息
	 */
	@Override
	public String deteleMeter(HttpServletRequest req, HttpServletResponse res,
			String json) {
		HashMap<String,Object> hashmap = JSON.parseObject(json,HashMap.class);
		Integer _id = Integer.parseInt(hashmap.get("id").toString());
		if(_id!=null&&_id>0){
			int temp = meterDao.deteleMeter(hashmap);
			if(temp>0){
				//return responseJson.returnJson(200,"success",null);
				return JSON.toJSONString("Success DeteleMeter!");
			}else{
				//return responseJson.returnJson(403,"Not DeteleMeter!",null);
				return JSON.toJSONString("Not DeteleMeter!");
			}
		}else{
			//return responseJson.returnJson(400,"Not DeteleMeter!",null);
			return JSON.toJSONString("Not DeteleMeter!");
		}
	}
	/**
	 * 根据表具ID修改表具信息
	 */
	@Override
	public String updateMeter(HttpServletRequest req, HttpServletResponse res,
			String json) {
		HashMap<String,Object> hashmap = JSON.parseObject(json,HashMap.class);
		Integer _id = Integer.parseInt(hashmap.get("id").toString());
		if(_id!=null&&_id>0){
			int temp = meterDao.updateMeter(hashmap);
			if(temp>0){
				//return responseJson.returnJson(200,"success",hashmap);
				return JSON.toJSONString(hashmap);
			}else{
				//return responseJson.returnJson(403,"Not UpdateMeter!",null);
				return JSON.toJSONString("Not UpdateMeter!");
			}
		}else{
			//return responseJson.returnJson(400,"Not UpdateMeter!",null);
			return JSON.toJSONString("Not UpdateMeter!");
		}
	}
	/**
	 * 通过表具ID查询表具信息
	 */
	@Override
	public String queryMeter(HttpServletRequest req, HttpServletResponse res,
			String json) {
		HashMap<String,Object> hashmap = JSON.parseObject(json,HashMap.class);
		Integer _id = Integer.parseInt(hashmap.get("id").toString());
		if(_id!=null&&_id>0){
			ArrayList<HashMap<String,Object>> list = meterDao.queryMeter(hashmap);
			if(list!=null&&list.size()>0){
				//return responseJson.returnJson(200,"success",list);
				return JSON.toJSONString(list);
			}else{
				//return responseJson.returnJson(403,"Not QueryMeter!",null);
				return JSON.toJSONString("Not QueryMeter!");
			}
		}else{
			//return responseJson.returnJson(400,"Not QueryMeter!",null);
			return JSON.toJSONString("Not QueryMeter!");
		}
	}

}
