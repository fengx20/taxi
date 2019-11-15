package com.wzxy.aroundtaxi.mapper;

import java.util.List;

import com.wzxy.aroundtaxi.pojo.Manager;

public interface ManagerMapper {
	
	
	/**
	 * 查询（登录）
	 * @param Username
	 * @param Password
	 * @return
	 */
	public boolean select_web(String Username,String Password);
	
	/**
	 * 添加（web管理）
	 * @param ma
	 * @return
	 */
	public int add_web(Manager ma);
	
	/**
	 * 删除（web管理）
	 * @param Username
	 * @return
	 */
	public int delete_web(String Username);
	
	/**
	 * 更新（web管理）
	 * @param Username
	 * @return
	 */
	public int update_web(String Username,String Password);
	
	/**
	 * 查询所有（web管理）
	 * @return
	 */
	public List<Manager> list_web();
	
	/**
	 * 查询 by username （web管理）
	 * @param Username
	 * @return
	 */
	public List<Manager> listbyuser_web(String Username);

}
