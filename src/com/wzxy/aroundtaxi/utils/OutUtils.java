package com.wzxy.aroundtaxi.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class OutUtils {
	
	public static void returnajax(Object ob,HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    out.print(ob);//返回信息
	    out.flush();
	    out.close();  
	}

}
