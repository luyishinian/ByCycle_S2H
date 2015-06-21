
function small_to_big(s_img){
	var pic_URL = s_img.src;
	$("#show_big_img").attr("src",pic_URL);
	
	
}
function intoShopcart(){
	
     var params = {
             u_id:$("#u_id").attr("value"),
             c_id:$("#c_id").attr("value"),
             count:$("#count").attr("value"),
             shop_img:$("#shop_img").attr("value"),
             shop_price:$("#shop_price").attr("value")
                  };

     $.ajax({
             url: "shoppingcart.action",
             type:"post",           
             dataType:"json",
             data: params,
             success:   function(dataMap){
            	 json = eval(dataMap.new_shopcart);
            	 id = json.id;
            	 c_id = json.c_id;
            	 img = json.shop_img;
            	 shop_count = json.shop_count;
            	 shop_price = parseFloat(json.shop_price);
            	 
            	 $("#main_right").animate({width:'235px'},500);
            	    $("#main_menu_show").show(500);
            	    
            	    var parentDiv=$('<div></div>');
            	    parentDiv.addClass('user_cycle');
            	        var message = $('<label class="message">这里是商品的信息</label>');
            	        message.appendTo(parentDiv);
            	        var check = $('<input class="check" type="checkbox" value="" name ="chkItem" />');
            	        check.appendTo(parentDiv);
            	        var shopcart_cid = $('<input type="hidden" class="shopcart_cid" name="c_id"  />');
            	        shopcart_cid.val(c_id);
            	        shopcart_cid.appendTo(parentDiv);
            	        var shopcart_id = $('<input type="hidden" class="shopcart_id" name="id"  />');
            	        shopcart_id.val(id);
            	        shopcart_id.appendTo(parentDiv);
            	        var cycle_img = $('<img  class="cycle_img" />');
            	        cycle_img.attr("src",img);
            	        cycle_img.appendTo(parentDiv);
            	        var count = $('<label class="count"></label>');
            	        count.text(shop_count);
            	        count.appendTo(parentDiv);
            	        var price = $('<label class="price" ></label>');
            	        price.text(shop_price);
            	        price.appendTo(parentDiv);
            	        var delete_cart = $('<button class="delete_cart">X</button>');
            	        delete_cart.appendTo(parentDiv);
            	        
            	    $("div.center").children(":first").before(parentDiv);
            	 
             }
 
          });
     
    
	

}

