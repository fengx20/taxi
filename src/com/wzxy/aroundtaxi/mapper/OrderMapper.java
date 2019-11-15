package com.wzxy.aroundtaxi.mapper;

public interface OrderMapper {
	
	/**
	 * 查询是否存在
	 * @param Pa_Phonenum
	 * @return
	 */
	public boolean selectexist(String Pa_Phonenum);
	
	/**
	 * 添加 
	 * @param Pa_Phonenum
	 * @return
	 */
	public int add(String Pa_Phonenum);
	
	/**
	 * 删除
	 * @param Pa_Phonenum
	 * @return
	 */
	public int delete(String Pa_Phonenum);
	
	/**
	 * 更新
	 * @param Dr_Phonenum
	 * @param Pa_Phonenum
	 * @return
	 */
	public int update(String Dr_Phonenum,String Pa_Phonenum);
	
	/**
	 * 查询司机号码
	 * @param Pa_Phonenum
	 * @return
	 */
	public String select(String Pa_Phonenum);
	
	/**
	 * 查询是否有司机号码
	 * @param Pa_Phonenum
	 * @return
	 */
	public boolean selectpa(String Pa_Phonenum);

}
