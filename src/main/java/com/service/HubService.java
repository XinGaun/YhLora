package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * 集中器Hub Serice层接口
 * @author vip
 *
 */
public interface HubService {
	/**
	 * 查询所有集中器信息接口
	 * @return 返回JSON数据
	 */
	public String selectHub(HttpServletRequest req,HttpServletResponse res,String data);
	/**
	 * 添加集中器信息
	 * @return 返回自增主键ID
	 */
	public String insertHub(HttpServletRequest req,HttpServletResponse res,String callbackparam);
	/**
	 * 删除集中器信息
	 */
	public String deleteHub(HttpServletRequest req,HttpServletResponse res,String json);
	/**
	 * 更新集中器信息
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回更新后的信息
	 */
	public String updateHub(HttpServletRequest req,HttpServletResponse res,String json);
	/**
	 * 通过ID查询集中器信息
	 * @param req
	 * @param res
	 * @param json
	 * @return
	 */
	public String queryHub(HttpServletRequest req,HttpServletResponse res,String json);
	/**
	 * 查询所有客户名称
	 */
	public String queryclient();
	/**
	 * 查询所有 客户信息
	 */
	public String selectclient(String data);
	/**
	 * 添加客户信息
	 */
	public String insertclient(String data);
}
