package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.HistoryDao;
import com.service.HistoryService;
import com.util.Count;
import com.util.Page;
import com.util.ReturnResponseJson;
import com.util.TimeStringHub;
/**
 * 历史详情Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class HistoryServiceImpl implements HistoryService {
	@Autowired
	private HistoryDao historyDao;//调用固件管理Dao层接口
	ReturnResponseJson responseJson =new ReturnResponseJson();
	/**
	 * 查询所有历史详情
	 * @return 返回JSON数据
	 */
	@Override
	public String selectHistory(HttpServletRequest req, HttpServletResponse res,String data) {
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		int count = historyDao.countHistory(hashMap);
		ArrayList<HashMap<String,Object>> list =historyDao.selectHistory(hashMap);
		list= TimeStringHub.TimeStringHub(list);
		list = Count.count(list, count, hashMap);
		String json = JSON.toJSONString(list);
		//return responseJson.returnJson(200,"success",list);
		return JSON.toJSONString(json);	
	}
	/**
	 * 添加历史详情信息,返回主键ID
	 */
	@Override
	public String insertHistory(HttpServletRequest req,
			HttpServletResponse res, String json) {
		HashMap<String,Object> hashmap = JSON.parseObject(json,HashMap.class);
		if(!hashmap.isEmpty()&&hashmap.get("addr")!=null&&!hashmap.get("addr").equals("")){
			hashmap.put("id",0);
			int temp = historyDao.insertHistory(hashmap);
			if(temp>0){
				//return responseJson.returnJson(200,"success",hashmap);
				return JSON.toJSONString(hashmap);
			}else{
				//return responseJson.returnJson(403,"Not InsertHistory!",null);
				return JSON.toJSONString("Not InsertHistory!");
			}
		}else{
			//return responseJson.returnJson(400,"Not InsertHistory!",null);
			return JSON.toJSONString("Not InsertHistory!");
		}
		
	}
	/**
	 * 通过历史详情ID删除历史详情
	 * @return 返回删除结果
	 */
	@Override
	public String deteleHistory(HttpServletRequest req,
			HttpServletResponse res, String json) {
		HashMap<String,Object> hashmap = JSON.parseObject(json,HashMap.class);
		Integer _id = Integer.parseInt(hashmap.get("id").toString());
		if(_id!=null&&_id>0){
			int temp = historyDao.deteleHistory(hashmap);
			if(temp>0){
				//return responseJson.returnJson(200,"success",null);
				return JSON.toJSONString("Success deteleHistory!");
			}else{
				//return responseJson.returnJson(403,"Not deteleHistory!",null);
				return JSON.toJSONString("Not deteleHistory!");
			}
		}else{
			//return responseJson.returnJson(400,"Not deteleHistory!",null);
			return JSON.toJSONString("Not deteleHistory!");
		}
	}
	/**
	 *	通过历史详情ID更新历史详情
	 * @return 返回更新结果
	 */
	@Override
	public String updateHistory(HttpServletRequest req,
			HttpServletResponse res, String json) {
		HashMap<String,Object> hashmap = JSON.parseObject(json,HashMap.class);
		Integer _id = Integer.parseInt(hashmap.get("id").toString());
		if(_id!=null&&_id>0){
			int temp = historyDao.updateHistory(hashmap);
			if(temp>0){
				//return responseJson.returnJson(200,"success",hashmap);
				return JSON.toJSONString(hashmap);
			}else{
				//return responseJson.returnJson(403,"Not UpdateHistory!",null);
				return JSON.toJSONString("Not! UpdateHistory!");
			}
		}else{
			//return responseJson.returnJson(400,"Not UpdateHistory!",null);
			return JSON.toJSONString("(Not! UpdateHistory!)");
		}
	}
	/**
	 * 根据历史详情ID查询历史详情
	 */
	@Override
	public String queryHistory(HttpServletRequest req, HttpServletResponse res,
			String json) {
		HashMap<String,Object> hashmap = JSON.parseObject(json,HashMap.class);
		Integer _id = Integer.parseInt(hashmap.get("id").toString());
		if(_id!=null&&_id>0){
			ArrayList<HashMap<String,Object>> list = historyDao.queryHistory(hashmap);
			if(list!=null&&list.size()>0){
				//return responseJson.returnJson(200,"succrss",list);
				return JSON.toJSONString(list);
			}else{
				//return responseJson.returnJson(403,"Not QueryHistory!",null);
				return JSON.toJSONString("Not QueryHistory!");
			}
		}else{
			//return responseJson.returnJson(400,"Not QueryHistory!",null);
			return JSON.toJSONString("Not QueryHistory!");
		}
	}

}
