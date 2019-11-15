package com.wzxy.aroundtaxi.service.impl;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.wzxy.aroundtaxi.mapper.CarMapper;
import com.wzxy.aroundtaxi.mapper.DrAddressMapper;
import com.wzxy.aroundtaxi.mapper.DriverMapper;
import com.wzxy.aroundtaxi.mapper.OrderMapper;
import com.wzxy.aroundtaxi.mapper.PaAddressMapper;
import com.wzxy.aroundtaxi.pojo.PaAddress;
import com.wzxy.aroundtaxi.service.AppDriverService;

@Service
public class AppDriverServiceImpl implements AppDriverService {
	
	@Autowired
	DriverMapper dm;
	@Autowired
	CarMapper cm;
	@Autowired
	PaAddressMapper pam;
	@Autowired
	DrAddressMapper dam;
	@Autowired
	OrderMapper om;
	
	
	/**
	 * 判断车辆是否存在
	 */
	@Override
	public boolean exist_car(String Carnum) {
		boolean result = cm.selectcar(Carnum);
		System.out.println(result);
		return result;
	}
    
	/**
	 * 司机注册
	 */
	@Override
	public void regist_dr(String Phonenum,String Jobnum,String Idnum,String Name,String Driverage,String Carnum,String Cartype,String Carimg) {
		 dm.update(Jobnum, Idnum, Name,Driverage,Phonenum);
		 cm.add(Carnum, Phonenum, Name, Cartype, Carimg);
	}
	
	/**
	 * 司机审核结果
	 * @param Phonenum
	 */
	public boolean result_dr(String Phonenum) {
		boolean result = dm.select_result(Phonenum);
		return result;
	}
	
	/**
	 * 司机未填写认证
	 * @param Phonenum
	 */
	public boolean result_drno(String Phonenum) {
		boolean result = dm.select_resultno(Phonenum);
		return result;
	}
	
	/**
	 * 判断司机地理位置是否存在
	 */
	@Override
	public boolean exist_dradd(String Phonenum) {
		boolean result = dam.selectph_dradd(Phonenum);
		return result;
	}
	
	/**
	 * 司机上传地理位置
	 */
	@Override
	public int save_dradd(String Phonenum,double Longitude,double Latitude,String Status) {
		int result = dam.add(Phonenum, Longitude, Latitude,Status);
		return result;
	}
	
	/**
	 * 司机更新地理位置
	 */
	@Override
	public int update_dradd(double Longitude,double Latitude,String Phonenum) {
		int result = dam.update_address(Longitude, Latitude, Phonenum);
		return result;
	}
	
	/**
	 * 获取附近有乘车需求乘客地理位置
	 */
	@Override
	public JSONArray getPaNearby(double Longitude,double latitude){
		List<PaAddress> list = pam.select_pa(Longitude, latitude);
		System.out.println("list="+list);
		JSONArray json = new JSONArray();
        for(PaAddress PA : list){
            JSONObject jo = new JSONObject();
            jo.put("pa_phonenum", PA.getPa_phonenum());
            jo.put("longitude", PA.getLongitude());
            jo.put("latitude", PA.getLatitude());
            json.put(jo);
        }
		return json;
	}
	
	/**
	 * 空车
	 */
	@Override
	public void start_dr(String Phonenum) {
		dam.update_start(Phonenum);
	}
	
	/**
	 * 获取乘客地理位置
	 */
	@Override
	public String getpa_address(String Phonenum) {
		 List<PaAddress> list =  pam.list(Phonenum);
		 Gson gson = new Gson();  
		 String json = gson.toJson(list);
		 System.out.println(json);
		 return json;
	}
	
	/**
	 * 满车
	 */
	@Override
	public void end_dr(String Phonenum) {
		dam.update_end(Phonenum);
	}
	
	
	/**
	 * 接单  修改order
	 * @param Pa_Phonenum
	 * @param Dr_Phonenum
	 * @return
	 */
	@Override
	public int updateOrder(String Pa_Phonenum,String Dr_Phonenum) {
		int result = 0;
		if(om.selectpa(Pa_Phonenum)==false) {
			result = om.update(Dr_Phonenum, Pa_Phonenum);
		}
		System.out.println(result);
		 return result;
	}
	
	


}
