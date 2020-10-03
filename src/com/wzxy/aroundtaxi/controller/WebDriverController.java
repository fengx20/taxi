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

import com.wzxy.aroundtaxi.pojo.Car;
import com.wzxy.aroundtaxi.pojo.Driver;
import com.wzxy.aroundtaxi.service.WebDriverService;

@Controller
@RequestMapping("dr_web")
public class WebDriverController {


    @Autowired
    WebDriverService wds;


    /**
     * 审核司机
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/check_dr", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public void Check_Dr(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        wds.checkdr(Phonenum);
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        out.print("<script type='text/javascript' charset='utf-8' language='javascript' >");
        out.print("alert('审核通过！');");
        out.print("history.go(-1);");
        out.print("</script>");
    }


    /**
     * 停用司机
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/stop_dr", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public void Stop_Dr(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        wds.stopdr(Phonenum);

        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        out.print("<script type='text/javascript' charset='utf-8' language='javascript' >");
        out.print("alert('已停用该账号！');");
        out.print("history.go(-1);");
        out.print("</script>");
    }


    /**
     * 未审核的司机
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/select_sh", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public void Select_Sh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Driver> list = wds.driver_sh();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/driver_sh.jsp").forward(request, response);

    }


    /**
     * 正式司机列表
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/list_dr", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public void List_Dr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Driver> list = wds.driver_zs();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/driverlist.jsp").forward(request, response);

    }


    /**
     * 添加司机
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/add_dr", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Add_Dr(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String Jobnum = request.getParameter("jobnum");
        String Idnum = request.getParameter("idnum");
        String Driverage = request.getParameter("driverage");
        String Name = request.getParameter("name");
        String Sex = request.getParameter("sex");
        String Birth = request.getParameter("birth");
        if (wds.exist_driver(Phonenum) == false) {
            wds.addDr(Phonenum, Jobnum, Idnum, Driverage, Name, Sex, Birth);
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
            out.print("alert('司机已存在');");
            out.print("history.go(-1);");
            out.print("</script>");
        }
    }


    /**
     * 更新司机
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/update_dr", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void Update_Dr(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        String Jobnum = request.getParameter("jobnum");
        String Idnum = request.getParameter("idnum");
        String Driverage = request.getParameter("driverage");
        String Name = request.getParameter("name");
        String Sex = request.getParameter("sex");
        String Birth = request.getParameter("birth");
        wds.updateDr(Phonenum, Jobnum, Idnum, Driverage, Name, Sex, Birth);

        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        out.print("<script type='text/javascript' charset='utf-8' language='javascript' >");
        out.print("alert('修改成功！！');");
        out.print("window.opener.location.reload();");
        out.print("window.close();");
        out.print("</script>");
    }


    /**
     * 删除司机
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/delete_dr", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public void Delete_Dr(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Phonenum = request.getParameter("phonenum");
        wds.deleteDr(Phonenum);
        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        out.print("<script type='text/javascript' charset='utf-8' language='javascript' >");
        out.print("alert('已删除');");
        out.print("history.go(-1);");
        out.print("</script>");
    }


    /**
     * 查询单个司机
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/listbyph_dr", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public void ListByPh_Dr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Phonenum = request.getParameter("phonenum");
        List<Driver> list = wds.selectbyphonenum(Phonenum);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/drivermes.jsp").forward(request, response);
    }


    /**
     * 司机车辆列表
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/list_drcar", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public void List_DrCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Car> list = wds.list_web();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/carlist.jsp").forward(request, response);
    }

}
