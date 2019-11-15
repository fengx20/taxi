package com.wzxy.aroundtaxi.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.wzxy.aroundtaxi.mapper.ManagerMapper;
import com.wzxy.aroundtaxi.pojo.Manager;
import com.wzxy.aroundtaxi.service.WebManagerService;

@Service
public class WebManagerServiceImpl implements WebManagerService {
	
	@Autowired
	ManagerMapper mm;
	
	
	/**
	 * 管理员登录
	 * @param Username
	 * @param Password
	 * @return
	 */
	@Override
	public boolean login(String Username,String Password) {
		boolean result = mm.select_web(Username, Password);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 添加管理员
	 * @param ma
	 * @return
	 */
	@Override
	public int addMa(String Username,String Password,String Phonenum) {
		Manager ma = new Manager();		
		ma.setUsername(Username);
		ma.setPassword(Password);
		ma.setPhonenum(Phonenum);
		int result = mm.add_web(ma);
		return result;
	}
	
	/**
	 * 修改管理员
	 * @param Username
	 * @param Password
	 * @return
	 */
	@Override
	public int updateMa(String Username,String Password) {
		int result = mm.update_web(Username, Password);
		return result;
	}
	
	/**
	 * 删除管理员
	 * @param Username
	 * @return
	 */
	@Override
	public int deleteMa(String Username) {
		int result = mm.delete_web(Username);
		return result;
	}
	
	/**
	 * 管理员列表
	 * @return
	 */
	@Override
	public String list() {
		List<Manager> list = mm.list_web();
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;
	}
	
	/**
	 * 查询单个
	 * @param Username
	 * @return
	 */
	@Override
	public String selectbyusername(String Username) {
		List<Manager> list = mm.listbyuser_web(Username);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json;
	}

}
