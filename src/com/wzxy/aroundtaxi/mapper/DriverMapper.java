package com.wzxy.aroundtaxi.mapper;

import java.util.List;

import com.wzxy.aroundtaxi.pojo.Driver;

public interface DriverMapper {
	
	/**
	 * 添加（app添加司机手机号）
	 * @param Phonenum
	 * @return
	 */
	public int adddrph(String Phonenum);
	
	/**
	 * 查询对比（app）
	 * @param Phonenum
	 * @return
	 */
	public boolean selectph(String Phonenum);
	
	/**
	 * 插入（app）
	 * @param Phonenum
	 * @param Password
	 * @param Jobnum
	 * @param Idnum
	 * @param Name
	 * @return
	 */
	public int update(String Jobnum,String Idnum,String Name,String Driverage,String Phonenum);
	
	/**
	 * 查询对比
	 * @param Phonenum
	 * @return
	 */
	public boolean select_result(String Phonenum);
	
	/**
	 * 查询对比
	 * @param Phonenum
	 * @return
	 */
	public boolean select_resultno(String Phonenum);
	
	/**
	 * 插入（app完善信息）
	 * @param Name
	 * @param Sex
	 * @param Birth
	 * @return
	 */
	public int updatefull(String Sex,String Birth,String Phonenum);
	
	/**
	 * 查询（app查询司机信息）
	 * @param Phonenum
	 * @return
	 */
	public List<Driver> list(String Phonenum);
	
	
	
	
	/**
	 * 通过状态（web）
	 * @param Phonenum
	 * @return
	 */
	public int update_st(String Phonenum);
	
	/**
	 * 停用状态
	 * @param Phonenum
	 * @return
	 */
	public int stop_st(String Phonenum);
	
	/**
	 * 查询审核
	 * @return
	 */
	public List<Driver> select_sh();
	
	/**
	 * 添加（web管理）
	 * @param dr
	 * @return
	 */
	public int add_web(String Phonenum,String Jobnum,String Idnum,String Driverage,String Name,String Sex,String Birth);
	
	/**
	 * 删除（web管理）
	 * @param Phonenum
	 * @return
	 */
	public int delete_web(String Phonenum);
	
	/**
	 * 更新（web管理）
	 * @param Phonenum
	 * @return
	 */
	public int update_web(String Jobnum,String Idnum,String Driverage,String Name,String Sex,String Birth,String Phonenum);
	
	/**
	 * 查询所有（web管理）
	 * @return
	 */
	public List<Driver> list_web();
	
	/**
	 * 查询 by phonenum （web管理）
	 * @param Phonenum
	 * @return
	 */
	public List<Driver> listbyph_web(String Phonenum);

}
