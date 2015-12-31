//this method is not dependent on any other modules
define(function () {
//if dependent on other moduels use this instead
//define(["app/moduleName", "app/moduleName2"], function(module1, module2){
	//then you can use the modules like: module1.method1();

	
	//this will auto run unless you want to turn this into an object and call it manually unlock the below comments and remove this code here
	//-----------------------------------------------------------------------------------
	WebFontConfig = {
		google: { families: [ 'Open Sans', 'sans-serif' ] }
		  };
			// 'Roboto+Condensed::latin'
				// font-family: 'Roboto Condensed', 'sans-serif';
			// 'Dosis::latin'
				// font-family: 'Dosis', 'sans-serif';
			// 'Montserrat::latin'
				// font-family: 'Montserrat', 'sans-serif';
			//	'Open Sans', 'sans-serif'
				// font-family: 'Open Sans', 'sans-serif';
		  (function() {
			var wf = document.createElement('script');
			wf.src = ('https:' == document.location.protocol ? 'https' : 'http') +
			  '://ajax.googleapis.com/ajax/libs/webfont/1/webfont.js';
			wf.type = 'text/javascript';
			wf.async = 'true';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(wf, s);
		  })();
	//----------------------------------------------------------------------------------------------
	
	console.log("[module font] loaded");
	
	/* turn this on when you want to turn this into a class like obj
	var mod = {};
	
    //method 1
	mod.test = function(){
		console.log("font test working");
	};
	
	//public
	mod.init = function() {

		WebFontConfig = {
		google: { families: [ 'Open Sans', 'sans-serif' ] }
		  };
			// 'Roboto+Condensed::latin'
				// font-family: 'Roboto Condensed', 'sans-serif';
			// 'Dosis::latin'
				// font-family: 'Dosis', 'sans-serif';
			// 'Montserrat::latin'
				// font-family: 'Montserrat', 'sans-serif';
			//	'Open Sans', 'sans-serif'
				// font-family: 'Open Sans', 'sans-serif';
		  (function() {
			var wf = document.createElement('script');
			wf.src = ('https:' == document.location.protocol ? 'https' : 'http') +
			  '://ajax.googleapis.com/ajax/libs/webfont/1/webfont.js';
			wf.type = 'text/javascript';
			wf.async = 'true';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(wf, s);
		  })();
		
	};
	
	//private
	function createMainNav() {
		//dosomething
		//return something
	}
	
	return mod;
	*/
});