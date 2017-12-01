package com.service.serviceImpl;





import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.HubDao;
import com.service.HubService;
import com.util.Count;
import com.util.INTERVALString;
import com.util.Page;
import com.util.ReturnResponseJson;
import com.util.TimeStringHub;
/**
 * 集中器Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class HubServiceImpl implements HubService {

	/**
	 * 调用HubDao层接口
	 */
	@Autowired
	private HubDao hubDao;
	ReturnResponseJson responseJson =new ReturnResponseJson();
	/**
	 * 查询所有集中器信息
	 */
	
	public String selectHub(HttpServletRequest req,HttpServletResponse res,String data) {
		res.setContentType("text/plain;charset=utf-8");	
		HashMap<String, Object> hashMap = JSON.parseObject(data,HashMap.class);
		if(hashMap!=null&&hashMap.get("sort")==null||hashMap.get("sort")==""){
			hashMap.put("sort",0);
		}
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = hubDao.selectHub(hashMap);
		list= TimeStringHub.TimeStringHub(list);
		for(int i=0;i<list.size();i++){
			if(list.get(i).get("kp_interval")!=null&&list.get(i).get("kp_interval")!=""){
			String kp_interval= INTERVALString.INTERVALString(list.get(i).get("kp_interval").toString());
			list.get(i).put("kp_interval", kp_interval);
			}
		}
		int total = hubDao.totalHub();
		hashMap.put("total", total);
		int count = hubDao.countHub(hashMap);
/*		Hub hubout = new Hub();
		hashMap.put("Hub",hubout);*/
		list = Count.count(list, count, hashMap);
		String json = JSON.toJSONString(list);	
		//return responseJson.returnJson(200,"success",list);
		return JSON.toJSONString(json);
	}
	/**
	 * 添加集中器信息,返回主键ID
	 */
	@Transactional
	public String insertHub(HttpServletRequest req,HttpServletResponse res,String data) {
		HashMap<String, Object> hashMap = JSON.parseObject(data,HashMap.class);
		int weyo = hubDao.selectHubAddr(hashMap);
		System.out.println(weyo);
		if(hashMap!=null&&hashMap.get("addr")!=null&&weyo==0){		
			hashMap.put("id",0);	
			int id = hubDao.insertHub(hashMap);
			if(id>0){		
				res.setContentType("text/plain;charset=utf-8");
				hashMap.put("stuts_ss",200);
				//return responseJson.returnJson(200,"success",hashMap);
				return JSON.toJSONString(hashMap);
			}else{				
				hashMap.put("stuts_ss",400);
				//return responseJson.returnJson(403,"Not insertHub!",hashMap);
				return JSON.toJSONString(hashMap);
			}
		}else{
			hashMap.put("stuts_ss",400);
			//return responseJson.returnJson(400,"Not insertHub!",hashMap);
			return JSON.toJSONString(hashMap);
		}
	}
	/**
	 * 删除集中器信息
	 */
	@Override
	public String deleteHub(HttpServletRequest req, HttpServletResponse res,
			String json) {
		HashMap<String,Object> hashMap = JSON.parseObject(json,HashMap.class);
		if(hashMap!=null&&hashMap.get("id")!=null){
			int temp = hubDao.deleteHub(hashMap);
			if(temp>0){
				String str = JSON.toJSONString("Success Delete!");
				//return responseJson.returnJson(200,"success",null);
				return str;	
			}else{
				String str =JSON.toJSONString("Not DeleteHub!");
				//return responseJson.returnJson(403,"success",null);
				return str;
			}
		}else{
			String str = JSON.toJSONString("Not Delete!");
			//return responseJson.returnJson(403,"Not DeleteHub!",null);
			return str;
		}
	}
	/**
	 * 更新集中器信息
	 * @return 返回更新后的数据
	 */
	@Override
	public String updateHub(HttpServletRequest req, HttpServletResponse res,
			String json) {
		HashMap<String,Object> hashMap = JSON.parseObject(json,HashMap.class);
		if(hashMap!=null&&hashMap.get("id")!=null){
			int temp = hubDao.updateHub(hashMap);
			if(temp>0){
				//return responseJson.returnJson(200,"success",hashMap);
				return JSON.toJSONString(hashMap);
			}else{
				//return responseJson.returnJson(403,"Not updateHub!",null);
				return JSON.toJSONString("Not update!");
			}
		}else{
			//return responseJson.returnJson(400,"Not updateHub!",null);
			return JSON.toJSONString("Not update!");
		}
	}
	/**
	 * 通过ID查询集中器信息
	 */
	@Override
	public String queryHub(HttpServletRequest req, HttpServletResponse res,
			String json) {
		HashMap<String,Object> hashMap = JSON.parseObject(json,HashMap.class);
		if(hashMap!=null&&hashMap.get("id")!=null){
			ArrayList<HashMap<String,Object>> list = hubDao.queryHub(hashMap);
			TimeStringHub.TimeStringHub(list);
			if(list!=null&&list.size()>0){
				list.add(hashMap);
				if(list.get(0).get("kp_interval")!=null){
					String kp_interval = INTERVALString.INTERVALString(list.get(0).get("kp_interval").toString());
					list.get(0).put("kp_interval",kp_interval);
				}
				String data = JSON.toJSONString(list);
				//return responseJson.returnJson(200,"Not selectHub!",list);
				return JSON.toJSONString(data);
			}else{
				//return responseJson.returnJson(403,"Not selectHub!",null);
				return JSON.toJSONString("Not select!");
			}	
		}else{
			//return responseJson.returnJson(400,"Not selectHub!",null);
			return JSON.toJSONString("Not select!");
		}
	}
	/**
	 * 查询所有客户信息
	 */
	public String queryclient() {
		ArrayList<HashMap<String,Object>> list = hubDao.queryclient();	
		String json =JSON.toJSONString(list);
		return JSON.toJSONString(json);
	}
	/**
	 * 查询所有客户信息
	 */
	@Override
	public String selectclient(String data) {
		HashMap<String,Object> hashMap= JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = hubDao.selectclient(hashMap);
		int count = hubDao.queryCountClient(hashMap);
		int total =hubDao.selectCountClient();
		hashMap.put("total", total);
		list = Count.count(list, count, hashMap);
		String Strlist = JSON.toJSONString(list);
		//return responseJson.returnJson(200,"success",list);
		return JSON.toJSONString(Strlist);
	}
	/**
	 * 添加客户信息
	 */
	@Override
	public String insertclient(String data) {
		HashMap<String,Object> hashMap= JSON.parseObject(data,HashMap.class);	
		if(hashMap!=null&&hashMap.get("addr")!=null){
			hashMap.put("id",0);
			int temp= hubDao.insertclient(hashMap);
			if(temp>0){
				//return responseJson.returnJson(200,"success",hashMap);
				return JSON.toJSONString(hashMap);
			}else{
				//return responseJson.returnJson(403,"Not InsertClient!",null);
				return JSON.toJSONString("Not InsertClient!");
			}	
		}else{
			//return responseJson.returnJson(400,"Not InsertClient!",null);
			return JSON.toJSONString("Not InsertClient!");
		}
		
	}


}
