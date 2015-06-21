<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.wjf.dao.*" %>
  
    <%@ page import="com.wjf.bean.*" %>
    <%@ page import="java.util.ArrayList"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'personal.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/slide_menu.css">
	<link rel="stylesheet" type="text/css" href="css/personal.css">
	<script type="text/javascript" src="jquery/jquery.min.js"></script>
	<script type="text/javascript" src="jquery/right_menu.js"></script>
	<script type="text/javascript" src="jquery/right_menu_show.js"></script>
	<script type="text/javascript" src="jquery/Main_to_person.js"></script>
	<script type="text/javascript" src="jquery/personal.js"></script>

  </head>
  
  <body>
  <%
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
    User user=(User)session.getAttribute("login");
  %> 
    <div id="top_div">
    
    </div>
    
    <div id="top_menu_div">
       <label class="title_sign"> Mine Message</label>
       <ul class="top_menu">
          <li class="top_menu_li"><a>首页</a></li>
          <li class="top_menu_li"><a>个人主页</a></li>
          <li class="top_menu_li" id="li_account"><a>账户设置</a>
             <div id="account_setup">
                  
                     <ul class="setup_div" id="safe_set"><a class="title">安全设置</a>
                         <li><a>修改登陆密码</a></li>
                         <li><a>手机绑定</a></li>
                         <li><a>密报问题设置</a></li>
                         <li><a>其他</a></li>
                     </ul>
        
        
        
                     <ul class="setup_div" id="person_date"><a class="title">个人资料</a>
                         <li><a>收货地址</a></li>
                         <li><a href="user_date.jsp">修改头像、昵称</a></li>
                         <li><a>消息提醒设置</a></li>
                         <li><a>隐私设置</a></li>
                     </ul>
        
        
        
                    <ul class="setup_div" id="account_bind"><a class="title">账号绑定</a>
                          <li><a>支付宝绑定</a></li>
                          <li><a>微博绑定</a></li>
                          <li><a>分享绑定</a></li>
                    </ul>
        
        
    
                 </div>
          </li>
          <li class="top_menu_li"><a>消息</a></li>
       </ul>
       <p class="point">▲</p>
    </div>
    
    
    
    <div id="center_div">
       <div id="menu_div">
            <a  id="all_function">全部功能</a>
            <a class="a_menu">我的购物车</a>
            <ul> 
               <a class="a_menu">已买到的宝贝  ▼</a>
                  <li><a>我的拍卖</a></li>
                  <li><a>我的彩票</a></li>
                  <li><a>我的电子书</a></li>
                  <li><a>我的游戏</a></li>
                  <li><a>我的理财</a></li>
            </ul>
            <a class="a_menu">购买过的宝贝</a>
            <a class="a_menu">我的收藏</a>
            <a class="a_menu">我的评价</a>
            <ul>
               <a class="a_menu">退款维权  ▼</a>
                  <li><a>退款管理</a></li>
                  <li><a>售后管理</a></li>
                  <li><a>投诉管理</a></li>
                  <li><a>举报管理</a></li>
            </ul>
            
            
       </div>	
       <div id="center_right">
            <div id="user_div">
               <div id="user_div_top">
                   <img class="u_img" src=<%=user.getU_img() %>>
                   <a class="u_name">(<%=user.getU_name() %>)</a>
                   <a class="user_div_function" id="address">我的收货地址</a>
                   <a class="user_div_function" id="discount">我的优惠信息</a>
                   <a class="user_div_function" id="alipay">我的支付宝</a>
               </div>
               <div id="user_div_bottom">
                    <ul>
                       <li><a>待付款</a></li>
                       <li><a>待收货</a></li>
                       <li><a>待评价</a></li>
                       <li><a>退款</a></li>
                    </ul>
               </div>
            </div>
            
            <div id="ware_div">
                <div class="ware_top_div">
                
                </div>
                
                <div class="ware_bottom_div">
                
                </div>
            
            </div>
            
       </div>
    
    </div>
    <div id="main_right">
         <img class="cycle" src="img/cycle.jpg">
         
         <div id="right_shop">
         <img class="shop" src="img/shop.png">
         <p class="shop">购<br>物<br>车</p>
         </div>
         
         <div id="main_menu">
            <ul>
               <li id="a_assets"><a>￥</a>
                   <div id="div_assets">我的资产</div>
               </li>
               <li id="a_attention"><a>❤</a>
                   <div id="div_attention">我的关注</div>
               </li>
               <li id="a_collection"><a>★</a>
                   <div id="div_collection">我的收藏</div>
              </li>
           </ul>
         </div> 
         
         <div id="main_menu_show">
         
         </div>
         
    </div>
  </body>
</html>
