package com.wzxy.aroundtaxi.service;

import java.util.List;

import com.wzxy.aroundtaxi.pojo.Passenger;

public interface WebPassengerService {
	
	/**
	 * 判断用户是否存在
	 */
	public boolean exist_user(String Phonenum);
	
	/**
	 * 添加
	 * @param pa
	 * @return
	 */
	public int addPa(String Phonenum,String Password,String Name,String Sex,String Birth);
	
	/**
	 * 修改
	 * @param Phonenum
	 * @param pa
	 * @return
	 */
	public int updatePa(String Phonenum,String Password,String Name,String Sex,String Birth);
	
	/**
	 * 删除
	 * @param Phonenum
	 * @return
	 */
	public int deletePa(String Phonenum);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Passenger> list();
	
	/**
	 * 查询单个
	 * @param Phonenum
	 * @return
	 */
	public List<Passenger> selectbyphonenum(String Phonenum);

}
