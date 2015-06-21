//Main 界面实现的图片切换
$(document).ready(function(){
	$(".main_img").each(function(){
			 $(this).mouseover(function(){
				 var i = $(this).index()-2;
				 $(".main_img").css("zIndex","3");
				 $(".main_img:eq("+i+")").css("zIndex","10");
	        });
			 
	});
});