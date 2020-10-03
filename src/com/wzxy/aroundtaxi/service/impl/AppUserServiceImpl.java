package com.wzxy.aroundtaxi.service.impl;

import java.io.IOException;
import java.util.Random;

//import java.io.IOException;
//import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.shuyuanwl.sms.api.bean.DownRes;
import com.shuyuanwl.sms.api.core.ApiSender;
import com.wzxy.aroundtaxi.mapper.DriverMapper;
import com.wzxy.aroundtaxi.mapper.PassengerMapper;
import com.wzxy.aroundtaxi.mapper.YzmMapper;
import com.wzxy.aroundtaxi.pojo.Yzm;
//import com.wzxy.aroundtaxi.pojo.Yzm;
import com.wzxy.aroundtaxi.service.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	PassengerMapper pm;
	@Autowired
	YzmMapper ym;
	@Autowired
	DriverMapper dm;

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
	 * 用户注册
	 */
	@Override
	public int regist(String Phonenum, String Password) {
		int result = pm.add(Phonenum, Password);
		dm.adddrph(Phonenum);
		return result;
	}

	/**
	 * 发送验证码并保存
	 */
	public String send_yzm(String Phonenum) throws IOException{
	String result="";
	try {
		//生成6位验证码
	    String yzmcode = String.valueOf(new Random().nextInt(899999) + 100000);	
	    String url = "http://api.shuyuanwl.com:8080/api/sms/send";
		String mobiles = Phonenum; //号码
		String content = "【Worker】您的验证码是："+yzmcode;//短信内容
		String account = "wzdskj@wzdskj"; //账号
		String extno = "01"; //扩展码
		String password = "USLd7Y8p";//密码
		String batchno = "";//批次号
		DownRes res = ApiSender.send(url, account, password, mobiles, content, extno,batchno);
		System.out.println(res);
		String code = res.getCode();   //获得code的值
		System.out.println(code); 
		
		Yzm yzm = new Yzm();
		yzm.setPhonenum(Phonenum);
		yzm.setCode(yzmcode);
		
		if(code.equals("200")) {
		    ym.add(yzm);
		}
        result = code;
		
	}catch (Exception e) {
        e.printStackTrace();
     }
	return result;
	}
	/**
	 * 验证码验证
	 */
	@Override
	public boolean Compare(String Phonenum, String Code) {
		boolean result = ym.compare(Phonenum, Code);
		System.out.println(result);
		return result;
	}

	/**
	 * 超时删除验证码
	 */
	@Override
	public int delete(String Phonenum) {
		int result = ym.delete(Phonenum);
		return result;
	}

	/**
	 * 用户修改密码
	 */
	public int updatepwd(String Phonenum, String Password) {
		int result = pm.updatepwd(Phonenum, Password);
		return result;
	}

	/**
	 * 用户登录
	 */
	@Override
	public boolean login(String Phonenum, String Password) {
		boolean result = pm.login(Phonenum, Password);
		return result;
	}

}
