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
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/slide_menu.css">
	<link rel="stylesheet" type="text/css" href="css/main_login.css">
	<link rel="stylesheet" type="text/css" href="css/top.css">
	<script type="text/javascript" src="jquery/jquery.min.js"></script> 
	<script type="text/javascript" src="jquery/change_pic.js"></script> 
	<script type="text/javascript" src="jquery/jquery.tiltShift.js"></script>
    <script type="text/javascript" src="jquery/buffpic.js"></script>
    <script type="text/javascript" src="jquery/right_menu.js"></script>
    <script type="text/javascript" src="jquery/change_menu.js"></script>
    <script type="text/javascript" src="jquery/main_img.js"></script>
    <script type="text/javascript" src="jquery/login.js"></script>
    <script type="text/javascript" src="jquery/right_menu_show.js"></script>
    <script type="text/javascript" src="jquery/Main_to_person.js"></script>
    <script type="text/javascript" src="jquery/Main_to_cycle.js"></script>
  </head>
    
  <body>
    <% 
    User user=(User)session.getAttribute("login"); 
%> 
        <div id="user_div">
          
        <img id="u_img" src=<%=user.getU_img() %> target="_blank">
        
           <label id="username"><a><%=user.getU_name() %></a></label>
             <div id="user_menu">
             <a id="user_look" target="_blank">查看</a>
             <a id="user_out">退出</a>
           </div>
             
           
        <a id="about_us">关于我们？ </a>
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
             <li class="main_menu" style="color: white; background-color:#C40000;"><a>Main</a></li>
             <li class="main_menu"><a>Order Bike</a></li>
             <li class="main_menu"><a>New Know</a></li>
             <li class="main_menu"><a>Mine Bike</a></li>
             <li class="main_menu"><a>Cycle Story</a></li>
          </ul>    
    </div>
   
            
            
    <div id="main_center">
           	<div id="Main" class="main_content" style="display: block;">
           	
           	     <p class="left_sign">In My Time</p>
           	     <p class="right_sign">So I Try</p>
           	     <a id="img0" class="main_img"><img id="img_0"  src="img/example1.jpg"></a>
           	     <a id="img1" class="main_img"><img id="img_1" src="img/example2.jpg"></a>
           	     <a id="img2" class="main_img"><img id="img_2" src="img/example3.jpg"></a>
           	     <a id="img3" class="main_img"><img id="img_3" src="img/example4.jpg"></a>
           	     <a id="img4" class="main_img"><img id="img_4" src="img/example1.jpg"></a>
           	     <a id="img5" class="main_img"><img id="img_5" src="img/example2.jpg"></a>
           	     <a id="img6" class="main_img"><img id="img_6" src="img/example3.jpg"></a>
           	     <a id="img7" class="main_img"><img id="img_7" src="img/example4.jpg"></a>
           	</div>
           	<div id="Order" class="main_content">
           	     <div id="search_div">
           	         <form>
           	             <input type="text" class="input_text">
           	             <input type="submit" class="search_bt" value="Search">
           	         </form>
           	     </div>
           	     <% 
           	List<Cycle> all_cycle = (List<Cycle>)session.getAttribute("cycle");
           	  for(int i =all_cycle.size()-1; i>=0 ;i--) {
           	      Cycle cycle = all_cycle.get(i);
           	          %>
           	     
           	     <div class="cycle" >
           	         <img src=<%=cycle.getC_img() %> class="cycle_view">
           	         
           	         <label class="cycle_price">￥<%=cycle.getC_price() %></label>
           	         <label class="cycle_payed">付款</label>
           	         
           	         <a href="testcycle.action?id=<%=cycle.getId() %>"><%=cycle.getC_name() %></a>
           	         <label class="cycle_shop">齐大车行</label>
           	         <label class="cycle_address">齐大2号楼</label>
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
         
         <div id="main_menu_show">
             <div class="user_shopcart">
                  <div class="top">
                       <input type="checkbox" class="all_check" value=""><label >全选</label>
                  </div>
                  
                  <div class="center">
                     <% List<U_C_Shopcart> user_shopcart = (List<U_C_Shopcart>)session.getAttribute("shopcart");
           	             for(int i =user_shopcart.size()-1; i>=0 ;i--) {
           	                U_C_Shopcart u_shop = user_shopcart.get(i);%>
                        <div class="user_cycle">
                           <label class="message">这里是商品的信息</label>
                           <input class="check" type="checkbox" value="" name ="chkItem" >
                           <input type="hidden" class="shopcart_cid" name="c_id" value=<%=u_shop.getC_id() %>>
                           <input type="hidden" class="shopcart_id" name="id" value=<%=u_shop.getId() %>>
                           <img  class="cycle_img" src=<%=u_shop.getShop_img() %>>
                           <label class="count"><%=u_shop.getShop_count() %></label>
                           <label class="price" ><%=u_shop.getShop_price() %></label>
                           <button class="delete_cart">X</button>
                        </div>
                        <%} %>
                  </div>
                  
                  <div class="bottom">
                       <label class="hascollect">已选择<a>0</a>件</label>
                       <label class="all_price">￥<a>0.00</a></label>
                       <button class="sumbit">结算</button>
                  </div>
             </div>
         
         </div>
    </div>
    
         
         
   
   
   
    <div id="bottom_div">
            <p>@2015 ByCycle  <a>使用必读</a> <a>意见反馈</a> 齐齐哈尔ICP证030173号</p>
            
    </div>
  </body>
</html>
