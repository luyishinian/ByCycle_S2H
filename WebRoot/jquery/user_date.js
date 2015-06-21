

function showpic(){
	var odiv_file = document.getElementById("file_pic");
	var pic_URL =  window.URL.createObjectURL(odiv_file.files[0]);
	 var odiv_pic = document.getElementById("change_u_img");
     //odiv_pic.style.display ="block";
     odiv_pic.src = pic_URL;
}

$(document).ready(function(){
	
	$(".confirm").click(function(){
		var odiv_file = document.getElementById("file_pic");
		var pic_URL =  window.URL.createObjectURL(odiv_file.files[0]);
		
		$(".u_img").attr("src",pic_URL);
		$(".div_uppic").hide(500);
	    
	
	});
	$(".file_span").click(function(){
		$(".div_uppic").show(500);
	
	});
	$(".remove").click(function(){
		$(".div_uppic").hide(500);
	
	});
});