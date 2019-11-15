package com.wzxy.aroundtaxi.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wzxy.aroundtaxi.service.AppPassengerService;
import com.wzxy.aroundtaxi.utils.OutUtils;

//告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("passenger")
public class AppPassengerController {
	
	@Autowired
	AppPassengerService aps;
	
	/**
	 *乘客完善信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/pa_addfull",method=RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public void Pa_AddFull(HttpServletRequest request,HttpServletResponse response) throws IOException {
	     String Phonenum = request.getParameter("phonenum");
	     String Name     = request.getParameter("name");
	     String Sex      = request.getParameter("sex");
	     String Birth    = request.getParameter("birth");
	     aps.registfull(Phonenum, Name, Sex, Birth); 
	     String result = "success";
	     OutUtils.returnajax(result, response);	
	}
	
	
	/**
	 * 乘客查询信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/pa_selectfull",method=RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public void Pa_SelectFull(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String Phonenum = request.getParameter("phonenum");
		String json = aps.list(Phonenum);
		System.out.println(json);
		OutUtils.returnajax(json, response);
	}
	

	/**
	 * 乘客搜索附近车辆
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/pa_getdr",method=RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public void Pa_GetNearby(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String Phonenum  = request.getParameter("phonenum");
		String Longitude1  = request.getParameter("longitude");
	    double Longitude   = Double.parseDouble(Longitude1);
	    String Latitude1   = request.getParameter("latitude");
	    double Latitude    = Double.parseDouble(Latitude1);
	    if(aps.exist_address(Phonenum)==true) {
	        aps.update_address(Phonenum, Longitude, Latitude);
	    }else {
	    	aps.save_address(Phonenum, Longitude, Latitude);
	    }
	    JSONArray json=aps.getnearby(Longitude, Latitude);
        System.out.println(json);
	    OutUtils.returnajax(json, response);	
	}
	
	
	/**
	 * 乘客获取附近车辆司机信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/pa_getdrmes",method=RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public void Pa_GetDrMes(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String Phonenum = request.getParameter("phonenum");
		String Json  =aps.getdr(Phonenum);
		OutUtils.returnajax(Json, response);
	}
	
	
	/**
	 * 乘客点击打车，发起乘车需求,保存进order，间断刷新等待接单
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/pa_need",method=RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public void Pa_Need(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String Phonenum = request.getParameter("phonenum");
		aps.update_status(Phonenum);  //找车中
		 if(aps.existpa(Phonenum)==false) {
				aps.addorder(Phonenum);
			}
	    String result = aps.getdrph(Phonenum);
	    System.out.println(result);
	    if(result !=null) {
	    	String json=aps.getdr(result);
	    	System.out.println(json);
			aps.update_nostatus(Phonenum);  //无需求
			OutUtils.returnajax(json, response);
	    }else {
	    	OutUtils.returnajax(result, response);
	    }
	}
	
	/**
	 * 乘客取消找车（点击取消）/乘车结束（点击 对司机评价）
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/pa_noneed",method=RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public void Pa_NoNeed(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String Phonenum = request.getParameter("phonenum");
	    String result = "";
		if(aps.delete(Phonenum)==1) {
			aps.update_nostatus(Phonenum);
			result = "success";
		}else {
			result = "failed";
		}
		OutUtils.returnajax(result, response);	
	}
	
	/**
	 * 上半部分异步隔几秒刷新一次显示司机路径，下半部分显示司机信息
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value="/pa_getdradd",method=RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	public void Pa_GetDr(HttpServletRequest request,HttpServletResponse response)throws IOException {	
		String Phonenum = request.getParameter("phonenum");
		String json = aps.getdr_add(Phonenum);
		OutUtils.returnajax(json, response);
	}
	
	
}
