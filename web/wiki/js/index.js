//it will load the common as it has the common things that should be loaded on every page
require(['./common'], function (common) {
	console.log("common loaded");
	//after common is loaded, it will run mainIndex.js
	require(['app/indexContents']);
});



