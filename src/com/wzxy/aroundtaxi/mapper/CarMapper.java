package com.wzxy.aroundtaxi.mapper;

import java.util.List;
import java.util.Map;

import com.wzxy.aroundtaxi.pojo.Car;

public interface CarMapper {
	
	/**
	 * 添加（app）
	 * @param Carnum
	 * @param Phonenum
	 * @param Owner
	 * @param Cartype
	 * @param Carimg
	 * @return
	 */
	public int add(String Carnum,String Phonenum,String Owner,String Cartype,String Carimg);
	
	/**
	 * 查询（app）
	 * @param Phonenum
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map list(String Phonenum);
	
	/**
	 * 查询（app）
	 * @param Carnum
	 * @return
	 */
	public boolean selectcar(String Carnum);
	
	/**
	 * 查询（web）
	 * @param Phonenum
	 * @return
	 */
	public List<Car> list_web();

}
