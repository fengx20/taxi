package com.wzxy.aroundtaxi.service;

import java.util.List;

import com.wzxy.aroundtaxi.pojo.Car;
import com.wzxy.aroundtaxi.pojo.Driver;

public interface WebDriverService {

    /**
     * 审核司机
     *
     * @param Phonenum
     * @return
     */
    public int checkdr(String Phonenum);

    /**
     * 停用司机
     *
     * @param Phonenum
     * @return
     */
    public int stopdr(String Phonenum);

    /**
     * 未审核司机列表
     *
     * @return
     */
    public List<Driver> driver_sh();

    /**
     * 正式司机列表
     *
     * @return
     */
    public List<Driver> driver_zs();

    /**
     * 判断司机是否存在
     */
    public boolean exist_driver(String Phonenum);

    /**
     * 添加
     *
     * @return
     */
    public int addDr(String Phonenum, String Jobnum, String Idnum, String Driverage, String Name, String Sex, String Birth);

    /**
     * 判断司机地理位置是否已存在
     *
     * @param Phonenum
     * @return
     */
    public boolean exist_dradd(String Phonenum);

    /**
     * 修改
     *
     * @return
     */
    public int updateDr(String Phonenum, String Jobnum, String Idnum, String Driverage, String Name, String Sex, String Birth);

    /**
     * 删除
     *
     * @param Phonenum
     * @return
     */
    public int deleteDr(String Phonenum);

    /**
     * 查询所有
     *
     * @return
     */
    public List<Driver> list();

    /**
     * 查询单个
     *
     * @param Phonenum
     * @return
     */
    public List<Driver> selectbyphonenum(String Phonenum);

    /**
     * 司机车辆列表
     *
     * @return
     */
    public List<Car> list_web();

}
