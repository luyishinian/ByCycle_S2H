//µÇÂ½
$(document).ready(function(){
	$("#login").click(function(){
		//$("#Mask_div").css("display","block");
		//$("#login_div").css("display","block");
		$("#Mask_div").show(500);
		$("#login_div").show(1500);
	});
	$("#regist").click(function(){
		
		document.location.href = "regist.jsp";
		
	});
   $("#login_to_regist").click(function(){
		
		document.location.href = "regist.jsp";
		
	});
   $("#Manage").click(function(){
		
		document.location.href = "manage_login.jsp";
		
	});
	
	
	$("#a_assets").click(function(){
		//$("#Mask_div").css("display","block");
		//$("#login_div").css("display","block");
		$("#Mask_div").show(500);
		$("#login_div").show(1500);
	});
	
	
	$("#a_attention").click(function(){
		//$("#Mask_div").css("display","block");
		//$("#login_div").css("display","block");
		$("#Mask_div").show(500);
		$("#login_div").show(1500);
	});
	
	
	$("#a_collection").click(function(){
		//$("#Mask_div").css("display","block");
		//$("#login_div").css("display","block");
		$("#Mask_div").show(500);
		$("#login_div").show(1500);
	});
	
	
	$("#login_off").click(function(){
		//$("#Mask_div").css("display","block");
		//$("#login_div").css("display","block");
		$("#Mask_div").hide(1500);
		$("#login_div").hide(500);
	});
	
	
	
	
});