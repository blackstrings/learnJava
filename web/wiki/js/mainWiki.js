//The main loader of the wiki site
//after commonWiki.js is loaded, everything in here will load
//it will load the commonWiki first, as it has the common things that should be loaded on every page
require(['./commonWiki'], function (common) {
	console.log("commonWiki config is done with configs and is now loading modules");
	//after common is loaded, it will all these in asynchronous order, meaning all will load at the same time without waiting for another to complete
	
	//when you say require, you want all the dependencies of that jS file to load.
	//when to use define, when ou are defining a module like cssTmeplate1, mainNav, font, etc
	require(['app/cssTemplate1', 	//controls what css is loaded
			'app/mainNav', 			// takes care of search box navigation
			'app/font', 
			'app/layoutMod', 		//mod the layout
			'app/header', 
			'app/footer',
			'app/plugins']);		//loads other plugins such as, light box which allows img click popup
			
	
});