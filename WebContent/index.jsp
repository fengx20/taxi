<%@ page language="java" contentType="text/html; charset=UTF-8"
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
    <title>后台界面</title>
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
    <ul class="layui-nav right">
        <li class="layui-nav-item">
            <a href="javascript:;">管理员</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a href="login.jsp">退出</a></dd>
            </dl>
        </li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
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
            <blockquote class="layui-elem-quote">

            </blockquote>
            <blockquote class="layui-elem-quote">

            </blockquote>
            <fieldset class="layui-elem-field layui-field-title site-title">
                <legend><a>信息统计</a></legend>
            </fieldset>
            <table class="layui-table">
                <thead>
                <tr>
                    <th>统计</th>
                    <th>用户注册</th>
                    <th>司机认证</th>
                    <th>交易次数</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>总数</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
                <tr>
                    <td>今日</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
                <tr>
                    <td>昨日</td>
                    <td>0</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
                <tr>
                    <td>本周</td>
                    <td>2</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
                <tr>
                    <td>本月</td>
                    <td>2</td>
                    <td>0</td>
                    <td>0</td>
                </tr>
                </tbody>
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
</body>
</html>