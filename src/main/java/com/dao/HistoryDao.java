package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 历史详情Dao层接口
 * @author vip
 *
 */
public interface HistoryDao {
	/**
	 * 查询所有历史详情
	 * @return 返回结果集
	 */
	public ArrayList<HashMap<String,Object>> selectHistory(HashMap<String,Object> hashMap);
	/**
	 * 添加历史详情
	 * @param hashMap
	 * @return 返回添加结果
	 */ 
	public int insertHistory(HashMap<String,Object> hashMap);
	/**
	 * 删除历史详情
	 * @param hashMap
	 * @return 返回删除结果
	 */
	public int deteleHistory(HashMap<String,Object> hashMap);
	/**
	 * 更新历史详情
	 * @param hashMap
	 * @return 返回更新结果
	 */
	public int updateHistory(HashMap<String,Object> hashMap);
	/**
	 * 通过ID查询历史详情
	 */
	public ArrayList<HashMap<String,Object>> queryHistory(HashMap<String,Object> hashMap);
	/**
	 * 查询历史信息总条数
	 * @param hashMap
	 * @return
	 */
	public int countHistory(HashMap<String,Object> hashMap);

}
