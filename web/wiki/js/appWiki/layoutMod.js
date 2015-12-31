define(['jquery'], function($){
	// Variables
	$(function(){	// on document ready
	
		//if div#contents exist
		if($('div#contents').length){ 
		
			//creates an outside border around the entire body
			$( "div#contents" ).wrap( '<div id="mainBorder"></div>');

			console.log("[module layoutMod] loaded div mainBorder wrapped");
		}else{
			console.log("[module layoutMod] loaded #contents not exist");
		}
	});

});
