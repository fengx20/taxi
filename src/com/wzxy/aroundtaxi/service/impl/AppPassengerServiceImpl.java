package com.wzxy.aroundtaxi.service.impl;

import java.util.List;
import java.util.Map;

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
import com.wzxy.aroundtaxi.mapper.PassengerMapper;
import com.wzxy.aroundtaxi.pojo.DrAddress;
import com.wzxy.aroundtaxi.pojo.Passenger;
import com.wzxy.aroundtaxi.service.AppPassengerService;

@Service
public class AppPassengerServiceImpl implements AppPassengerService {

    @Autowired
    PassengerMapper pm;
    @Autowired
    DrAddressMapper dam;
    @Autowired
    PaAddressMapper pam;
    @Autowired
    DriverMapper dm;
    @Autowired
    CarMapper cm;
    @Autowired
    OrderMapper om;


    /**
     * 乘客完善信息
     */
    @Override
    public int registfull(String Phonenum, String Name, String Sex, String Birth) {
        int result = pm.updatefull(Name, Sex, Birth, Phonenum);
        dm.updatefull(Sex, Birth, Phonenum);
        return result;
    }


    /**
     * 乘客查询信息
     *
     * @param Phonenum
     * @return
     */
    public String list(String Phonenum) {
        List<Passenger> list = pm.selectfull(Phonenum);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        return json;
    }

    /**
     * 判断乘客地理位置是否存在
     */
    @Override
    public boolean exist_address(String Phonenum) {
        boolean result = pam.exist(Phonenum);
        return result;
    }

    /**
     * 保存乘客地理位置
     */
    @Override
    public int save_address(String Phonenum, double Longitude, double Latitude) {
        int result = pam.add(Phonenum, Longitude, Latitude);
        return result;
    }

    /**
     * 更新乘客地理位置
     */
    @Override
    public void update_address(String Phonenum, double Longitude, double Latitude) {
        pam.update(Longitude, Latitude, Phonenum);
    }

    /**
     * 获取附近司机地理位置
     */
    @Override
    public JSONArray getnearby(double Longitude, double latitude) {
        List<DrAddress> list = dam.select_dr(Longitude, latitude);
        System.out.println("list=" + list);
        JSONArray json = new JSONArray();
        for (DrAddress DA : list) {
            JSONObject jo = new JSONObject();
            jo.put("dr_phonenum", DA.getDr_phonenum());
            jo.put("longitude", DA.getLongitude());
            jo.put("latitude", DA.getLatitude());
            json.put(jo);
        }
        return json;

    }

    /**
     * 乘客找车中
     */
    @Override
    public void update_status(String Phonenum) {
        pam.update_status(Phonenum);
    }

    /**
     * 添加进order
     */
    @Override
    public int addorder(String Phonenum) {
        int result = om.add(Phonenum);
        return result;
    }

    /**
     * 判断order是否存在
     *
     * @param Phonenum
     * @return
     */
    @Override
    public boolean existpa(String Phonenum) {
        boolean result = om.selectexist(Phonenum);
        return result;
    }

    /**
     * 查询是否有司机接单
     *
     * @param Phonenum
     * @return
     */
    @Override
    public String getdrph(String Phonenum) {
        String result = om.select(Phonenum);
        return result;
    }

    /**
     * 取消找车
     *
     * @param Phonenum
     * @return
     */
    @Override
    public int delete(String Phonenum) {
        int result = om.delete(Phonenum);
        return result;
    }

    /**
     * 乘客无乘车需求
     */
    @Override
    public void update_nostatus(String Phonenum) {
        pam.update_nostatus(Phonenum);
    }

    /**
     * 获取选中司机信息及地理位置
     */
    @Override
    public String getdr(String Phonenum) {
        @SuppressWarnings("rawtypes")
        Map rm = cm.list(Phonenum);
        System.out.println(rm);
        Gson gson = new Gson();
        String json = gson.toJson(rm);
        System.out.println(json);
        return json;
    }

    /**
     * 获取该司机地理位置
     */
    @Override
    public String getdr_add(String Phonenum) {
        List<DrAddress> list = dam.select_dradd(Phonenum);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json);
        return json;
    }


}
