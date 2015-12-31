/*
Once the RequireJS library has loaded it will look for the data-main attribute 
and attempt to load it asynchronously. In this case, our main.js file.
In almost all cases RequireJS will need some configuration options, 
so it makes sense that the first line of main.js is a call to require.config().
*/
requirejs.config({
    //By default any module called will load from this starting baseURL
    baseUrl: 'js/lib',
    //except, if the module ID starts with "app",
    //load it from the js/app directory. paths
    //config is relative to the baseUrl
    //never includes a ".js" extension since
    //the paths config could be for a directory.
    paths: {
        app: '../appWiki',	//any path starting with app will go into appWiki, because our base is in js/lib, we go back once, and then into appWiki
		// if you want to use CDN load jquery from the web, if you also have a backup, put that in the next array
		//JQuery uncompress and minified provide exact same functions - but uncompress has comments used for dev and min no comments used for deployment
		//more info here https://www.devbridge.com/articles/understanding-amd-requirejs/
		"jquery": 
			[
				//"http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min", //CDN loading
				"jquery-2.1.4"	// if we want to fall back to a local jquery file in case CDN fails require, use optimizer like nodeJS to minify and use minify files for deployment
			],
		"jqueryui" : "jquery-ui/jquery-ui.min"
		//jquery:     'lib/jquery',
        //domready:   'components/requirejs-domready/domReady',
        //handlebars: 'components/handlebars/handlebars'
    },
	//when moduleA depends on moduleB in a require line, and you want moduleA to load first - B will load first, thne modeule A
	shim: {
		//moduleA:{
			//deps:['moduleB']
		//}
	}
});
