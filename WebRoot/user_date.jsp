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
    
    <title>My JSP 'user_date.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/slide_menu.css">
	<link rel="stylesheet" type="text/css" href="css/user_date.css">
	<script type="text/javascript" src="jquery/jquery.min.js"></script>
	<script type="text/javascript" src="jquery/right_menu.js"></script>
	<script type="text/javascript" src="jquery/right_menu_show.js"></script>
    <script type="text/javascript" src="jquery/user_date.js"></script>
  </head>
  
  <body>
  <%
   
    User user=(User)session.getAttribute("login");
  %> 
     <div id="top_div">
     
     </div>
    <div id="user_date">
      <form action="changemessage.action" method="post" enctype="multipart/form-data">
       <img class="buffer">
       <img class="u_img" src=<%=user.getU_img() %>>
       <span class="file_span">
       <input type="file" class="file" id="file_pic" accept="image/jpeg" name="uploadFile" onchange="showpic()" >修改图片</span>
       
       <div class="div_uppic">
          
          <img id="change_u_img" >
          <a class="remove">取     消</a>
          <a class="confirm">确     定</a>
       </div>
       
       <div class="Message">
          <p class="text_sign"> 用户名</p>
          <input type="text" class="text_input" name="username" value=<%=user.getU_name() %>>
          <p class="text_sign"> 性别</p>
          <input type="text" class="text_input" name="usersex" value=<%=user.getU_sex() %>>
          <p class="text_sign"> 生日</p>
          <input type="text" class="text_input" name="userbirth" value=<%=user.getU_birth() %>> 
          <input type="hidden" name="userID" value=<%=user.getId() %>>      
       </div>
       
       <input type="submit" value="提交" class="submit">
       
       </form>
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
