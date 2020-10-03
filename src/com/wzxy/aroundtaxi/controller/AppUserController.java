package com.wzxy.aroundtaxi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wzxy.aroundtaxi.service.AppUserService;
import com.wzxy.aroundtaxi.utils.OutUtils;

@Controller
@RequestMapping("user")
public class AppUserController {

    @Autowired
    AppUserService aus;

    /**
     * 注册
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/user_regist", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Regist_Pa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String Password = request.getParameter("password");
        String Yzm = request.getParameter("yzm");
        String result = "";
        if (aus.exist_user(Phonenum) == false) {
            if (aus.Compare(Phonenum, Yzm) == true) {
                aus.regist(Phonenum, Password);
                result = "success";
            } else {
                result = "yzmerror";
            }
        } else {
            result = "exist";
        }
        OutUtils.returnajax(result, response);
    }


    /**
     * 发送验证码并保存
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/yzm_send", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Yzm_Send(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String code = aus.send_yzm(Phonenum);
        String result = "";
        if (code.equals("200")) {
            result = "success";
        } else {
            result = "failed";
        }
        OutUtils.returnajax(result, response);
    }


    /**
     * 超时删除验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/yzm_delete", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Yzm_Delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        int re = aus.delete(Phonenum);
        String result = "";
        if (re > 0) {
            result = "success";
        } else {
            result = "failed";
        }
        OutUtils.returnajax(result, response);
    }


    /**
     * 密码登录
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/user_login", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Pa_Login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String Password = request.getParameter("password");
        String result = "";
        if (aus.exist_user(Phonenum) == true) {
            if (aus.login(Phonenum, Password) == true) {
                result = "success";
            } else {
                result = "failed";
            }
        } else {
            result = "noexist";
        }
        OutUtils.returnajax(result, response);
    }


    /**
     * 验证码登录
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/user_loginbyyzm", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void User_Loginbyyzm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String Yzm = request.getParameter("yzm");
        String result = "";
        if (aus.exist_user(Phonenum) == true) {
            if (aus.Compare(Phonenum, Yzm) == true) {
                result = "success";
            } else {
                result = "failed";
            }
        } else {
            result = "noexist";
        }
        OutUtils.returnajax(result, response);
    }


    /**
     * 修改密码(忘记密码)
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/update_pwd", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Pa_Pwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String Password = request.getParameter("password");
        String result = "";
        int re = aus.updatepwd(Phonenum, Password);
        if (re == 1) {
            result = "success";
        } else {
            result = "failed";
        }
        OutUtils.returnajax(result, response);
    }


    /**
     * 忘记密码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/forget_pwd", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Forget_Pwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String Yzm = request.getParameter("yzm");
        String result = "";
        if (aus.Compare(Phonenum, Yzm) == true) {
            result = "true";
        } else {
            result = "yzmerror";
        }
        OutUtils.returnajax(result, response);
    }

}
