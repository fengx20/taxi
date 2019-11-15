<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>后台登录</title>
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
<div class="login-logo"><h1>Taxi</h1></div>
    <div class="login-box">
    
        <form class="layui-form layui-form-pane" action="<%=path%>/ma_web/ma_login" method="post">  
            <h3>管理员登录</h3>
            <label class="login-title" for="username">帐号</label>
            <div class="layui-form-item">
                <label class="layui-form-label login-form"><i class="iconfont">&#xe6b8;</i></label>
                <div class="layui-input-inline login-inline">
                  <input type="text" name="username" id="username"  placeholder="请输入你的帐号" autocomplete="off" class="layui-input">
                </div>
            </div>
            <label class="login-title" for="password">密码</label>
            <div class="layui-form-item">
                <label class="layui-form-label login-form"><i class="iconfont">&#xe82b;</i></label>
                <div class="layui-input-inline login-inline">
                  <input type="password" name="password" id="password"  placeholder="请输入你的密码" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="form-actions">
                <input type="submit"  value="登录"  class="btn btn-warning pull-right" /> 
            </div>
        </form>
        
    </div>
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