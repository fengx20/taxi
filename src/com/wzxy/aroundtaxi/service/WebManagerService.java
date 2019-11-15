package com.wzxy.aroundtaxi.service;

public interface WebManagerService {
	
	
	
	/**
	 * 管理员登录
	 * @param Username
	 * @param Password
	 * @return
	 */
	public boolean login(String Username,String Password);
	
	/**
	 * 添加管理员
	 * @param ma
	 * @return
	 */
	public int addMa(String Username,String Password,String Phonenum);
	
	/**
	 * 修改管理员
	 * @param Username
	 * @param Password
	 * @return
	 */
	public int updateMa(String Username,String Password);
	
	/**
	 * 删除管理员
	 * @param Username
	 * @return
	 */
	public int deleteMa(String Username);
	
	/**
	 * 管理员列表
	 * @return
	 */
	public String list();
	
	/**
	 * 查询单个
	 * @param Username
	 * @return
	 */
	public String selectbyusername(String Username);

}
