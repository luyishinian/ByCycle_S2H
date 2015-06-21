//用户登陆后的 侧边栏的展开
document.charset="UTF-8";
$(document).ready(function(){
	
	
	$("#main_menu ul li").click(function(){
		var demo = $("#main_right");
		if( demo.width()< 235 ){
		   $("#main_right").animate({width:'235px'},500);
		   $("#main_menu_show").show(500);
		}
		else{
		   $("#main_right").animate({width:'35px'},500);
		   $("#main_menu_show").hide(500);
		}
		});
	
	$("#right_shop").click(function(){
		var demo = $("#main_right");
		if( demo.width()< 235 ){
		   $("#main_right").animate({width:'235px'},500);
		   $("#main_menu_show").show(500);
		  
		}
		else{
		   $("#main_right").animate({width:'35px'},500);
		   $("#main_menu_show").hide(500);
		}
		});
	$("div.user_cycle").live("mouseover",function(){
		$(this).children(".delete_cart").show(500);
		
	});
	$("div.user_cycle").live("mouseleave",function(){
		$(this).children(".delete_cart").hide(500);
		
	});
	
	$("input.all_check").live("click",function(){
		 var count = 0;
		 var price = 0.0;
		if($(this).attr("checked")==true){
		      $("[name = chkItem]:checkbox").attr("checked", true);
		      $("input[name='chkItem']").each(function(){
			
			      count = count + parseInt($(this).parent().children(".count").text());
			      price = parseFloat(price)+parseFloat($(this).parent().children(".count").text())*parseFloat($(this).parent().children(".price").text());
		       });
		       //alert($("input[name='chkItem']").length);
		       //alert($("input[name='chkItem']:checked").length);
		       $("label.hascollect a").text(count);
		       $("label.all_price a").text(price);
		       
		    	
		    
		}
		else{
			$("[name = chkItem]:checkbox").attr("checked", false);
		    $("label.hascollect a").text("0");
		    $("label.all_price a").text("0.00");
		}
		
	});
	$("[name = chkItem]:checkbox").live("click",function(){
		
		if($(this).attr("checked")==true){
			//alert($("input[name='chkItem']").length);
		    //alert($("input[name='chkItem']:checked").length);
		    if($("input[name='chkItem']").length == $("input[name='chkItem']:checked").length){
		       $("input.all_check").attr("checked", true);
		    }
			count =parseInt($("label.hascollect a").text())+parseInt($(this).parent().children(".count").text());
			price =parseFloat($("label.all_price a").text())+parseFloat($(this).parent().children(".price").text());
			$("label.hascollect a").text(count);
			$("label.all_price a").text(price);
		}
		else{
			if($("input[name='chkItem']").length > $("input[name='chkItem']:checked").length){
			       $("input.all_check").attr("checked", false);
			    }
			count =parseInt($("label.hascollect a").text())-parseInt($(this).parent().children(".count").text());
			price =parseFloat($("label.all_price a").text())-parseFloat($(this).parent().children(".price").text());
			$("label.hascollect a").text(count);
			$("label.all_price a").text(price);
		}
	});
	
	$("button.delete_cart").live("click",function(){
		var shopcart = {
				id:$(this).parent().children(".shopcart_id").attr("value")
		};
		$.ajax({
			url:"deleteshopcart.action",
			type:"post",
			dataType:"json",
			data:shopcart
		});
		
		if($(this).parent().children(".check").attr("checked")==true){
			count =parseInt($("label.hascollect a").text())-parseInt($(this).parent().children(".count").text());
			price =parseFloat($("label.all_price a").text())-parseFloat($(this).parent().children(".price").text());
			$("label.hascollect a").text(count);
			$("label.all_price a").text(price);
			
		}
		//alert($(this).parent().children(".shopcart_id").attr("value"));
		$(this).parent().hide();
	});
});


