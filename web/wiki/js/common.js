/*
Once the RequireJS library has loaded it will look for the data-main attribute 
and attempt to load it asynchronously. In this case, our main.js file.
In almost all cases RequireJS will need some configuration options, 
so it makes sense that the first line of main.js is a call to require.config().
*/
requirejs.config({
    //By default load any module IDs from js/lib
    baseUrl: 'js/lib',
    //except, if the module ID starts with "app",
    //load it from the js/app directory. paths
    //config is relative to the baseUrl, and
    //never includes a ".js" extension since
    //the paths config could be for a directory.
    paths: {
        app: '../app',	//to get to app, because our base is in js/lib, we go back once, and then into the app
		// if you want to use CDN load jquery from the web, if you also have a backup, put that in the next array
		"jquery": 
			[
				"http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min" //,
				//"jquery-min-111"	// if we were to actually include a hardcopy jquery, we'd put it int he lib folder with require
			]
		//jquery:     'lib/jquery',
        //domready:   'components/requirejs-domready/domReady',
        //handlebars: 'components/handlebars/handlebars'
    }
});

