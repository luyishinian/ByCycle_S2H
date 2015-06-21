document.charset="UTF-8";
$(document).ready(function(){
	$(".nav_left_menu").each(function(){
		$(this).click(function(){
			var i = $(this).index();
			
			$(".nav_left_menu").not(this).css({"color":"#6E6E6E"});
			$(this).css({"color":"white"});
			$(".main_div").not(".main_div:eq("+i+")").css("display","none");
		    $(".main_div:eq("+i+")").show(300);

		});
	});
	$(".manager_name").click(function(){
		$("#manager_menu").toggle(300);
	});
    $("a.exit").click(function(){
		
		document.location.href = "index.jsp";
		
	});
    
   $("button.delete_user").click(function(){
		
	   var params = {
			  
			   id:$(this).parent().children(":first").attr("value")
			  };
	   
	   $.ajax({
		   url: "deleteuser.action",
		   type:"post",           
		   dataType:"json",
		   data: params,
		   
		  
		 });
	   $(this).parent().hide(500);
	   //$(this).parent().animate({display:"none"},"slow");
		
	});
   
   
   $("button.update_cycle").live("click",function(){
	   $(this).parent().children(":last").show(500);
	   
	   $("#Mask_div").show(250);
	   
   });
   
   $("button.back_cycle").live("click",function(){
	   $(this).parent().hide(500);
	   $("#Mask_div").hide(1000);
	   
   });
   
   
   $("input.file").change(function(){
              var odiv_file = document.getElementById("file_pic");
	          var pic_URL =  window.URL.createObjectURL(odiv_file.files[0]);
	          $(this).parent().parent().children(":first").attr("src",pic_URL);
	          
		});


	    

   $("button.delete_cycle").live("click",function(){
	   var deletecycle = {
				 id:$(this).parent().children(":first").attr("value")
			  };
	   
	   $.ajax({
		   url: "deletecycle.action",
		   type:"post",           
		   dataType:"json",
		   data: deletecycle,
		   
		  
		 });
	   $(this).parent().css("display","none");
	   //$(this).parent().animate({display:"none"},"slow");
	   
   });
  $("button.save_cycle").live("click",function(){
	  var id;
	  var c_img_val;
	  var c_title_val;
	  var c_message_val;
	  var c_address_val;
	  var c_count_val;
	  var c_collect_val;
	  var c_price_val;
	  
	  var picform=$('<form action="changepic.action" method="post" enctype="multipart/form-data"></form>');
	  var cycleid = $('<input type="hidden" name="id" />');
	  cycleid.val($(this).parent().children(".c_id").attr("value"));
	  picform.append(cycleid);  
	  //var $cyclepic= $(this).parent().children(".file_span").children(".file").clone();
	  //picform.append($cyclepic);
	  picform.append($(this).parent().children(".file_span").children(".file"));
	  var options = {
			   // dataType : "json",
			  
			    
	        };
	 
	  picform.ajaxSubmit(options);
	  
	   var cycle = {
			   
			   id:$(this).parent().children(".c_id").attr("value"),
			   title:$(this).parent().children(".input_title_change").attr("value"),
			   message:$(this).parent().children(".input_message_change").attr("value"),
			   address:$(this).parent().children(".input_address_change").attr("value"),
			   count:$(this).parent().children(".input_count_change").attr("value"),
			   price:parseFloat($(this).parent().children(".input_price_change").attr("value")),
			   uploadFile:$(this).parent().children(".file_span").children(".file").attr("value")
	   };
	   
	   $.ajax({
		   async:false,
		   url: "changecycle.action",
		   type:"post",  
		   
		   dataType:"json",
		   data: cycle,
		   success:   function(cycleMap){
			      json = eval(cycleMap.cycle);
			      id = json.id;
			      c_title_val = json.c_name;
			      c_img_val = json.c_img;
			      c_message_val = json.c_message;
			      c_address_val = json.c_address;
			      c_collect_val= json.c_collect;
			      c_count_val = json.c_count;
			      c_price_val = json.c_price;
			      
			      //alert(json.id);
			      //alert($.param(dataMap.new_cycle));
			      
			   }
		  
		  
		 });
	     
		  
	   $(this).parent().children(".c_id").val(id);
	   $(this).parent().parent().children("img.c_img").attr("src",c_img_val);
	   $(this).parent().parent().children("label.c_message").text(c_message_val); 
	   $(this).parent().parent().children("label.c_title").text(c_title_val);
	   $(this).parent().parent().children("label.c_address").text("地址："+c_address_val);
	   $(this).parent().parent().children("label.c_count").text("数量："+c_count_val);
	   $(this).parent().parent().children("label.c_price").text("价格："+c_price_val);
	   
	   $(this).parent().hide(500);
	   $("#Mask_div").hide(1000);
	   
	   
		
	});
  
  $("button.add_cycle").live("click",function(){
	   $("div.add_cycle_div").show(500);
	   
	   $("#Mask_div").show(250);
	   
  });
  
  $("button.add_div_back").live("click",function(){
	  $("div.add_cycle_div").hide(500);
	  $("#Mask_div").hide(1000);
	 
  });
  $("button.create_cycle").click(function(){
	  var id;
	  var c_title_val;
	  var c_message_val;
	  var c_address_val;
	  var c_count_val;
	  var c_collect_val;
	  var c_price_val;
	  
	 
	  
	  
	  var new_cycle = {
			   title:$(this).parent().children(".new_title_input").attr("value"),
			   message:$(this).parent().children(".new_message_input").attr("value"),
			   address:$(this).parent().children(".new_address_input").attr("value"),
			   count:$(this).parent().children(".new_count_input").attr("value"),
			   price:$(this).parent().children(".new_price_input").attr("value")
			   
			   
	   };
	  $.ajax({
		   async:false,
		   url: "createcycle.action",
		   type:"post",           
		   dataType:"json",
		   data: new_cycle,
		   success:   function(dataMap){
			      json = eval(dataMap.new_cycle);
			      id = json.id;
			      c_title_val = json.c_name;
			      c_message_val = json.c_message;
			      c_address_val = json.c_address;
			      c_collect_val= json.c_collect;
			      c_count_val = json.c_count;
			      c_price_val = json.c_price;
			      
			      //alert(json.id);
			      //alert($.param(dataMap.new_cycle));
			      
			   }
		  
		 });
	  //alert(id);
	  //alert(c_title_val);
	  //alert(c_message_val);
	  //alert(c_address_val);
	  //alert(c_collect_val);
	  //alert(c_count_val);
	  //alert(c_price_val);
	  
	  
	  $("div.add_cycle_div").hide(500);
	  $("#Mask_div").hide(1000);
	  var parentDiv=$('<div></div>');
	       parentDiv.addClass('cycle_manager');
	  
	  var c_id = $('<input type="hidden"  name="id" />');
	      c_id.val(id);
	        c_id.appendTo(parentDiv);
	  var c_img =$('<img>');
	       c_img.attr("src","img/cycle.jpg");
	         c_img.appendTo(parentDiv);
	         
	  var c_title=$('<label class="c_title"></label>');
	       c_title.text(c_title_val);
	           c_title.appendTo(parentDiv);
	           
	  var c_message=$('<label class="c_message"></label>');
	        c_message.text(c_message_val);
	            c_message.appendTo(parentDiv);
	  var c_address=$('<label class="c_address"></label>');
	        c_address.text("地址："+c_address_val);
	            c_address.appendTo(parentDiv);
	  var c_count=$('<label class="c_count"></label>');
	        c_count.text("数量："+c_count_val);
	            c_count.appendTo(parentDiv);
	 
	 var c_collect=$('<label class="c_collect"></label>');
		        c_collect.text("数量："+c_collect_val);
		            c_collect.appendTo(parentDiv);          
	  var c_price=$('<label class="c_price"></label>');
	        c_price.text("价格："+c_price_val);
	            c_price.appendTo(parentDiv);
	  var add_message_pic =$('<button class="add_message_pic">查看描述图片</button>');
	        add_message_pic.appendTo(parentDiv);
	  var update_cycle =$('<button class="update_cycle">修改信息</button>');
	      update_cycle.addClass('update_cycle');
	        update_cycle.appendTo(parentDiv);
	  var delete_cycle =$('<button class="delete_cycle">删除</button>');
	        delete_cycle.appendTo(parentDiv);
	   
	  var update_cycle_div =$('<div class="update_cycle_div">');
	        var c_img = $('<img class="c_img" />');
	            c_img.attr("src","img/cycle.jpg");
	              c_img.appendTo(update_cycle_div);
	        var c_id =  $('<input class="c_id" type="hidden" >');   
	            c_id.val(id);
	              c_id.appendTo(update_cycle_div);
	              
	        var file_span = $('<span class="file_span">修改图片</span>');
	            var file = $('<input type="file" class="file" id="file_pic" accept="image/jpeg" name="uploadFile" onchange="showpic(this)" >');
	                  file.appendTo(file_span);
	              file_span.appendTo(update_cycle_div);
	              
	        var c_title_change = $('<label class="c_title_change">Title:</label>');
	               c_title_change.appendTo(update_cycle_div);
	        var c_message_change = $('<label class="c_message_change">Message:</label>');
	               c_message_change.appendTo(update_cycle_div);
	        var c_address_change = $('<label class="c_address_change">Address:</label>');
	               c_address_change.appendTo(update_cycle_div);
	        var c_count_change = $('<label class="c_count_change">Count:</label>');
	               c_count_change.appendTo(update_cycle_div);
	        var c_price_change = $('<label class="c_price_change">Price:</label>');
	               c_price_change.appendTo(update_cycle_div);
	               
	        var input_title_change = $('<textarea class="input_title_change" ></textarea>');
	               input_title_change.text(c_title_val);
	               input_title_change.appendTo(update_cycle_div);
	        var input_message_change = $('<textarea class="input_message_change" ></textarea>');
	               input_message_change.text(c_message_val);
	               input_message_change.appendTo(update_cycle_div); 
	        var input_address_change = $('<input class="input_address_change" />');
	               input_address_change.val(c_address_val);
	               input_address_change.appendTo(update_cycle_div); 
	        var input_count_change = $('<input class="input_count_change" />');
	               input_count_change.val(c_count_val);
	               input_count_change.appendTo(update_cycle_div); 
	        var input_price_change = $('<input class="input_price_change" />');
	               input_price_change.val(c_price_val);
	               input_price_change.appendTo(update_cycle_div); 
	               
	        var save_cycle =$('<button class="save_cycle">Save</button>');
	               save_cycle.appendTo(update_cycle_div); 
	               
	        var back_cycle =$('<button class="back_cycle">Back</button>');
	               back_cycle.appendTo(update_cycle_div);
	        
	        
	        
	        update_cycle_div.appendTo(parentDiv);
	  
	  $(this).parent().parent().children(":first").before(parentDiv);
	 
  });
    
    
    
});



