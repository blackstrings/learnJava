define(['jquery'], function($){
	// Variables
	$(function(){

		if($('div#contents').length){ //if contents exist
			//append the footer
			$( "div#contents" ).append( '<section id="mainFooter"></section>');
		
			//populate the footer with data
			var startYear = 2014;

			var date = new Date();
			var currentYear = date.getFullYear()

			finalStr = "";
			finalStr += "<footer id=\"main\">";
			finalStr += "Copyright &copy; " + startYear + " - " + currentYear;
			finalStr += "</footer>";
			
			$("#mainFooter").html(finalStr);
			
			console.log("[module footer] loaded");
		
		}else{
			console.log("[module footer] unsuccessful load - div#contents not exist");
		}
		
	});

});
