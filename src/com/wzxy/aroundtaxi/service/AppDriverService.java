package com.wzxy.aroundtaxi.service;

import org.json.JSONArray;

public interface AppDriverService {


    /**
     * 判断车辆是否存在
     */
    public boolean exist_car(String Carnum);

    /**
     * 司机注册
     */
    public void regist_dr(String Phonenum, String Jobnum, String Idnum, String Name, String Driverage, String Carnum, String Cartype, String Carimg);

    /**
     * 司机审核结果
     *
     * @param Phonenum
     */
    public boolean result_dr(String Phonenum);

    /**
     * 司机未填写认证
     *
     * @param Phonenum
     */
    public boolean result_drno(String Phonenum);

    /**
     * 判断司机地理位置是否存在
     */
    public boolean exist_dradd(String Phonenum);

    /**
     * 司机上传地理位置
     */
    public int save_dradd(String Phonenum, double Longitude, double Latitude, String Status);

    /**
     * 获取附近有乘车需求乘客地理位置
     */
    public JSONArray getPaNearby(double Longitude, double latitude);

    /**
     * 空车
     */
    public void start_dr(String Phonenum);

    /**
     * 满车
     */
    public void end_dr(String Phonenum);

    /**
     * 司机更新地理位置
     */
    public int update_dradd(double Longitude, double Latitude, String Phonenum);

    /**
     * 获取乘客地理位置
     */
    public String getpa_address(String Phonenum);

    /**
     * 接单  修改order
     *
     * @param Pa_Phonenum
     * @param Dr_Phonenum
     * @return
     */
    public int updateOrder(String Pa_Phonenum, String Dr_Phonenum);


}
