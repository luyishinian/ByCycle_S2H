<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/regist.css">
	

  </head>
  
  <body>
    <div id="regist_div">
         <form action="testregist.action" method="post">
             <img class="title_pic" src="img/cycle.jpg">
             <label class="title_sign"> __ByCycle</label>
             <hr>
             <p class="sign_text">Username</p>
             <input type="text" class="text" name="username">
             <p class="sign_text">Password</p>
             <input type="password" class="text" name="password">
             <p class="sign_text">ComfirePWD</p>
             <input type="password" class="text" name="password2">
             <input type="submit" class="regist" value="Regist">
         </form>
    </div>
    <img id="title_pic" src="img/cycle.jpg">
    <p id="title_sign"> __ByCycle</p>
    <form action="testregist.action" method="post">
         <div id="user_div"> 
              <p class="sign_text">Username</p>
              <input type="text" class="text" name="username">
         </div>
         
         <div id="psd_div"> 
              <p class="sign_text">Password</p>
              <input type="password" class="text" name="password">
              <p class="sign_text">ComfirePWD</p>
              <input type="password" class="text" name="password2">
         </div>
         
         <div id="rgt_div"> 
              <input type="submit" class="regist" value="Regist">
         </div>
    </form>
    
    <p id="sign_a">Are you ready?</p>
    <p id="sign_b">Let't Go!</p>
  </body>
</html>
