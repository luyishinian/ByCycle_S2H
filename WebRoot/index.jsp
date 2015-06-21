<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My ByCycle</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/slide_menu.css">
	<script type="text/javascript" src="jquery/jquery.min.js"></script> 
	<script type="text/javascript" src="jquery/change_pic.js"></script> 
	<script type="text/javascript" src="jquery/jquery.tiltShift.js"></script>
    <script type="text/javascript" src="jquery/buffpic.js"></script>
    <script type="text/javascript" src="jquery/right_menu.js"></script>
    <script type="text/javascript" src="jquery/change_menu.js"></script>
    <script type="text/javascript" src="jquery/main_img.js"></script>
    <script type="text/javascript" src="jquery/login.js"></script>
  </head>
  
  <body>
     
        <% session.invalidate(); %> 
    
        <div id="user_div">
        <button id="Manage">管理员 </button>
        <button id="login">登陆 </button>
        <button id="regist">注册 </button>
        <a id="about_us">关于我们？ </a>
    
    </div>
         
         
    
    <div id="login_div">
        <div id="login_top_div">
             <img class="title_pic" src="img/cycle.jpg">
             <label class="title_sign"> __ByCycle</label>
             <button id="login_off">X</button>
        </div>
        <div id="login_main_div">
            <form action="testlogin.action" method="post">
                 <p class="sign_text">Username</p>
                 <input type="text" class="text" name="username">
                 <p class="sign_text">Password</p>
                 <input type="password" class="text" name="password">
                 <input type="submit" class="login_submit" value="Login">
                 <p class="regist">不是会员？<a id="login_to_regist">现在注册</a></p>
        </form>
      </div>
      <div id="login_other_div">
            <label class="other_login_sign1">Other </label>
            <label class="other_login_sign2">login way.....</label>
            <div id="other_title">
               <a><img src="img/login_renren.jpg"></a>
               <a><img src="img/login_sina.jpg"></a>
               <a><img src="img/login_taobao.jpg"></a>
               <a><img src="img/login_weixin.jpg"></a>
               <a><img src="img/login_facebook.jpg"></a>
               <a><img src="img/login_tuite.jpg"></a>
             </div>
      </div>
    </div>
    <div id="Mask_div">
        
    </div>
    <div id="top_div">
       <img class="img" src="img/top_cycle.jpg" style="display:block;" >
       <img class="img" src="img/top_cycle2.jpg">
       <img class="img" src="img/top_cycle3.jpg">
       <img class="img" src="img/top_cycle4.jpg">
       <div id="change_pic">
           <button class="bt_pic">1</button>
           <button class="bt_pic">2</button>
           <button class="bt_pic">3</button>
           <button class="bt_pic">4</button>
           
       </div>
    </div>
    <div id="menu_div">
          <p class="point">▲</p>
          <ul>
             <li class="main_menu"><a>Main</a></li>
             <li class="main_menu" style="color: white; background-color:#C40000;"><a>Order Bike</a></li>
             <li class="main_menu"><a>New Know</a></li>
             <li class="main_menu"><a>Mine Bike</a></li>
             <li class="main_menu"><a>Cycle Story</a></li>
          </ul>    
    </div>
   
            
            
    <div id="main_center">
    
           	<div id="Main" class="main_content" >
           	     <p class="left_sign">In My Time</p>
           	     <p class="right_sign">So I Try</p>
           	     
           	     <a id="img0" class="main_img"><img id="img_0" src="img/example1.jpg"></a>
           	     <a id="img1" class="main_img"><img id="img_1" src="img/example2.jpg"></a>
              	 <a id="img2" class="main_img"><img id="img_2" src="img/example3.jpg"></a>
            	 <a id="img3" class="main_img"><img id="img_3" src="img/example4.jpg"></a>
              	 <a id="img4" class="main_img"><img id="img_4" src="img/example1.jpg"></a>
             	 <a id="img5" class="main_img"><img id="img_5" src="img/example2.jpg"></a>
           	     <a id="img6" class="main_img"><img id="img_6" src="img/example3.jpg"></a>
           	     <a id="img7" class="main_img"><img id="img_7" src="img/example4.jpg"></a>
           	</div>
           	
           	<div id="Order" class="main_content" style="display: block;">
           	     <div id="search_div">
           	         <form>
           	             <input type="text" class="input_text">
           	             <input type="submit" class="search_bt" value="Search">
           	         </form>
           	     </div>
           	     <% for(int i = 1; i <= 6 ;i++) { %>
           	     <div class="cycle">
           	         <img src="img/top_cycle.jpg" class="cycle_view">
           	         <a>豪华双人自行车学生车情侣自行车校园自行车爱情邂逅</a>
           	     </div>
           	     <% } %>
           	     
           	
           	
           	</div>
           	<div id="New" class="main_content">
           	New Know
           	</div>
           	<div id="Mine" class="main_content">
           	Mine Bike
           	</div>
           	<div id="Story" class="main_content">
           	Cycle Story
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
    </div>
    
         
         
   
   
   
    <div id="bottom_div">
            <p>@2015 ByCycle  <a>使用必读</a> <a>意见反馈</a> 齐齐哈尔ICP证030173号</p>
            
    </div>
  </body>
</html>
