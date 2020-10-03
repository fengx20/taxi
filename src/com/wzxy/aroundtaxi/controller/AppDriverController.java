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
import com.wzxy.aroundtaxi.service.AppDriverService;
import com.wzxy.aroundtaxi.utils.OutUtils;

@Controller
@RequestMapping("driver")
public class AppDriverController {

    @Autowired
    AppDriverService ds;

    /**
     * 司机认证
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/dr_regist", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Regist_Dr(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String Jobnum = request.getParameter("jobnum");
        String Idnum = request.getParameter("idnum");
        String Name = request.getParameter("dr_name");
        String Driverage = request.getParameter("driverage");
        String Carnum = request.getParameter("carnum");
        String Cartype = request.getParameter("cartype");
        String Carimg = request.getParameter("carimg");
        String result = "";
        if (ds.exist_car(Carnum) == false) {
            ds.regist_dr(Phonenum, Jobnum, Idnum, Name, Driverage, Carnum, Cartype, Carimg);
            result = "success";
        } else {
            result = "carexist";
        }
        System.out.println(result);
        OutUtils.returnajax(result, response);
    }


    /**
     * 司机审核结果
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/dr_sh", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Dr_Sh(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String result = "";
        if (ds.result_dr(Phonenum) == true) {
            result = "success";
        } else if (ds.result_drno(Phonenum) == true) {
            result = "noexist";
        } else {
            result = "wait";
        }
        OutUtils.returnajax(result, response);

    }


    /**
     * 司机出车、保存地理位置或更新/司机结束一次业务
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/dr_start", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Dr_UpdateAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String Longitude1 = request.getParameter("longitude");
        double Longitude = Double.parseDouble(Longitude1);
        String Latitude1 = request.getParameter("latitude");
        double Latitude = Double.parseDouble(Latitude1);
        String Status = "空车";
        if (ds.exist_dradd(Phonenum) == false) {
            ds.save_dradd(Phonenum, Longitude, Latitude, Status);
        } else {
            ds.update_dradd(Longitude, Latitude, Phonenum);
        }
        JSONArray json = ds.getPaNearby(Longitude, Latitude);
        OutUtils.returnajax(json, response);
    }


    /**
     * 司机点击确认接单获取乘客地址，更新order，更改司机状态
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/dr_getpaadd", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Dr_GetPaAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Dr_Phonenum = request.getParameter("dr_phonenum");
        String Pa_Phonenum = request.getParameter("pa_phonenum");
        if (ds.updateOrder(Pa_Phonenum, Dr_Phonenum) == 1) {  //如果可接单，返回乘客地理位置
            String Json = ds.getpa_address(Pa_Phonenum);
            ds.end_dr(Dr_Phonenum);
            //System.out.println(Json);
            //String result = "success";
            OutUtils.returnajax(Json, response);
        } else {
            String result = "failed";                     //不可则提示
            OutUtils.returnajax(result, response);
        }
    }

    /**
     * 隔几秒刷新一次显示乘客路径
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/dr_getadd", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Dr_GetAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String json = ds.getpa_address(Phonenum);
        OutUtils.returnajax(json, response);
    }

    /**
     * 司机收车或满车
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/dr_end", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Dr_End(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        ds.end_dr(Phonenum);
        String result = "success";
        OutUtils.returnajax(result, response);
    }


}
