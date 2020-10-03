package com.wzxy.aroundtaxi.service;

import org.json.JSONArray;

public interface AppPassengerService {


    /**
     * 乘客完善信息
     */
    public int registfull(String Phonenum, String Name, String Sex, String Birth);

    /**
     * 乘客查询信息
     *
     * @param Phonenum
     * @return
     */
    public String list(String Phonenum);

    /**
     * 获取附近司机地址
     */
    public JSONArray getnearby(double Longitude, double latitude);

    /**
     * 判断乘客地理位置是否存在
     */
    public boolean exist_address(String Phonenum);

    /**
     * 更新乘客地址
     */
    public void update_address(String Phonenum, double Longitude, double latitude);

    /**
     * 保存乘客地址
     */
    public int save_address(String Phonenum, double Longitude, double latitude);

    /**
     * 乘客找车中
     */
    public void update_status(String Phonenum);

    /**
     * 添加进order
     */
    public int addorder(String Phonenum);

    /**
     * 判断order是否存在
     *
     * @param Phonenum
     * @return
     */
    public boolean existpa(String Phonenum);

    /**
     * 查询是否有司机接单
     *
     * @param Phonenum
     * @return
     */
    public String getdrph(String Phonenum);

    /**
     * 取消找车/乘车结束
     *
     * @param Phonenum
     * @return
     */
    public int delete(String Phonenum);

    /**
     * 乘客无乘车需求
     */
    public void update_nostatus(String Phonenum);

    /**
     * 获取选中司机信息
     */
    public String getdr(String Phonenum);

    /**
     * 获取该司机地理位置
     */
    public String getdr_add(String Phonenum);


}
