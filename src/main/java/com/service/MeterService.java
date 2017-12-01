package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;

/**
 * 表具Service层接口
 * @author vip
 *
 */
public interface MeterService {
	/**
	 * 查询所有表具数据
	 * @return 返回JSON字符串
	 */
	public String selectMeter(HttpServletRequest req,HttpServletResponse res,String json);
	/**
	 * 添加一个表具信息
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回添加后的主键ID
	 */
	public String insertMeter(HttpServletRequest req,HttpServletResponse res,@RequestBody String json);
	/**
	 * 根据ID删除表具信息
	 * @param req
	 * @param res
	 * @param json
	 * @return
	 */
	public String deteleMeter(HttpServletRequest req,HttpServletResponse res,@RequestBody String json);
	/**
	 * 根据ID修改表具信息
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回修改后的表具信息
	 */
	public String updateMeter(HttpServletRequest req,HttpServletResponse res,@RequestBody String json);
	/**
	 * 根据ID查询表具信息
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回表具信息JSON
	 */
	public String queryMeter(HttpServletRequest req,HttpServletResponse res,@RequestBody String json);
}
