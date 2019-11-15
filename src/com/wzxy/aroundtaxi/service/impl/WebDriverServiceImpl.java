package com.wzxy.aroundtaxi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzxy.aroundtaxi.mapper.CarMapper;
import com.wzxy.aroundtaxi.mapper.DrAddressMapper;
import com.wzxy.aroundtaxi.mapper.DriverMapper;
import com.wzxy.aroundtaxi.pojo.Car;
import com.wzxy.aroundtaxi.pojo.Driver;
import com.wzxy.aroundtaxi.service.WebDriverService;

@Service
public class WebDriverServiceImpl implements WebDriverService {
	
	@Autowired
	DriverMapper dm;
	@Autowired
	DrAddressMapper dam;
	@Autowired
	CarMapper cm;
	
	
	/**
	 * 审核司机
	 * @param Phonenum
	 * @return
	 */
	@Override
	public int checkdr(String Phonenum) {
		int result = dm.update_st(Phonenum);
		return result;
	}
	
	/**
	 * 停用司机
	 * @param Phonenum
	 * @return
	 */
	@Override
	public int stopdr(String Phonenum) {
		int result = dm.stop_st(Phonenum);
		return result;
	}
	
	/**
	 * 未审核司机列表
	 * @return
	 */
	@Override
	public List<Driver> driver_sh(){
		List<Driver> list = dm.select_sh();
		return list;
	}
	
	/**
	 * 正式司机列表
	 * @return
	 */
	@Override
	public List<Driver> driver_zs(){
		List<Driver> list = dm.list_web();
		return list;
	}
	
	/**
	 * 判断司机是否存在
	 */
	@Override
	public boolean exist_driver(String Phonenum) {
		boolean result = dm.selectph(Phonenum);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 添加
	 * @return
	 */
	@Override
	public int addDr(String Phonenum,String Jobnum,String Idnum,String Driverage,String Name,String Sex,String Birth) {
		int result = dm.add_web(Phonenum,Jobnum, Idnum,Driverage,Name, Sex, Birth);
		return result;
	}
	
	/**
	 * 判断司机地理位置是否已存在
	 * @param Phonenum
	 * @return
	 */
	@Override
	public boolean exist_dradd(String Phonenum) {
		boolean result = dam.selectph_dradd(Phonenum);
		return result;
	}
	
	/**
	 * 修改
	 * @return
	 */
	@Override
	public int updateDr(String Phonenum,String Jobnum,String Idnum,String Driverage,String Name,String Sex,String Birth) {
		int result = dm.update_web(Jobnum, Idnum,Driverage,Name, Sex, Birth,Phonenum);
		return result;
	}
	
	/**
	 * 删除
	 * @param Phonenum
	 * @return
	 */
	@Override
	public int deleteDr(String Phonenum) {
		int result = dm.delete_web(Phonenum);
		return result;
	}
	
	/**
	 * 查询所有正式
	 * @return
	 */
	@Override
	public List<Driver> list() {
		List<Driver> list = dm.list_web();
		return list;
	}
	
	/**
	 * 查询单个正式
	 * @param Phonenum
	 * @return
	 */
	@Override
	public List<Driver> selectbyphonenum(String Phonenum) {
		List<Driver> list = dm.listbyph_web(Phonenum);
		return list;
	}
	
	/**
	 * 司机车辆列表
	 * @return
	 */
	@Override
	public List<Car> list_web(){
		List<Car> list = cm.list_web();
		return list;
	}

}
