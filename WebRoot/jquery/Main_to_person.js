//用户浏览个人主页
$(document).ready(function(){
    $("#u_img").click(function(){
		
		//document.location.href = "personal.jsp";
		window.open("personal.jsp");
	});
   $("#user_look").click(function(){
		
		//document.location.href = "personal.jsp";
	   window.open("personal.jsp");
	   $("#user_menu").toggle(300);
		
	});
   
   $("#username a").click(function(){
		
		$("#user_menu").toggle(300);
		
	});
    $("#user_out").click(function(){
		
		document.location.href = "index.jsp";
		
	});
});
