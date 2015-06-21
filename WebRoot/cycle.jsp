<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.wjf.dao.*" %>
    
    <%@ page import="com.wjf.bean.*" %>
    <%@ page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cycle.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/slide_menu.css">
	<script type="text/javascript" src="jquery/jquery.min.js"></script>
	<script type="text/javascript" src="jquery/right_menu_show.js"></script>
	<script type="text/javascript" src="jquery/right_menu.js"></script>
	<link rel="stylesheet" type="text/css" href="css/top.css">
	<link rel="stylesheet" type="text/css" href="css/cycle.css">
	<script type="text/javascript" src="jquery/Main_to_person.js"></script>
	<script type="text/javascript" src="jquery/cycle.js"></script>
	

  </head>
  
  <body>
       <% 
    Cycle cycle=(Cycle)request.getAttribute("c_show"); 
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
      
     <div id="shop_message">
     
     </div>
     
     <div id="main">
       <form action="shoppingcart.action" method="post">
         <div id="cycle_show">
             <div class="cycle_img">
                <div class="big_img">
                   <img id="show_big_img" src=<%=cycle.getC_img() %>>
                </div>
                
                <div class="small_img">
                  <% for(int i =0 ;i<6 ;i++) {%>
                   <img  src="img/cycle.jpg" onclick="small_to_big(this)">
                   <% } %>
                  
                </div>
                
                <div class="cycle_collect">
                    <label class="lb_share">分享</label>
                    <label class="lb_collect">收藏商品</label>
                    <label class="lb_report">举报</label>
                    
                
                </div>
             </div>
             
             <div class="cycle_word">
                 <div class="cycle_message">
                     <label class="lb_a"><%=cycle.getC_name() %></label>
                     <label class="lb_b">恋爱时节，相约校园</label>
                 </div>
                 
                 <div class="cycle_price">
                     <label class="old_price">原价   ￥118</label>
                     <label class="new_price">促销价<a><%=cycle.getC_price() %></a></label>
                     
                 
                 </div>
                 
                 <div class="cycle_freight">
                     <label class="lb_sign">运费</label>
                     <label class="freight"><%=cycle.getC_address() %>至______ 自提:0.00元 推送费:1.00元</label>
                 
                 </div>
                 
                 <div class="cycle_volume">
                     <ul>
                        <li><a>月销量</a></li>
                        <li><a>累计评价</a></li>
                        <li><a>送天猫积分</a></li>
                     </ul>
                 
                 </div>
                 
                 <div class="cycle_color">
                         
                 </div>
                 
                 
                 
                 <div class="cycle_count">
                       <label class="lb_count_sign">数量</label>
                       <input type="text" id="count" value="1" name="count">
                       <label class="lb_count">库存<%=cycle.getC_count() %>件</label>
                 </div>
                 
                 <div class="cycle_service">
                       <label class="lb_a">服务承诺</label>
                       <label class="lb_b">无忧退换货</label>
                       
                 </div>
                 
                 <div class="cycle_bt">
                       <input type="hidden" id="shop_img"   value=<%=cycle.getC_img() %>    name="shop_img">
                       <input type="hidden" id="shop_price" value=<%=cycle.getC_price() %>  name="shop_price">
                       <input type="hidden" id="u_id"       value=<%=user.getId() %>        name="u_id">
                       <input type="hidden" id="c_id"       value=<%=cycle.getId() %>       name="c_id">
                       <input type="submit" value="立即购买" class="input_buy">
                       <input type="button" value="加入购物车" class="input_buycar" onclick="intoShopcart()">
                 </div>
                 
                 <div class="cycle_way">
                     <label class="lb_payway">支付方式</label>
                 </div>
                 
                 
                
             
             </div>
             
            
         </div>
         </form>
         
         <div id="other_cycle">
             
         </div>
         
         <div id="cycle_message">
         
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
                     <% ArrayList<U_C_Shopcart> user_shopcart = (ArrayList<U_C_Shopcart>)session.getAttribute("shopcart");
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
   
   
  </body>
</html>
