package com.wzxy.aroundtaxi.mapper;

import java.util.List;

import com.wzxy.aroundtaxi.pojo.PaAddress;

public interface PaAddressMapper {

    /**
     * 插入
     *
     * @param Phonenum
     * @param Longitude
     * @param Latitude
     * @return
     */
    public int add(String Phonenum, double Longitude, double Latitude);

    /**
     * 查询对比
     *
     * @param Phonenum
     * @return
     */
    public boolean exist(String Phonenum);

    /**
     * 更新
     *
     * @param Longitude
     * @param Latitude
     * @param Phonenum
     */
    public void update(double Longitude, double Latitude, String Phonenum);

    /**
     * 更新
     *
     * @param Phonenum
     */
    public void update_status(String Phonenum);


    /**
     * 更新
     *
     * @param Phonenum
     */
    public void update_nostatus(String Phonenum);

    /**
     * 查询
     *
     * @param phonenum
     * @return
     */
    public List<PaAddress> list(String phonenum);

    /**
     * 查询
     *
     * @param Longitude
     * @param latitude
     * @return
     */
    public List<PaAddress> select_pa(double Longitude, double latitude);
}
