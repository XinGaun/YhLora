package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * 历史详情Service层接口
 * @author vip
 *
 */
public interface HistoryService {
	/**
	 * 查询所有历史详情
	 * @param req
	 * @param res
	 * @return 返回JSON数据
	 */
	public String selectHistory(HttpServletRequest req,HttpServletResponse res,String data);
	/**
	 * 添加历史详情
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回主键ID
	 */
	public String insertHistory(HttpServletRequest req,HttpServletResponse res,String json);
	/**
	 * 通过历史详情ID删除历史详情
	 * @param req
	 * @param res
	 * @param json
	 * @return
	 */
	public String deteleHistory(HttpServletRequest req,HttpServletResponse res,String json);
	/**
	 * 根据历史详情ID更新历史详情
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回更新结果
	 */
	public String updateHistory(HttpServletRequest req,HttpServletResponse res,String json);
	/**
	 * 根据历史详情ID查询历史详情
	 * @param req
	 * @param res
	 * @param json
	 * @return
	 */
	public String queryHistory(HttpServletRequest req,HttpServletResponse res,String json);
}
