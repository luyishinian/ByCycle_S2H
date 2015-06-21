//用户未登录时的侧边栏
$(document).ready(function(){
	
	$("#main_menu ul li").mouseover(function(){
		
		$(this).find('div').show();
		$(this).find('div').animate({right:'30px',opacity:'1'},500);
		});
	$("#main_menu ul li").mouseleave(function(){
		$(this).find('div').animate({right:'80px',opacity:'0'});
		$(this).find('div').hide();
		});
	
	
});