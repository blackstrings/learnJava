define(['jquery'], function($){
	// Variables
	$(function(){

		if($('head').length){ //check if contents exist which targets the <head> element in the html
			
			//creates the searchbar and main nav header div
			var str = '<link rel="stylesheet" type="text/css" href="main.css">';
			
			//add more css styles
			//lightbox - image clicking pop up
			str += '<link rel="stylesheet" type="text/css" href="css/lightbox.css">';
			
			
			//basiicaly jquery will append the style sheet string inside the html <head> tag if it exist
			$( "head" ).append(str);
			
			console.log("[module cssTmplate1] loaded - check this file to see what css was included");
			
		}else{
			console.log("[module cssTmplate1] - unsuccessful load - html <head> tag does not exist");
		}
		
		
		
	});

});
