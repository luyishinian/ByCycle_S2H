//¶¥²¿Í¼Æ¬×Ô¶¯ÇÐ»»
jQuery.fn.slideLeftHide = function( speed, callback ) {  
        this.animate({  
            width : "hide",  
            paddingLeft : "hide",  
            paddingRight : "hide",  
            marginLeft : "hide",  
            marginRight : "hide"  
        }, speed, callback );  
    };  
    jQuery.fn.slideLeftShow = function( speed, callback ) {  
        this.animate({  
            width : "show",  
            paddingLeft : "show",  
            paddingRight : "show",  
            marginLeft : "show",  
            marginRight : "show"  
        }, speed, callback );  
    };  

$(document).ready(function(){
	 var x = 0;
	 changepic(x);
	 $(".bt_pic").each(function(){
		 $(this).click(function(){
			 var i = $(this).index();
			 
			 $(".bt_pic").not(this).css({"background-color":"rgba(160,160,160,.4)","color":"#555"});
			 $(this).css({"background-color":"#CF0000","color":"#FFF"});
			 $(".img").not(".img:eq("+i+")").slideLeftHide(300);
			 $(".img:eq("+i+")").slideLeftShow(300);
			 
			 //changepic(i);
		 });
	 });
	 
     
});


function changepic(c){
	 i = c%4;
	 $(".bt_pic").css({"background-color":"rgba(160,160,160,.4)","color":"#555"});
	 $(".bt_pic:eq("+i+")").css({"background-color":"#CF0000","color":"#FFF"});
	 $(".img").slideLeftHide(300);
	 $(".img:eq("+i+")").slideLeftShow(300);
	 if(c<3){
		 c=c+1;
	 }
	 else{
		 c =0;
	 }
	 t=setTimeout("changepic("+c+")",5000);
	
}
	
