<%@ page language="java" import="java.util.*,java.util.List,com.wzxy.aroundtaxi.pojo.Driver" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href=" <%=basePath%>">  
<meta charset="UTF-8">
<title>司机审核</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/font.css">
	<link rel="stylesheet" href="css/xadmin.css">
    <link rel="stylesheet" href="https://cdn.bootcss.com/Swiper/3.4.2/css/swiper.min.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
    <script src="lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="js/xadmin.js"></script>
</head>
<body>
<!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="">Taxi</a></div>
        <div class="open-nav"><i class="iconfont">&#xe699;</i></div>
        <ul class="layui-nav right" >
          <li class="layui-nav-item">
            <a href="javascript:;">管理员</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a href="login.jsp">退出</a></dd>
            </dl>
          </li>
        </ul>
    </div>
    <!-- 顶部结束 -->
    <div class="wrapper">
         <!-- 左侧菜单开始 -->
        <div class="left-nav">
          <div id="side-nav">
            <ul id="nav">
            
                <li class="list">
                    <a href="<%=path%>/ma_web/index">
                        <i class="iconfont">&#xe761;</i>
                        欢迎页面
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                </li>
                
                <li class="list">
                    <a href="javascript:;">
                        <i class="iconfont">&#xe70b;</i>
                        乘客管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    
                    <ul class="sub-menu">
                        <li>
                            <a href="<%=path%>/pa_web/list_pa">
                                <i class="iconfont">&#xe6a7;</i>
                                乘客列表
                            </a>
                        </li>
                    </ul>
                </li>
                
                
               <li class="list">
                    <a href="javascript:;">
                        <i class="iconfont">&#xe70b;</i>
                       司机管理
                        <i class="iconfont nav_right">&#xe697;</i>
                    </a>
                    
                    <ul class="sub-menu">
                        <li>
                            <a href="<%=path%>/dr_web/list_dr">
                                <i class="iconfont">&#xe6a7;</i>
                                司机列表
                            </a>
                        </li>
                    </ul>
                    
                    <ul class="sub-menu">
                        <li>
                            <a href="<%=path%>/dr_web/select_sh">
                                <i class="iconfont">&#xe6a7;</i>
                                司机审核
                            </a>
                        </li>
                    </ul>
                    <ul class="sub-menu">
                        <li>
                            <a href="<%=path%>/dr_web/list_drcar">
                                <i class="iconfont">&#xe6a7;</i>
                                车辆管理
                            </a>
                        </li>
                    </ul>
                </li>
                
            </ul>
          </div>
        </div>
        
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
        <div class="page-content">
          <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->
            <xblock>
            <button class="layui-btn" onclick="window.open('<%=path%>/adddriver.jsp','_blank','width=600,height=500,top=150,left=400');"><i class="layui-icon">&#xe608;</i>添加</button>
            <span class="x-right" style="line-height:40px">共有数据： 条</span>
            </xblock>
            
            <table id="tbody-result" class="layui-table">
                
                    <tr>
                        <th>
                            <input type="checkbox" name="" value="">
                        </th>
                        <th>
                            手机
                        </th>
                        <th>
                         行业资格证号
                        </th>
                        <th>
                            身份证号
                        </th>
                        <th>
                            驾龄
                        </th>
                        <th>
                            姓名
                        </th>
                        <th>
                            性别
                        </th>
                        <th>
                            出生年月
                        </th>
                        <th>
                            状态
                        </th>             
                        <th>
                            操作
                        </th>
                        <th>
                            审核
                        </th>
                    </tr>
               
                
                <%
   //循环显示数据
   @SuppressWarnings("unchecked")
    List<Driver>list=(List)request.getAttribute("list"); // 取request里面的对象队列
    if(list.size()!=0){
      for(int i=0;i<list.size();i++){
      Driver dr=new Driver(); //新建对象
      dr=list.get(i);   //每循环一次后将此时的值保存到对象里
                %>

                    <tr>
                        <td>
                            <input type="checkbox" value="1" name="">
                        </td>
                        <td>
                           <%=list.get(i).getPhonenum()%>
                        </td>
                        <td >
                           <%=list.get(i).getJobnum()%>
                        </td>
                        <td >
                           <%=list.get(i).getIdnum()%>
                        </td>
                        <td >
                           <%=list.get(i).getDriverage()%>
                        </td>
                        <td >
                           <%=list.get(i).getName()%>
                        </td>
                        <td >
                            <%=list.get(i).getSex()%>
                        </td>
                        <td>
                           <%=list.get(i).getBirth()%>
                        </td>
                         <td >
                           <%=list.get(i).getStatus()%>
                        </td>
                        <td class="td-manage">
                            <a title="编辑" href="javascript:void(0)" onclick="window.open('<%=path%>/editdriver.jsp?phonenum=<%=list.get(i).getPhonenum()%>&jobnum=<%=list.get(i).getJobnum()%>&idnum=<%=list.get(i).getIdnum()%>&driverage=<%=list.get(i).getDriverage()%>&name=<%=list.get(i).getName()%>&sex=<%=list.get(i).getSex()%>&birth=<%=list.get(i).getBirth()%>','_blank','width=600,height=500,top=150,left=400');"
                            class="ml-5" style="text-decoration:none">
                                <i class="layui-icon">&#xe642;</i>
                            </a>
                            <a title="删除"  href="<%=path%>/dr_web/delete_dr?phonenum=<%=list.get(i).getPhonenum()%>" style="text-decoration:none">
                                <i class="layui-icon">&#xe640;</i>
                            </a>
                        </td>
                        <td class="td-manage">
                            <a title="通过"  href="<%=path%>/dr_web/check_dr?phonenum=<%=list.get(i).getPhonenum()%>" style="text-decoration:none">
                                <i class="layui-icon">&#xe642;</i>
                            </a>
                        </td>
                    </tr>
               
                <%
            }
              }else{
             %>
    <tr><td colspan="11">暂无需审核司机</td></tr>
            <%
           }
            %> 
            </table>
            
            <!-- 右侧内容框架，更改从这里结束 -->
          </div>
        </div>
        <!-- 右侧主体结束 -->
    </div>
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
    </div>
    <!-- 底部结束 -->
    <!-- 背景切换开始 -->
    <div class="bg-changer">
        <div class="swiper-container changer-list">
            <div class="swiper-wrapper">
                <div class="swiper-slide"><img class="item" src="images/a.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="images/b.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="images/c.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="images/d.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="images/e.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="images/f.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="images/g.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="images/h.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="images/i.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="images/j.jpg" alt=""></div>
                <div class="swiper-slide"><img class="item" src="images/k.jpg" alt=""></div>
                <div class="swiper-slide"><span class="reset">初始化</span></div>
            </div>
        </div>
        <div class="bg-out"></div>
        <div id="changer-set"><i class="iconfont">&#xe696;</i></div>   
    </div>
    <!-- 背景切换结束 -->
    <!-- 页面动态效果 -->
</body>
</html>