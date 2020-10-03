<%@ page language="java" import="java.util.*,java.util.List,com.wzxy.aroundtaxi.pojo.Driver"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href=" <%=basePath%>">
    <meta charset="UTF-8">
    <title>编辑乘客</title>
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
<%
    String Phonenum = request.getParameter("phonenum");
    String Jobnum = request.getParameter("jobnum");
    String Idnum = request.getParameter("idnum");
    String Driverage = request.getParameter("driverage");
    String Name = request.getParameter("name");
    String Sex = request.getParameter("sex");
    String Birth = request.getParameter("birth");
%>
<!-- 中部开始 -->
<div class="wrapper">
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="content">
            <!-- 右侧内容框架，更改从这里开始 -->

            <form class="layui-form" action="<%=path%>/dr_web/update_dr" method="post">

                <div class="layui-form-item">

                    <label for="L_email" class="layui-form-label">
                        手机
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="phonenum" name="phonenum" required
                               autocomplete="off" value=<%=Phonenum %> readOnly class="layui-input"/>
                    </div>

                    <div class="layui-form-mid layui-word-aux">
                    </div>

                </div>

                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        行业资格证号
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="jobnum" name="jobnum" required
                               autocomplete="off" value=<%=Jobnum %>  class="layui-input"/>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        身份证号
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="idnum" name="idnum" required
                               autocomplete="off" value=<%=Idnum %>  class="layui-input"/>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        驾龄
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="driverage" name="driverage" required
                               autocomplete="off" value=<%=Driverage %>  class="layui-input"/>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        姓名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="name" name="name" required
                               autocomplete="off" value=<%=Name %>  class="layui-input"/>
                    </div>

                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <input type="radio" name="sex" value="男" checked title="男"/>
                            <input type="radio" name="sex" value="女" title="女"/>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label for="L_username" class="layui-form-label">
                        出生年月
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" id="birth" name="birth" required
                               autocomplete="off" value=<%=Birth %> class="layui-input"/>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label for="L_sign" class="layui-form-label">
                    </label>
                    <input type="submit" class="layui-btn" value="保存"/>
                </div>

            </form>

            <!-- 右侧内容框架，更改从这里结束 -->
        </div>
    </div>
    <!-- 右侧主体结束 -->
</div>
<!-- 中部结束 -->
</body>
</html>