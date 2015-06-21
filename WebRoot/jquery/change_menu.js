//ÇÐ»»Ö÷²Ëµ¥
$(document).ready(function(){
	$(".main_menu").each(function(){
		$(this).click(function(){
			
			var i = $(this).index();
			var Y = $(this).position().left + 120; 
			$(".main_menu").not(this).css({"background-color":"transparent","color":"#555"});
			$(this).css({"background-color":"#C40000","color":"#FFFFFF"});
			
			
			//$(".main_content").slideLeftHide(300);
			$(".main_content").not(".main_content:eq("+i+")").css("display","none");
			$(".main_content:eq("+i+")").slideLeftShow(300);
			//$(".point").show();
			//$(".point").css("left",Y);
			$(".point").animate({left:Y},500);
			 
		});
		
		
	});
});