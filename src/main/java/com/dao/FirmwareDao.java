package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 固件Dao层接口
 * @author vip
 *
 */
public interface FirmwareDao {
	/**
	 * 查询所有固件
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> selectFirmware(HashMap<String,Object> hashMap);
	/**
	 * 添加固件信息
	 * @param hashMap
	 * @return 返回添加后的测试功能信息
	 */
	public int insertFirmware(HashMap<String,Object> hashMap);
	/**
	 * 根据ID删除固件
	 * @param hashMap
	 * @return 返回删除结果
	 */
	public int deteleFirmware(HashMap<String,Object> hashMap);
	/**
	 * 通过固件ID固件信息
	 * @param hashMap
	 * @return 返回修改结果
	 */
	public int updateFirmware(HashMap<String,Object> hashMap);
	/**
	 * 通过ID查询固件信息
	 * @param hashMap
	 * @return 返回结果集
	 */
	public ArrayList<HashMap<String,Object>> queryFirmware(HashMap<String,Object> hashMap);
	/**
	 * 查询固件信息总条数
	 * @param hashMap
	 * @return
	 */
	public int countFirmware(HashMap<String,Object> hashMap);
	/**
	 * 保存固件文件地址
	 */
	public int updateFirmwarePath(HashMap<String,Object> hashMap);
	
}
