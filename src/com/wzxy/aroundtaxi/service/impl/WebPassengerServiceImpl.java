package com.wzxy.aroundtaxi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzxy.aroundtaxi.mapper.PassengerMapper;
import com.wzxy.aroundtaxi.pojo.Passenger;
import com.wzxy.aroundtaxi.service.WebPassengerService;

@Service
public class WebPassengerServiceImpl implements WebPassengerService {
	
	@Autowired
	PassengerMapper pm;
	
	/**
	 * 判断用户是否存在
	 */
	@Override
	public boolean exist_user(String Phonenum) {
		boolean result = pm.exist(Phonenum);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 添加
	 * @param pa
	 * @return
	 */
	@Override
	public int addPa(String Phonenum,String Password,String Name,String Sex,String Birth) {
		int result = pm.add_web(Phonenum,Password,Name,Sex,Birth);
		return result;
	}
	
	/**
	 * 修改
	 * @param Phonenum
	 * @param pa
	 * @return
	 */
	@Override
	public int updatePa(String Phonenum,String Password,String Name,String Sex,String Birth) {
		int result = pm.update_web(Password,Name,Sex,Birth,Phonenum);
		return result;
	}
	
	/**
	 * 删除
	 * @param Phonenum
	 * @return
	 */
	@Override
	public int deletePa(String Phonenum) {
		int result = pm.delete_web(Phonenum);
		return result;
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	@Override
	public List<Passenger> list(){
		List<Passenger> list = pm.list_web();
		return list;
	}
	
	/**
	 * 查询单个
	 * @param Phonenum
	 * @return
	 */
	@Override
	public List<Passenger> selectbyphonenum(String Phonenum){
		List<Passenger> list = pm.listbyph_web(Phonenum);
		return list;
	}

}
