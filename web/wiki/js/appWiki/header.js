define(['jquery'], function($){
	// Variables
	$(function(){

		if($('div#contents').length){ //if contents exist
			
			//creates the searchbar and main nav header div
			var str = '<section id="searchBar"></section>' +
					'<section id="mainNav"> </section>';
			$( "div#contents" ).prepend(str);
			
			console.log("[module header] - loaded");
			
		}else{
			console.log("[module header] - unsuccessfull load - div#contents not exist");
		}
		
		
		
	});

});
