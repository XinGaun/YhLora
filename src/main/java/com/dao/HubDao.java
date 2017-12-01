package com.dao;

import java.util.ArrayList;
import java.util.HashMap;




/**
 * 集中器Dao层接口
 * @author vip
 *
 */
public interface HubDao {
	/**
	 * 查询所有集中器信息
	 * @return 返回结果集
	 */
	public ArrayList<HashMap<String,Object>> selectHub(HashMap<String,Object> hashMap);
	/**
	 * 添加集中器信息
	 * @return 返回自增主键
	 */
	public int insertHub(HashMap<String,Object> hashMap);
	/**
	 * 添加集中器详情信息
	 */
	public int insertAll(HashMap<String,Object> hashMap);
	/**
	 * 通过集中器ID删除集中器信息
	 * @return 
	 */
	public int deleteHub(HashMap<String,Object> hashMap);
	/**
	 * 更新集中器信息
	 * @param hub
	 * @return
	 */
	public int updateHub(HashMap<String,Object> hashMap);
	/**
	 * 通过ID查找一个集中器信息
	 * @return 返回集中器信息
	 */
	public ArrayList<HashMap<String,Object>> queryHub(HashMap<String,Object> map);
	/**
	 * 查询总有多少条数据
	 */
	public int countHub(HashMap<String,Object> hashMap);
	/**
	 * 所有集中器总数
	 */
	public int totalHub();
	/**
	 * 查询所有客户名称
	 */
	public ArrayList<HashMap<String,Object>> queryclient();
	/**
	 * 查询需要更新的 固件文件地址的ID
	 */
	public ArrayList<HashMap<String,Object>> queryFirmwareID(HashMap<String,Object> hashMap);
	/**
	 * 查询所有客户信息
	 */
	public ArrayList<HashMap<String,Object>> selectclient(HashMap<String,Object> hashMap);
	/**
	 * 添加一个客户信息
	 */
	public int insertclient(HashMap<String,Object> hashMap);
	/**
	 * 查询客户总条数(筛选)
	 */
	public int queryCountClient(HashMap<String,Object> hashMap);
	/**
	 * 查询客户总数
	 */
	public int selectCountClient();
	/**
	 * 查询集中器地址是否唯一
	 */
	public int selectHubAddr(HashMap<String,Object> hashMap);
}
