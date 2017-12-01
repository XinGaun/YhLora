package com.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.service.HistoryService;
/**
 * 历史详情Controller层
 * @author vip
 *
 */
@RequestMapping("/History")
@Controller
public class HistoryController {
	@Autowired
	private HistoryService historyService;//调用固件管理Service层接口
	/**
	 * 查询所有历史详情信息
	 * @param req
	 * @param res
	 * @return 返回JSON数据
	 */
	@RequestMapping(value="/selectHistory",produces="application/json;charset=utf-8")
	@ResponseBody
	public String selectHistory(HttpServletRequest req,HttpServletResponse res,@RequestBody String data){
		//System.out.println(data);
		return historyService.selectHistory(req, res,data);
	}
	/**
	 * 添加一个历史详情
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回JSON数据
	 */
	@RequestMapping(value="/insertHistory",produces="application/json;charset=utf-8")
	@ResponseBody
	public String insertHistory(HttpServletRequest req,HttpServletResponse res,@RequestBody String callbackparam){
		return historyService.insertHistory(req, res, callbackparam);
	}
	/**
	 * 通过历史详情ID删除一个历史详情
	 * @param req
	 * @param res
	 * @param json
	 * @return 返回删除结果
	 */
	@RequestMapping(value="/deteleHistory",produces="application/json;charset=utf-8")
	@ResponseBody
	public String deteleHistory(HttpServletRequest req,HttpServletResponse res,@RequestBody String callbackparam){
		return historyService.deteleHistory(req, res, callbackparam);
	}
	/**
	 * 通过固件ID更新历史详情
	 * @param req
	 * @param res
	 * @param callbackparam
	 * @return 返回更新后的数据
	 */
	@RequestMapping(value="/updateHistory",produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateHistory(HttpServletRequest req,HttpServletResponse res,@RequestBody String callbackparam){
		return historyService.updateHistory(req, res,callbackparam);
	}
	/**
	 * 通过历史详情ID查询历史详情
	 * @param req
	 * @param res
	 * @param callbackparam
	 * @return 返回JSON数据
	 */
	@RequestMapping(value="/queryHistory",produces="application/json;charset=utf-8")
	@ResponseBody
	public String queryHistory(HttpServletRequest req,HttpServletResponse res,@RequestBody String callbackparam){
		return historyService.queryHistory(req, res, callbackparam);
	}
}
