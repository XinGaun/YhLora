package com.util;


import com.alibaba.fastjson.JSON;
import com.entity.ResponseJson;

public class ReturnResponseJson {
	
	public String returnJson(int status,String message,Object Objdata){
		ResponseJson responseJson = new ResponseJson(); 	
		responseJson.setData(Objdata);
		responseJson.setMessage(message);
		responseJson.setStatus(status);
		return JSON.toJSONString(responseJson);
	}
}
