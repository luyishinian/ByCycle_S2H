<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manage_login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/manage_login.css">
	<script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/manage_login.js"></script>

  </head>
  
  <body>
     <form action="testmanage.action" method="post">
      <div id="login_div">
           <div class="top_div">
              <label>Maneger Login</label>
           </div>
           <div class="name_div">
               <label class="label_text">Manger:</label>
               <input type="text" class="input_text" name="manage">
           </div>
           
           <div class="pwd_div">
               <label class="label_text">Password:</label>
               <input type="password" class="input_text" name="password">
           </div>
           
           <div class="sumb_div">
               <input type="submit" value="Login" class="input_sumbit">
           </div>
      </div>
      </form>
  </body>
</html>
