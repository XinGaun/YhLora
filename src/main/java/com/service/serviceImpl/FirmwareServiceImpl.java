package com.service.serviceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.dao.FirmwareDao;
import com.dao.HubDao;
import com.rpc.JSONRPC;
import com.service.FirmwareService;
import com.util.Count;
import com.util.Page;
import com.util.ReturnResponseJson;
/**
 * 固件Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class FirmwareServiceImpl implements FirmwareService{
	/**
	 * 调用HubDao层接口
	 */
	@Autowired
	private HubDao hubDao;
	@Autowired
	private FirmwareDao firmwareDao;//调用固件Dao层接口
	ReturnResponseJson responseJson =new ReturnResponseJson();
	/**
	 * 查询固件所有信息
	 * 返回JSON
	 */
	@Override
	public String selectFirmware(HttpServletRequest req,HttpServletResponse res,String data) {
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list =firmwareDao.selectFirmware(hashMap);	
		int count = firmwareDao.countFirmware(hashMap);
		list = Count.count(list, count, hashMap);
		String json = JSON.toJSONString(list);
		//return responseJson.returnJson(200,"success",list);
		return  JSON.toJSONString(json);
	}
	/**
	 * 添加固件信息
	 */
	@Override
	public String insertFirmware(HttpServletRequest req,
			HttpServletResponse res, String json) {
		HashMap<String,Object> hashmap = JSON.parseObject(json,HashMap.class);
		if(!hashmap.isEmpty()&&hashmap.get("hub")!=null&&!hashmap.get("hub").equals("")){
			hashmap.put("id",0);
			int temp = firmwareDao.insertFirmware(hashmap);
			if(temp>0){
				//return responseJson.returnJson(200,"success",hashmap);
				return JSON.toJSONString(hashmap);
			}else{
				//return responseJson.returnJson(403,"Not InsertFirmware!",null);
				return JSON.toJSONString("Not InsertFirmware!");
			}
		}else{
			//return responseJson.returnJson(400,"Not InsertFirmware!",null);
			return JSON.toJSONString("Not InsertFirmware!");
		}	
	}
	/**
	 * 通过ID删除固件
	 */
	@Override
	public String deteleFirmware(HttpServletRequest req,
			HttpServletResponse res, String json) {
		HashMap<String,Object> hashmap = JSON.parseObject(json,HashMap.class);
		Integer _id = Integer.parseInt(hashmap.get("id").toString());
		if(_id!=null&&_id>0){
			int temp = firmwareDao.deteleFirmware(hashmap);
			if(temp>0){
				//return responseJson.returnJson(200,"success",null);
				return JSON.toJSONString("Success deteleFirmware!");
			}else{
				//return responseJson.returnJson(403,"Not deteleFirmware!",null);
				return JSON.toJSONString("Not deteleFirmware!");
			}
		}else{
			//return responseJson.returnJson(400,"Not deteleFirmware!",null);
			return JSON.toJSONString("Not deteleFirmware!");
		}
	}
	/**
	 * 根据ID更新固件信息
	 */
	@Override
	public String updateFirmware(HttpServletRequest req,
			HttpServletResponse res, String json) {
		HashMap<String,Object> hashmap = JSON.parseObject(json,HashMap.class);
		Integer _id = Integer.parseInt(hashmap.get("id").toString());
		if(_id!=null&&_id>0){
			int temp = firmwareDao.updateFirmware(hashmap);
			if(temp>0){
				//return responseJson.returnJson(200,"success",hashmap);
				return JSON.toJSONString(hashmap);
			}else{
				//return responseJson.returnJson(403,"Not UpdateFirmware!",null);
				return JSON.toJSONString("Not UpdateFirmware!");
			}
		}else{
			//return responseJson.returnJson(400,"Not UpdateFirmware!",null);
			return JSON.toJSONString("Not UpdateFirmware!");
		}
	}
	/**
	 * 根据ID查询固件信息
	 * 返回JSON
	 */
	@Override
	public String queryFirmware(HttpServletRequest req,
			HttpServletResponse res, String json) {
		HashMap<String,Object> hashmap = JSON.parseObject(json,HashMap.class);
		Integer _id = Integer.parseInt(hashmap.get("id").toString());
		if(_id!=null&&_id>0){
			ArrayList<HashMap<String,Object>> list = firmwareDao.queryFirmware(hashmap);
			if(list!=null&&list.size()>0){
				//return responseJson.returnJson(200,"success",list);
				return JSON.toJSONString(list);
			}else{
				//return responseJson.returnJson(403,"Not QueryFirmware!",null);
				return JSON.toJSONString("Not QueryFirmware!");
			}
		}else{
			//return responseJson.returnJson(400,"Not QueryFirmware!",null);
			return JSON.toJSONString("Not QueryFirmware!");
		}
	}
	/**
	 * 固件文件上传
	 */
	@Override
	public String ExcelFirmware(HttpServletRequest req,HttpServletResponse res,MultipartFile ExcelFirmware,String client,String addr) {
		HashMap<String,Object> JSONmap=new HashMap<String, Object>();
		JSONmap.put("client",req.getParameter("client"));
		System.out.println(req.getParameter("client"));
		System.out.println(req.getParameter("addr"));
		System.out.println(req.getParameter("version"));
		
		if(req.getParameter("addr")!=null&&req.getParameter("addr")!=""){
			JSONmap.put("addr",req.getParameter("addr"));
		}
		ArrayList<HashMap<String,Object>> listID = hubDao.queryFirmwareID(JSONmap);
		//得到上传文件的保存目录
		String savePath = req.getServletContext().getRealPath("/upload/");
		//String savePath = "/var/lib/data/hds/ota";
		int projectFileFlog = -1;
		String FilePath = ExcelFirmware.getOriginalFilename();//获得文件名称
		try {		
		if(FilePath.equals("")||FilePath==null){
			//没有文件上传
			projectFileFlog = 1;
		}else{
			long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
			FilePath = savePath+"//"+req.getParameter("version")+"-"+currentTimeMillis+FilePath;//获得服务器的相对路径
			ExcelFirmware.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("path", FilePath);
			for(int i=0;i<listID.size();i++){
				JSONmap.put("size",Integer.parseInt(ExcelFirmware.getSize()+""));
				JSONmap.put("id", listID.get(i).get("id"));
				JSONmap.put("path", FilePath);
				firmwareDao.updateFirmwarePath(JSONmap);//保存文件路径								
			}
			/*JSONmap.put("size",Integer.parseInt(ExcelFirmware.getSize()+""));
			JSONmap.put("id",1);
			JSONmap.put("path", FilePath);
			firmwareDao.updateFirmwarePath(JSONmap);//保存文件路径*/
			Integer size =Integer.parseInt(ExcelFirmware.getSize()+"");
			JSONRPC jsonrpc = new JSONRPC();
			jsonrpc.ota_notify(JSONmap.get("addr").toString(),req.getParameter("version"),size);
		}
		}catch (Exception e) {
			e.printStackTrace();
			//return responseJson.returnJson(403,"Not upload!",null);
			return JSON.toJSONString("error");
		}
		if(projectFileFlog!=1){
			//return responseJson.returnJson(200,"success",null);
			return JSON.toJSONString("ok");
		}else{
			//return responseJson.returnJson(400,"Not upload!",null);
			return JSON.toJSONString("error");
		}	
		
	}
	
}
