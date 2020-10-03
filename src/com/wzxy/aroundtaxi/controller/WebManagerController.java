package com.wzxy.aroundtaxi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wzxy.aroundtaxi.service.WebManagerService;
import com.wzxy.aroundtaxi.utils.OutUtils;

@Controller
@RequestMapping("ma_web")
public class WebManagerController {

    @Autowired
    WebManagerService wms;


    /**
     * 欢迎页
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public void Index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }


    /**
     * 管理员登录
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/ma_login", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Ma_Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        if (wms.login(Username, Password) == true) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            response.setContentType("text/html;charset=utf8");
            PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
            out.print("alert('账号或密码错误');");
            out.print("history.go(-1);");
            out.print("</script>");
        }
    }


    /**
     * 添加管理员
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/add_ma", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Add_Ma(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        String Phonenum = request.getParameter("phonenum");
        int re = wms.addMa(Username, Password, Phonenum);
        String result = "";
        if (re == 1) {
            result = "success";
        } else {
            result = "failed";
        }
        OutUtils.returnajax(result, response);
    }


    /**
     * 更新管理员
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/update_ma", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Update_Ma(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        int re = wms.updateMa(Username, Password);
        String result = "";
        if (re == 1) {
            result = "success";
        } else {
            result = "failed";
        }
        OutUtils.returnajax(result, response);
    }


    /**
     * 删除管理员
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/delete_ma", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Delete_Ma(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Username = request.getParameter("username");
        int re = wms.deleteMa(Username);
        String result = "";
        if (re == 1) {
            result = "success";
        } else {
            result = "failed";
        }
        OutUtils.returnajax(result, response);
    }


    /**
     * 管理员列表
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/list_ma", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void List_Ma(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String json = wms.list();
        OutUtils.returnajax(json, response);
    }


    /**
     * 查询单个
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/listbyuser_ma", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void ListByUser_Ma(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Username = request.getParameter("username");
        String json = wms.selectbyusername(Username);
        OutUtils.returnajax(json, response);
    }
}
