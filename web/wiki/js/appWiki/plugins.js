define(['jquery', 'app/lightbox'], function($, lb){
	
	//by telling this file to define lightbox, as soon as this file is required in another requireJS, it is how jquery and lightbox will be loaded
	
	//a custom class
	var mod = {};
	
    //some intiial setup I want lightbox to have
	mod.loadLightBox = function(){
		//-----------------------------------------------lightbox configs
		lb.option({
			'fadeDuration':10,
			'resizeDuration':10
		});
	
		//my own custom way of dynamically making img with class name popup, when clicked become a lightbox feature
		//when img with classname 'popup' is clicked, let the img use lightbox for popup
		$('img.popup').click(function(){
		
			//check if data exist in img tag
			if($(this).data('isSet')){
				if($(this).data('isSet') == "true"){	//set data isSet to true
					//alert("true");
				}
				
				//do nothing
			}else{
				//create and assign this new data the the <img> tag element
				$(this).data("isSet","false"); 
				
				//create the lightbox attribute in the <a> tag using the values from the src attribute
				var strPre = '<a href="';
				var imgSrc = $(this).attr("src");						//get the src value
				var strPos = '" data-lightbox="defaultGroup"></a>';	//default group is just a default name, can be anything
				var fullStr = strPre + imgSrc + strPos;					//create the full str
				
				//wrap a <a> tag around the clicked <img/> tag
				$(this).wrap( fullStr);
				
				//flag that we created it already so it won't be created again
				$(this).data('isSet', 'true');
			}
			
		});
	};
	
	//this has to be last after all methods are created to load properly
	$(function(){	//on document ready only
	
		mod.loadLightBox();
		
		console.log("[module plugins] loaded [lightbox, etc]");
	});
	

});
