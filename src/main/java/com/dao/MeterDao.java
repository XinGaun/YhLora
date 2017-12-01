package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 表具Dao层接口
 * @author vip
 *
 */
public interface MeterDao {
	/**
	 * 查询所有表具信息
	 * @return 返回信息集合LIST
	 */
	public ArrayList<HashMap<String,Object>> selectMeter(HashMap<String,Object> hashMap);
	/**
	 * 添加一个表具信息
	 * @param hashMap
	 * @return 返回表具自增ID
	 */
	public int insertMeter(HashMap<String,Object> hashMap);
	/**
	 * 通过ID删除一个表具信息
	 * @param hashMap
	 * @return 返回删除结果
	 */
	public int deteleMeter(HashMap<String,Object> hashMap);
	/**
	 * 通过表具ID更新表具信息
	 * @param hashMap
	 * @return 返回更新结果
	 */
	public int updateMeter(HashMap<String,Object> hashMap);
	/**
	 * 通过表具ID查询表具信息
	 */
	public ArrayList<HashMap<String,Object>> queryMeter(HashMap<String,Object> hashMap);
	/**
	 * 查询表具信息总条数
	 */
	public int countMeter(HashMap<String,Object> hashMap);
	/**
	 * total总条数
	 */
	public int totalMeter();
}
