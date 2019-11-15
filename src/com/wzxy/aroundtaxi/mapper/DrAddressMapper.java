package com.wzxy.aroundtaxi.mapper;

import java.util.List;

import com.wzxy.aroundtaxi.pojo.DrAddress;

public interface DrAddressMapper {
	
	/**
	 * 查询对比
	 * @param Phonenum
	 * @return
	 */
	public boolean selectph_dradd(String Phonenum);
	
	/**
	 * 添加
	 * @param DA
	 * @return
	 */
	public int add(String Phonenum,double Longitude,double Latitude,String Status);
	
	/**
	 * 更新
	 * @param Phonenum
	 * @param Longitude
	 * @param Latitude
	 */
	public int update_address(double Longitude,double Latitude,String Phonenum);
	
	/**
	 * 更新状态
	 * @param Phonenum
	 */
	public void update_start(String Phonenum);
	
	/**
	 * 更新状态
	 * @param Phonenum
	 */
	public void update_end(String Phonenum);
	
	/**
	 * 查询
	 * @param Longitude
	 * @param latitude
	 * @return
	 */
	public List<DrAddress> select_dr(double Longitude,double latitude);
	
	/**
	 * 查询司机地理位置
	 * @param Phonenum
	 * @return
	 */
	public List<DrAddress> select_dradd(String Phonenum);

}
