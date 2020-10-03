package com.wzxy.aroundtaxi.mapper;

import java.util.List;

import com.wzxy.aroundtaxi.pojo.Passenger;

public interface PassengerMapper {

    /**
     * 添加（app注册）
     *
     * @param
     * @param Password
     * @return
     */
    public int add(String Phonenum, String Password);

    /**
     * 添加（app完善信息）
     *
     * @param Name
     * @param Sex
     * @param Birth
     * @return
     */
    public int updatefull(String Name, String Sex, String Birth, String Phonenum);

    /**
     * 查询（app查询信息）
     *
     * @param Phonenum
     * @return
     */
    public List<Passenger> selectfull(String Phonenum);

    /**
     * 更新（app修改密码）
     *
     * @param Phonenum
     * @param Password
     * @return
     */
    public int updatepwd(String Phonenum, String Password);

    /**
     * 查询（app判断用户存在）
     *
     * @param Phonenum
     * @return
     */
    public boolean exist(String Phonenum);

    /**
     * 查询（app验证用户登录）
     *
     * @param Phonenum
     * @param Password
     * @return
     */
    public boolean login(String Phonenum, String Password);


    /**
     * 添加（web管理）
     *
     * @param pa
     * @return
     */
    public int add_web(String Phonenum, String Password, String Name, String Sex, String Birth);

    /**
     * 删除（web管理）
     *
     * @param Phonenum
     * @return
     */
    public int delete_web(String Phonenum);

    /**
     * 更新（web管理）
     *
     * @param Phonenum
     * @return
     */
    public int update_web(String Password, String Name, String Sex, String Birth, String Phonenum);

    /**
     * 查询所有（web管理）
     *
     * @return
     */
    public List<Passenger> list_web();

    /**
     * 查询 by phonenum （web管理）
     *
     * @param Phonenum
     * @return
     */
    public List<Passenger> listbyph_web(String Phonenum);


}
