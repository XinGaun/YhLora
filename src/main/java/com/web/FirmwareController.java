package com.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.service.FirmwareService;

/**
 * 固件Controller层
 * @author vip
 *
 */
@RequestMapping("/Firmware")
@Controller
public class FirmwareController {
	@Autowired
	private FirmwareService firmwareService;//调用测试功能Service层接口
	/**
	 * 查询所有固件信息
	 * @param req
	 * @param res
	 * @return 返回JSON数据
	 */
	@RequestMapping(value="/selectFirmware",produces="application/json;charset=utf-8")
	@ResponseBody
	public String selectFirmware(HttpServletRequest req,HttpServletResponse res,@RequestBody String data){
		//System.out.println(data);
		return firmwareService.selectFirmware(req, res,data);
	}
	/**
	 * 添加固件信息
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回JSON数据
	 */
	@RequestMapping(value="/insertFirmware",produces="application/json;charset=utf-8")
	@ResponseBody
	public String insertFirmware(HttpServletRequest req,HttpServletResponse res,@RequestBody String json){
		return firmwareService.insertFirmware(req, res, json);
	}
	/**
	 * 通过固件ID删除固件
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回删除结果
	 */
	@RequestMapping(value="/deteleFirmware",produces="application/json;charset=utf-8")
	@ResponseBody
	public String deteleFirmware(HttpServletRequest req,HttpServletResponse res,@RequestBody String json){
		return firmwareService.deteleFirmware(req, res, json);
	}
	/**
	 * 通过固件ID更新固件
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回更新结果
	 */
	@RequestMapping(value="/updateFirmware",produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateFirmware(HttpServletRequest req,HttpServletResponse res,@RequestBody String json){
		return firmwareService.updateFirmware(req, res, json);
	}
	/**
	 * 通过固件ID查询固件
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回查询结果json
	 */
	@RequestMapping(value="/queryFirmware",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryFirmware(HttpServletRequest req,HttpServletResponse res,@RequestBody String json){
		return firmwareService.queryFirmware(req, res, json);
	}
	/**
	 * 上传Excel文档
	 * @return 
	 * @throws IOException 
	 */
	@RequestMapping(value="/ExcelFirmware",produces="application/json;charset=utf-8")
	@ResponseBody
	public String ExcelFirmware(HttpServletRequest req,HttpServletResponse res,@RequestParam("ExcelFirmware") MultipartFile ExcelFirmware,String client,String addr){	
		
		return firmwareService.ExcelFirmware(req,res,ExcelFirmware,client,addr);
        
	}
}
