package com.wzxy.aroundtaxi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wzxy.aroundtaxi.pojo.Passenger;
import com.wzxy.aroundtaxi.service.WebPassengerService;

@Controller
@RequestMapping("pa_web")
public class WebPassengerController {

    @Autowired
    WebPassengerService wps;

    /**
     * 添加用户
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/add_pa", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Add_Pa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String Password = request.getParameter("password");
        String Name = request.getParameter("name");
        String Sex = request.getParameter("sex");
        String Birth = request.getParameter("birth");
        if (wps.exist_user(Phonenum) == false) {
            wps.addPa(Phonenum, Password, Name, Sex, Birth);
            response.setContentType("text/html;charset=utf8");
            PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript' charset='utf-8' language='javascript' >");
            out.print("alert('添加成功！');");
            out.print("window.opener.location.reload();");
            out.print("window.close();");
            out.print("</script>");
        } else {
            response.setContentType("text/html;charset=utf8");
            PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript' charset='utf-8' language='javascript' >");
            out.print("alert('用户已存在');");
            out.print("history.go(-1);");
            out.print("</script>");
        }
    }


    /**
     * 更新用户
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/update_pa", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Update_Pa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String Password = request.getParameter("password");
        String Name = request.getParameter("name");
        String Sex = request.getParameter("sex");
        String Birth = request.getParameter("birth");
        wps.updatePa(Phonenum, Password, Name, Sex, Birth);
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        out.print("<script type='text/javascript' charset='utf-8' language='javascript' >");
        out.print("alert('修改成功！！');");
        out.print("window.opener.location.reload();");
        out.print("window.close();");
        out.print("</script>");
    }


    /**
     * 删除用户
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/delete_pa", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public void Delete_Pa(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        wps.deletePa(Phonenum);

        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        out.print("<script type='text/javascript' charset='utf-8' language='javascript' >");
        out.print("alert('已删除');");
        out.print("history.go(-1);");
        out.print("</script>");
    }


    /**
     * 查询所有用户
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/list_pa", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public void List_Pa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Passenger> list = wps.list();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/userlist.jsp").forward(request, response);
    }


    /**
     * 查询单个用户
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/listbyph_pa", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void ListByPh_Pa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Phonenum = request.getParameter("phonenum");
        List<Passenger> list = wps.selectbyphonenum(Phonenum);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/usermes.jsp").forward(request, response);
    }

}
