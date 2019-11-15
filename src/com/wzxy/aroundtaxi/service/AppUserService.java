package com.wzxy.aroundtaxi.service;

//import java.io.IOException;

public interface AppUserService {
	
	/**
	 * 判断用户是否存在
	 */
	public boolean exist_user(String Phonenum);
	
	/**
	 * 注册
	 */
	public int regist(String Phonenum,String Password);
	
	/**
	 * 发送验证码并保存
	 */
	//public String send_yzm(String Phonenum) throws IOException ;
	
	/**
	 * 验证码验证
	 */
	public boolean Compare(String Phonenum,String Code);
	
	/**
	 * 超时删除验证码
	 */
	public int delete(String Phonenum);
	
	/**
	 * 修改密码
	 */
	public int updatepwd(String Phonenum,String Password);
	
	/**
	 * 登录
	 */
	public boolean login(String Phonenum,String Password);

}
