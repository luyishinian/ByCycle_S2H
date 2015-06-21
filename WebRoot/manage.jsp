<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.wjf.dao.*" %>
    
    <%@ page import="com.wjf.bean.*" %>
    <%@ page import="java.util.ArrayList" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/manage.css">
	<script type="text/javascript" src="jquery/jquery.min.js"></script>
	<script type="text/javascript" src="jquery/jquery.form.js"></script>
    <script type="text/javascript" src="jquery/manage.js"  charset="UTF-8"></script>
     
  </head>
  
  <body>
      <% 
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
    Manage manage=(Manage)session.getAttribute("manage"); 
%> 
    <div id="manager_div">
       <label class="manager_name"><a><%=manage.getM_name() %></a></label>
       <div id="manager_menu">
            <a class="message">查看</a>
            <a class="exit">退出</a>
       </div>
    </div>
    <div id="top">
    
    </div>
    
    <div id="center">
         <div id="left_menu">
                 
                     <a class="nav_left_menu">用户管理</a>
                     <a class="nav_left_menu">订单管理</a>
                     <a class="nav_left_menu">商品管理</a>
                     <a class="nav_left_menu">故事管理</a>
                     <a class="nav_left_menu">图片管理</a>
                 
         </div>
         <div id="main" >
              <div class="main_div">
              <label class="manage_sign">用户管理</label>
                <% 
                 List<User> all_user  =(List<User>)session.getAttribute("all_user"); 
                    for(int i = all_user.size()-1 ;i>=0;i--){
                       User user = all_user.get(i);
                    %> 
                    
                   <div class="admin_user">
                        <input type="hidden" value=<%=user.getId() %> id="user_id" name="id">
                        <img src=<%=user.getU_img() %>>
                        
                        <label class="name"><%=user.getU_name() %></label>
                        <label class="sex"><%=user.getU_sex() %></label>
                        <label class="birth">birth:<%=df.format(user.getU_birth()) %></label>
                        <label class="login_time">最近登陆时间：<%=user.getU_lastlogin_time() %></label>
                        <label class="regist_time">用户注册时间：<%=user.getU_regist_time() %></label>
                        <button class="look_order">查看购物记录</button>
                        <button class="delete_user">删除</button>
                   </div> 
                    
                   <%} %>                             
              </div>
              
              <div class="main_div">
                  <label class="manage_sign">订单管理</label>
              </div>
              
              <div class="main_div">
                <label class="manage_sign">商品管理</label>
                 <% 
                 List<Cycle> all_cycle  =(List<Cycle>)session.getAttribute("all_cycle"); 
                    for(int i = all_cycle.size()-1 ;i>=0;i--){
                       Cycle cycle = all_cycle.get(i);
                    %> 
                   <div class="cycle_manager">
                        <input type="hidden" value=<%=cycle.getId() %>  name="id">
                        <img class="c_img" src=<%=cycle.getC_img() %>>
                        <label class="c_title"><%=cycle.getC_name() %></label>
                        <label class="c_message"><%=cycle.getC_message() %></label>
                        <label class="c_address">地址：<%=cycle.getC_address() %></label>
                        <label class="c_count">数量：<%=cycle.getC_count() %></label>
                        <label class="c_collect">收藏：<%=cycle.getC_collect() %></label>
                        <label class="c_price">价格：<%=cycle.getC_price() %></label>
                        <button class="add_message_pic">查看描述图片</button>
                        <button class="update_cycle">修改信息</button>
                        <button class="delete_cycle">删除</button>
                        <div class="update_cycle_div">
                            <img class="c_img" src=<%=cycle.getC_img() %>>
                            <input class="c_id" type="hidden" value=<%=cycle.getId() %>>
                            <span class="file_span">
                            <input type="file" class="file" id="file_pic" accept="image/jpeg" name="uploadFile"  >修改图片</span>
                            <label class="c_title_change">Title:</label>
                            <label class="c_message_change">Message:</label>
                            <label class="c_address_change">Address:</label>
                            <label class="c_count_change">Count:</label>
                            <label class="c_price_change">Price:</label>
                            <textarea class="input_title_change" ><%=cycle.getC_name() %></textarea>
                            <textarea class="input_message_change" ><%=cycle.getC_message() %></textarea>
                            <input type="text" class="input_address_change" value=<%=cycle.getC_address() %>>
                            <input type="text" class="input_count_change" value=<%=cycle.getC_count() %>>
                            <input type="text" class="input_price_change" value=<%=cycle.getC_price() %>>
                            <button class="save_cycle">Save</button>
                            <button class="back_cycle">Back</button>
                        </div>
                   </div>
                   <%} %>
                   <button class="add_cycle">添加商品</button>
                    <div id="Mask_div">
        
                   </div>
                   
                   <div class="add_cycle_div">
                      <div class="new_cycle_img_div">
                         <img class="new_cycle_img">
                       </div>
                       <button class="add_new_cycle_img">添加图片</button>
                       <label class="new_title_label">标题：</label>
                       <label class="new_message_label">描述：</label>
                       <label class="new_address_label">地址：</label>
                       <label class="new_count_label">数量：</label>
                       <label class="new_price_label">价格：</label>
                       <textarea class="new_title_input"></textarea>
                       <textarea class="new_message_input"></textarea>
                       <input type="text" class="new_address_input">
                       <input type="text" class="new_count_input">
                       <input type="text" class="new_price_input">
                       <button class="create_cycle">添加</button>
                       <button class="add_div_back">返回</button>
                   </div>
              </div>
              
              <div class="main_div">
                   <label class="manage_sign">故事管理</label>
                                                  
              </div>
              
              <div class="main_div">
                  <label class="manage_sign">图片管理</label>
              </div>
         </div>
    </div>
  </body>
</html>
