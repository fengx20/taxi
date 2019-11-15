package com.wzxy.aroundtaxi.mapper;

import com.wzxy.aroundtaxi.pojo.Yzm;

public interface YzmMapper {
	
	/**
	 * 插入
	 * @param yzm
	 * @return
	 */
	public int add(Yzm yzm);
	
	/**
	 * 查询对比
	 * @param Phonenum
	 * @param Code
	 * @return
	 */
	public boolean compare(String Phonenum,String Code);
	
	/**
	 * 删除
	 * @param Phonenum
	 */
	public int delete(String Phonenum);

}
