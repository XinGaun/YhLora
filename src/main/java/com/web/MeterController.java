package com.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rpc.JSONRPC;
import com.service.MeterService;
/**
 * 表具管理Controller层
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@RequestMapping("/Meter")
@Controller
public class MeterController {
	@Autowired
	private MeterService meterService;//调用表具管理Service层接口
	/**
	 * 查询所有表具信息
	 * @param req
	 * @param res
	 * @return 返回JSON数据
	 */
	@RequestMapping(value="/selectMeter",produces="application/json;charset=utf-8")
	@ResponseBody
	public String selectMeter(HttpServletRequest req,HttpServletResponse res,@RequestBody String json){
		HashMap<String, Object> hashMap = (HashMap<String, Object>) JSONRPC.map.get("ota_path");
		if(hashMap!=null&&null!=hashMap.get("result")){
			System.out.println(hashMap.get("result"));
		}
		return meterService.selectMeter(req, res,json);
	}
	/**
	 * 添加一个表具信息
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回添加后的表具信息JSON
	 */
	@RequestMapping(value="/insertMeter",produces="application/json;charset=utf-8")
	@ResponseBody
	public String insertMeter(HttpServletRequest req,HttpServletResponse res,@RequestBody String json){
		return meterService.insertMeter(req, res, json);
	}
	/**
	 * 根据表具ID删除表具信息
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回删除结果JSON
	 */
	@RequestMapping(value="/deteleMeter",produces="application/json;charset=utf-8")
	@ResponseBody
	public String deteleMeter(HttpServletRequest req,HttpServletResponse res,@RequestBody String json){
		return meterService.deteleMeter(req, res, json);
	}
	/**
	 * 根据表具ID更新表具信息
	 * @param req
	 * @param res
	 * @param json
	 * @return
	 */
	@RequestMapping(value="/updateMeter",produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateMeter(HttpServletRequest req,HttpServletResponse res,@RequestBody String json){
		return meterService.updateMeter(req, res, json);
	}
	/**
	 * 根据表具ID查询表具信息
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回JSON数据
	 */
	@RequestMapping(value="/queryMeter",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryMeter(HttpServletRequest req,HttpServletResponse res,@RequestBody String json){
		return meterService.queryMeter(req, res, json);
	}
}
