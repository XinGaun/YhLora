package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 固件Service层接口
 * @author vip
 *
 */
public interface FirmwareService {
	/**
	 * 查询所有固件信息
	 * @return 返回JSON数据
	 */
	public String selectFirmware(HttpServletRequest req,HttpServletResponse res,String data);
	/**
	 * 添加一个固件信息
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回添加结果
	 */
	public String insertFirmware(HttpServletRequest req,HttpServletResponse res,String json);
	/**
	 * 通过ID删除固件信息
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回删除结果
	 */
	public String deteleFirmware(HttpServletRequest req,HttpServletResponse res,String json);
	/**
	 * 通过ID更新固件信息
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回更新结果
	 */
	public String updateFirmware(HttpServletRequest req,HttpServletResponse res,String json);
	/**
	 * 通过ID查询固件信息
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回查询结果json
	 */
	public String queryFirmware(HttpServletRequest req,HttpServletResponse res,String json);
	/**
	 * 固件文件上传
	 * @param ExcelFirmware
	 * @return
	 */
	public String ExcelFirmware(HttpServletRequest req,HttpServletResponse res,@RequestParam("ExcelFirmware") MultipartFile ExcelFirmware,String client,String addr);
}
