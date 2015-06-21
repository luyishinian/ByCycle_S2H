$(document).ready(function(){
	var as = $("#menu_div>ul>a");
	as.click(function(){
		var aNode = $(this);
		var lis = aNode.nextAll("li");
		lis.toggle(500);
	});
	
	$(".top_menu_li").each(function(){
		$(this).click(function(){
			var Y = $(this).position().left+$(this).width()/2+240;
			$(".point").animate({left:Y},500);
		});
	});
	
$("#li_account").mouseover(function(){
	    $(this).find("#account_setup").show();
	    var Y = $(this).position().left+$(this).width()/2+240;
		//$(".point").animate({left:Y},500);  
	    $(".point").css({"left":Y,"top":"25px"});
		});
	$("#li_account").mouseleave(function(){
		$(this).find("#account_setup").hide();
		//$(".point").animate({left:296},500);
		$(".point").css({"left":"296px","top":"30px"});
		});
});